package org.example.Components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.util.Pair;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.example.Exception.TableException;
import org.example.model.*;
import org.example.model.conditions.ComparisonOperator;
import org.example.model.conditions.ConditionExpression;
import org.example.model.conditions.ConditionNode;
import org.example.model.conditions.LogicalConditionNode;
import org.example.model.table.TableAssignment;
import org.example.model.table.TableDefinition;
import org.example.statement.DeleteStatement;
import org.example.statement.FindRecordStatement;
import org.example.statement.UpdateStatement;
import scala.Tuple2;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StorageManager {

    private static final String META_FILE_PATH = "src/main/resources/Tables/meta.json";

    private static final String STORAGE_PATH = "src/main/resources/Tables/";
    private static StorageManager instance;

    private static SparkReader sparkReader;

    private MetaData metaData;

    private StorageManager() {
        loadMetaData();
        sparkReader = SparkReader.getInstance();
    }

    public static StorageManager getInstance() {
        if (instance == null) {
            instance = new StorageManager();
        }
        return instance;
    }

    public static void setInstance(StorageManager instance) {
        StorageManager.instance = instance;
    }

    public MetaData getMetaData() {
        return metaData;
    }

    private void loadMetaData() {
        File file = new File(META_FILE_PATH);
        if (!file.exists()) {
            this.metaData = new MetaData();
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                this.metaData = objectMapper.readValue(file, MetaData.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createTableMetaData(TableDefinition definition) throws TableException {
        if (this.metaData == null) {
            loadMetaData();
        } else {
            Map<String, TableDefinition> tableDefinitionMap = this.metaData.getTableDefinitionMap();
            if (tableDefinitionMap.containsKey(definition.getName())) {
                throw new TableException("Table " + definition.getName() + " already exist");
            }
            tableDefinitionMap.put(definition.getName(), definition);
            // write to file and create storage file
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            try {
                objectMapper.writeValue(new File(META_FILE_PATH), this.metaData);
                File tableStorageFile = new File(STORAGE_PATH + definition.getFileList().get(0));
                tableStorageFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void dropTable(String tableName) throws TableException {
        if (!metaData.getTableDefinitionMap().containsKey(tableName)) {
            throw new TableException("Table does not exist");
        }
        // drop meta data and storage file
        for (String filePath : this.metaData.getTableDefinitionMap().get(tableName).getFileList()) {
            File file = new File(STORAGE_PATH + filePath);
            file.delete();
        }
        metaData.getTableDefinitionMap().remove(tableName);
        updateMetadata();
        //

    }

    private void updateMetadata() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File(META_FILE_PATH), this.metaData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertRecord(TableAssignment tableAssignment) throws TableException {
        String tableName = tableAssignment.getTableName();
        if (!this.metaData.getTableDefinitionMap().containsKey(tableName)) {
            throw new TableException("Table does not exist");
        }
        String outputFile = this.metaData.getTableDefinitionMap().get(tableName).getFileList().get(0);
        File file = new File(STORAGE_PATH + outputFile);
        try {
            if (file.exists()) {
                long fileSize = file.length();
                if (fileSize / 1024 > 64) {
                    // exceed limited size
                    // create a new file
                    Pattern pattern = Pattern.compile(tableName + "(\\d+)\\.txt");
                    Matcher matcher = pattern.matcher(outputFile);
                    if (matcher.find()) {
                        int fileIndex = Integer.parseInt(matcher.group(1)) + 1;
                        outputFile = tableName + fileIndex + ".txt";
                        File newFile = new File(STORAGE_PATH + outputFile);
                        this.metaData.getTableDefinitionMap().get(tableName)
                                .getFileList().add(0, tableName + fileIndex + ".txt");
                        newFile.createNewFile();
                        System.out.println(fileIndex);
                    }
                }
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // check data type
        TableDefinition tableDefinition = this.metaData.getTableDefinitionMap().get(tableName);
        Map<String, ColumnInfo> columns = tableDefinition.getColumns();

        // it's linkedHashSet, so the order is fixed.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STORAGE_PATH + outputFile, true))) {
            StringBuilder sb = new StringBuilder();
            // *******
            sb.append(1 + "\t");
            for (String key : columns.keySet()) {
                String dataType = columns.get(key).getType();
                String value = tableAssignment.getAssignments().get(key);
                if (dataType.equals("int")) {
                    try {
                        int res = Integer.parseInt(value);
                        sb.append(res + "\t");
                    } catch (NumberFormatException e) {
                        throw new TableException("Expected Integer for column " + key);
                    }
                } else if (dataType.equals("float")) {
                    try {
                        double res = Double.parseDouble(value);
                        sb.append(res + "\t");
                    } catch (NumberFormatException e) {
                        throw new TableException("Expected Float for column " + key);
                    }
                } else if (dataType.startsWith("s") || dataType.startsWith("S")) {
                    if (value.charAt(0) != '\'' || value.charAt(value.length() - 1) != '\'') {
                        throw new TableException("Expected String for column " + key);
                    }
                    String dataValue = value.substring(1, value.length() - 1);
                    String lengthStr = dataType.substring(dataType.indexOf('(') + 1, dataType.indexOf(')'));
                    int length = Integer.parseInt(lengthStr);
                    if (dataValue.length() > length) {
                        throw new TableException("Value " + dataValue + " for column '" + key + "' exceed the max length");
                    }
                    sb.append(dataValue + "\t");
                }
            }
            writer.write(sb.toString() + "\n");
        } catch (IOException e) {
            System.out.println(STORAGE_PATH + outputFile);
            e.printStackTrace();
            throw new TableException("Error occurred when inserting the data");
        }
        updateMetadata();

    }


    public void findRecord(FindRecordStatement statement) throws TableException {
        List<JoinClause> joinClause = statement.getJoinClause();
        if (joinClause == null || joinClause.size() == 0) {
            // single table
            String tableName = statement.getTableName();
            if (!this.metaData.getTableDefinitionMap().containsKey(tableName)) {
                throw new TableException("Table " + tableName + " not exist");
            }
            // check selected columns
            List<Integer> indexes = new ArrayList<>();
            List<String> dataTypes = new ArrayList<>();

            Set<String> unAggregatedColumns = new HashSet<>();
            Set<String> aggregatedColumns = new HashSet<>();
            List<Integer> unAggregatedColumnIndex = new ArrayList<>();
            List<Integer> aggregatedColumnIndex = new ArrayList<>();
            List<String> aggregateColumnTypes = new ArrayList<>();
            List<String> columnAggregateTypes = new ArrayList<>();

            Map<String, ColumnInfo> columnsInfo = this.metaData.getTableDefinitionMap().get(tableName).getColumns();
            List<SelectedColumn> selectedColumns = statement.getSelectedColumn();

            for (int i = 0; i < selectedColumns.size(); i ++) {
                SelectedColumn column = selectedColumns.get(i);
                String columnTableName = column.getTableName();
                String columnName = column.getColumnName();
                AggregateType aggregateType = column.getType();
                if (columnTableName != null && !columnTableName.equals(tableName)) {
                    throw new TableException("Mismatched table name between " + columnTableName + " and " + tableName);
                }
                if (Objects.equals(columnName, "*")) {
                    continue;
                }
                if (!columnsInfo.containsKey(columnName)) {
                    throw new TableException("Cannot find column " + columnName + " in " + tableName);
                }

                if (aggregateType != null) {
                    if (!aggregateType.equals(AggregateType.COUNT) && (columnsInfo.get(columnName).getType().startsWith("s") || columnsInfo.get(columnName).getType().startsWith("s"))) {
                        throw new TableException("Cannot perform aggregate function other than COUNT on String column");
                    }
                    aggregatedColumns.add(columnName);
                    aggregatedColumnIndex.add(i);
                    aggregateColumnTypes.add(columnsInfo.get(columnName).getType());
                    columnAggregateTypes.add(String.valueOf(aggregateType));
                } else {
                    unAggregatedColumns.add(columnName);
                    unAggregatedColumnIndex.add(i);
                }
                indexes.add(columnsInfo.get(columnName).getIndex());
                dataTypes.add(columnsInfo.get(columnName).getType());
            }
            checkCondition(tableName, statement.getCondition());

            // check group by
            boolean needGroupBy = false;
            List<SelectedColumn> groupByColumn = statement.getGroupByColumn();
            if (groupByColumn == null && aggregatedColumns.size() != 0) {
                // if group by column is null
                // two options
                // 1. no aggregate functions
                // 2. in having clause, the un-aggregated column is assigned with values (must use =);
                // ignore this, must have group by clause in any scenario. because it doesn't affect the result.
                throw new TableException("Missing Group By clause!");
            }

            if (aggregatedColumns.size() == 0 && groupByColumn != null) {
                throw new TableException("Group By clause contains nonaggregated column");
            }

            if (aggregatedColumns.size() != 0) {
                if (unAggregatedColumns.size() != groupByColumn.size()) {
                    throw new TableException("Missing nonaggregated column in group by clause or Group By clause contains aggregated column");
                }
                for (SelectedColumn column : groupByColumn) {
                    String groupByTableName = column.getTableName();
                    String groupByColumnName = column.getColumnName();
                    if (groupByTableName != null && !groupByTableName.equals(tableName)) {
                        throw new TableException("Mismatched table name between " + groupByTableName + " and " + tableName);
                    }
                    if (!columnsInfo.containsKey(groupByColumnName)) {
                        throw new TableException("Cannot find column " + groupByColumnName + " in " + tableName);
                    }
                    if (!unAggregatedColumns.contains(groupByColumnName)) {
                        throw new TableException("Group By clause contains aggregated column");
                    }
                }
                needGroupBy = true;
            }
            // access table, select all columns first
            List<String> fileList = this.metaData.getTableDefinitionMap().get(tableName).getFileList();

            for (String path : fileList) {
                // filtering and projection
                JavaRDD<List<Object>> rdd = sparkReader.readTableDataWithCondition(STORAGE_PATH + path,
                        indexes,
                        dataTypes,
                        columnsInfo,
                        statement.getCondition());
                // group by and aggregate
                if (needGroupBy) {
                    System.out.println("need group by");
                    System.out.println(aggregatedColumnIndex);
                    System.out.println(unAggregatedColumnIndex);
                    JavaPairRDD<List<Object>, List<Object>> pairRDD = rdd.mapToPair(row -> {
                        List<Object> key = new ArrayList<>();
                        List<Object> value = new ArrayList<>();
                        for(Integer index: unAggregatedColumnIndex) {
                            key.add(row.get(index));
                        }
                        for(Integer index: aggregatedColumnIndex) {
                            value.add(row.get(index));
                        }
                        return new Tuple2<>(key, value);
                    });
//                    pairRDD.collect().forEach(System.out::println);
                    JavaPairRDD<List<Object>, Iterable<List<Object>>> javaPairRDD = pairRDD.groupByKey();
                    int size = aggregatedColumns.size();
                    JavaRDD<Tuple2<List<Object>, List<List<Object>>>> map = javaPairRDD.map(row -> {
                        List<Object> key = row._1();
                        List<List<Object>> value = new ArrayList<>();
                        for (int i = 0; i < size; i++) {
                            ArrayList<Object> objects = new ArrayList<>();
                            int finalI = i;
                            row._2().forEach(val -> {
                                objects.add(val.get(finalI));
                            });
                            value.add(objects);
                        }
                        return new Tuple2<>(key, value);
                    });
                    JavaRDD<Tuple2<List<Object>, List<Object>>> resultRDD = map.map(row -> {
                        List<Object> key = row._1();
                        List<List<Object>> value = row._2();

                        // Calculate the mean of the first list
                        List<Object> res = new ArrayList<>();
                        for(int i = 0; i < aggregateColumnTypes.size(); i ++) {
                            String dataType = aggregateColumnTypes.get(i);
                            String aggregateType = columnAggregateTypes.get(i);
                            List<Object> list = value.get(i);
                            if(dataType.equalsIgnoreCase("float")) {
                                DoubleStream doubleStream = list.stream().mapToDouble(val -> (double) val);
                                switch (aggregateType) {
                                    case "AVG" -> {res.add(doubleStream.average().orElse(0.0));}
                                    case "MAX" -> {res.add(doubleStream.max().orElse(0.0));}
                                    case "MIN" -> {res.add(doubleStream.min().orElse(0.0));}
                                    case "SUM" -> {res.add(doubleStream.sum());}
                                    case "COUNT" -> {res.add(doubleStream.count());}
                                }
                            } else if(dataType.equalsIgnoreCase("int")) {
                                IntStream intStream = list.stream().mapToInt(val -> (int) val);
                                switch (aggregateType) {
                                    case "AVG" -> {res.add(intStream.average().orElse(0.0));}
                                    case "MAX" -> {res.add(intStream.max().orElse(0));}
                                    case "MIN" -> {res.add(intStream.min().orElse(0));}
                                    case "SUM" -> {res.add(intStream.sum());}
                                    case "COUNT" -> {res.add(intStream.count());}
                                }
                            }
                        }
                        return new Tuple2<>(key, res);
                    });
                    resultRDD.collect().forEach(System.out::println);
//                    resultRDD.collect().forEach(System.out::println);
//                    map.collect().forEach(System.out::println);
                } else {
                    rdd.collect().forEach(System.out::println);
                }

            }

        } else {

        }
    }


    private void checkCondition(String tableName, ConditionNode condition) throws TableException {
        TableDefinition tableDefinition = this.metaData.getTableDefinitionMap().get(tableName);
        Map<String, ColumnInfo> columnsDefinition = tableDefinition.getColumns();
        if (condition instanceof ConditionExpression expression) {
            // only one condition
            String selectedTableName = expression.getColumnName().getTableName();
            String columnName = expression.getColumnName().getColumnName();
            String value = expression.getValue();
            if (selectedTableName != null && !selectedTableName.equals(tableName)) {
                throw new TableException("Mismatched table names: " + tableName + " and " + selectedTableName);
            }
            if (!columnsDefinition.containsKey(columnName)) {
                throw new TableException("Column " + columnName + " does not exist in table " + tableName);
            }
            System.out.println(columnName);
            String dataType = columnsDefinition.get(columnName).getType();

            checkColumnConditionValidity(columnName, dataType, value, expression.getComparator());

        }
        if (condition instanceof LogicalConditionNode logicalConditionNode) {
            checkCondition(tableName, logicalConditionNode.getLeft());
            checkCondition(tableName, logicalConditionNode.getRight());
        }
    }


    private void checkColumnConditionValidity(String columnName, String dataType, String value, ComparisonOperator comparator) throws TableException {
        if (dataType.equals("int")) {
            try {
                int res = Integer.parseInt(value);
            } catch (NumberFormatException e) {
                throw new TableException("Expected Integer for column " + columnName);
            }
        } else if (dataType.equals("float")) {
            try {
                double res = Double.parseDouble(value);
            } catch (NumberFormatException e) {
                throw new TableException("Expected Float for column " + columnName);
            }
        } else if (dataType.startsWith("string") || dataType.startsWith("String")) {
            if (comparator != ComparisonOperator.EQ && comparator != ComparisonOperator.NEQ) {
                throw new TableException("Invalid operator >,>=,<=,< for column(String) " + columnName);
            }
            if (value.charAt(0) != '\'' || value.charAt(value.length() - 1) != '\'') {
                throw new TableException("Expected String for column " + columnName);
            }
            String dataValue = value.substring(1, value.length() - 1);
            String lengthStr = dataType.substring(dataType.indexOf('(') + 1, dataType.indexOf(')'));
            int length = Integer.parseInt(lengthStr);
            if (dataValue.length() > length) {
                throw new TableException("Value " + dataValue + " for column '" + columnName + "' exceed the max length");
            }
        }
    }


    public void deleteWithCondition(DeleteStatement statement) throws TableException {
        String tableName = statement.getTableName();
        ConditionNode condition = statement.getCondition();
        checkCondition(tableName, condition);
        // check
        List<String> fileList = this.metaData.getTableDefinitionMap().get(tableName).getFileList();
        if (condition instanceof ConditionExpression expression) {
            for (String filePath : fileList) {
                String selectedTableName = expression.getColumnName().getTableName();
                if (selectedTableName != null && !selectedTableName.equals(tableName)) {
                    throw new TableException("Mismatched table names");
                }
                String columnName = expression.getColumnName().getColumnName();
                int columnIndex = this.metaData.getTableDefinitionMap().get(tableName).getColumns().get(columnName).getIndex();
                String dataType = this.metaData.getTableDefinitionMap().get(tableName).getColumns().get(columnName).getType();
                ComparisonOperator comparator = expression.getComparator();
                String value = expression.getValue();
                sparkReader.deleteTableDataWithCondition(STORAGE_PATH + filePath, columnIndex, dataType, value, comparator);
            }
        } else if (condition instanceof LogicalConditionNode logicalNode) {
            for (String filePath : fileList) {
                sparkReader.deleteTableDataWithConditionList(logicalNode, STORAGE_PATH + filePath, this.metaData.getTableDefinitionMap().get(tableName).getColumns());
            }
        }

    }


    public void deleteAllData(String tableName) {
        List<String> fileList = this.getMetaData().getTableDefinitionMap().get(tableName).getFileList();
        for (String file : fileList) {
            File file1 = new File(STORAGE_PATH + file);
            file1.delete();
        }
        this.metaData.getTableDefinitionMap().get(tableName).setFileList(List.of(tableName + "1.txt"));
        File newFile = new File(STORAGE_PATH + tableName + "1.txt");
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void checkColumnAssignment(String columnName, String dataValue, String dataType) throws TableException {
        if (dataType.equals("int")) {
            try {
                Integer.parseInt(dataValue);
            } catch (NumberFormatException e) {
                throw new TableException("Expected Integer for column " + columnName);
            }
        } else if (dataType.equals("float")) {
            try {
                Double.parseDouble(dataValue);
            } catch (NumberFormatException e) {
                throw new TableException("Expected Float for column " + columnName);
            }
        } else {
            if (dataValue.charAt(0) != '\'' || dataValue.charAt(dataValue.length() - 1) != '\'') {
                throw new TableException("Expected String for column " + columnName);
            }
            String dValue = dataValue.substring(1, dataValue.length() - 1);
            String lengthStr = dataType.substring(dataType.indexOf('(') + 1, dataType.indexOf(')'));
            int length = Integer.parseInt(lengthStr);
            if (dValue.length() > length) {
                throw new TableException("Value " + dataValue + " for column '" + columnName + "' exceed the max length");
            }
        }
    }

    public void updateAllData(UpdateStatement statement) throws TableException {
        System.out.println("update all");
        String tableName = statement.getTableName();
        // check table name
        if (!this.metaData.getTableDefinitionMap().containsKey(tableName)) {
            throw new TableException("Table does not exist");
        }

        // check column name and data type
        List<ColumnAssignment> assignments = statement.getAssignments();
        Map<String, ColumnInfo> columnsInfo = this.metaData.getTableDefinitionMap().get(tableName).getColumns();
        for (ColumnAssignment assignment : assignments) {
            String columnName = assignment.getColumnName();
            String dataValue = assignment.getDataValue();
            if (!columnsInfo.containsKey(columnName)) {
                throw new TableException("Column " + columnName + " does not exist in Table " + tableName);
            }
            String dataType = columnsInfo.get(columnName).getType();
            checkColumnAssignment(columnName, dataValue, dataType);
        }

        List<String> fileList = this.getMetaData().getTableDefinitionMap().get(tableName).getFileList();
        List<Integer> index = new ArrayList<>();
        List<String> value = new ArrayList<>();
        for (ColumnAssignment assignment : assignments) {
            String columnName = assignment.getColumnName();
            index.add(columnsInfo.get(columnName).getIndex());
            if (assignment.getDataValue().startsWith("\'")) {
                String dValue = assignment.getDataValue();
                value.add(dValue.substring(1, dValue.length() - 1));
            } else {
                value.add(assignment.getDataValue());
            }

        }
        for (String filePath : fileList) {
            updateFile(filePath, index, value);
        }
    }

    private void updateFile(String filePath,
                            List<Integer> index,
                            List<String> value) {
        String outputFile = STORAGE_PATH + "tmp.txt";
        File newFile = new File(outputFile);

        try {
            newFile.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(STORAGE_PATH + filePath));
            List<String> modifiedLines = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split("\t");

                // Modify the specified columns
                for (int i = 0; i < index.size(); i++) {
                    int columnIndex = index.get(i);
                    String modifyValue = value.get(i);
                    columns[columnIndex] = modifyValue;
                }

                modifiedLines.add(String.join("\t", columns));
            }

            reader.close();

            // Write the modified data to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            for (String modifiedLine : modifiedLines) {
                writer.write(modifiedLine);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File originalFile = new File(STORAGE_PATH + filePath);
        originalFile.delete();
        newFile.renameTo(originalFile);

    }

    public void updateWithCondition(UpdateStatement statement) throws TableException {
        System.out.println("update with condition");
        String tableName = statement.getTableName();
        if (!this.metaData.getTableDefinitionMap().containsKey(tableName)) {
            throw new TableException("Table " + tableName + " does not exist");
        }

        // check column assignments
        List<ColumnAssignment> assignments = statement.getAssignments();
        Map<String, ColumnInfo> columnsInfo = this.metaData.getTableDefinitionMap().get(tableName).getColumns();
        for (ColumnAssignment assignment : assignments) {
            String columnName = assignment.getColumnName();
            String dataValue = assignment.getDataValue();
            if (!columnsInfo.containsKey(columnName)) {
                throw new TableException("Column " + columnName + " does not exist in Table " + tableName);
            }
            String dataType = columnsInfo.get(columnName).getType();
            checkColumnAssignment(columnName, dataValue, dataType);
        }

        // check condition node
        checkCondition(tableName, statement.getCondition());

        // update file
        List<Integer> index = new ArrayList<>();
        List<String> value = new ArrayList<>();
        for (ColumnAssignment assignment : assignments) {
            String columnName = assignment.getColumnName();
            index.add(columnsInfo.get(columnName).getIndex());
            if (assignment.getDataValue().startsWith("\'")) {
                String dValue = assignment.getDataValue();
                value.add(dValue.substring(1, dValue.length() - 1));
            } else {
                value.add(assignment.getDataValue());
            }

        }
        List<String> fileList = this.metaData.getTableDefinitionMap().get(tableName).getFileList();
        for (String filePath : fileList) {
            List<Long> rowList = sparkReader.updateTableWithCondition(STORAGE_PATH + filePath, index, value, statement.getCondition(), columnsInfo);
            updateFileWithCondition(filePath, rowList, index, value);
        }

    }

    private void updateFileWithCondition(String filePath, List<Long> rowList, List<Integer> index, List<String> value) {
        String outputFile = STORAGE_PATH + "tmp.txt";
        File newFile = new File(outputFile);

        try {
            newFile.createNewFile();
            BufferedReader reader = new BufferedReader(new FileReader(STORAGE_PATH + filePath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            int currentRow = 0;

            while ((line = reader.readLine()) != null) {
                // Check if the current row should be updated
                if (rowList.contains((long) currentRow)) {
                    String[] columns = line.split("\t");

                    // Modify the specified columns
                    for (int i = 0; i < index.size(); i++) {
                        int columnIndex = index.get(i);
                        String modifyValue = value.get(i);
                        columns[columnIndex] = modifyValue;
                    }

                    // Write the modified line to the output file
                    writer.write(String.join("\t", columns));
                    writer.newLine();
                } else {
                    // If the row should not be updated, write it as is
                    writer.write(line);
                    writer.newLine();
                }
                currentRow++;
            }

            reader.close();
            writer.close();

            // Delete the original file and rename the new file
            File originalFile = new File(STORAGE_PATH + filePath);
            originalFile.delete();
            newFile.renameTo(originalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
