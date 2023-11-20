package org.example.Components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.example.Exception.TableException;
import org.example.model.*;
import org.example.model.conditions.*;
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
                if (!tableAssignment.getAssignments().containsKey(key)) {
                    throw new TableException("Mismatched column for " + key);
                }
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


    public void findRecordSingle(FindRecordStatement statement) throws TableException {
        String tableName = statement.getTableName();
        if (!this.metaData.getTableDefinitionMap().containsKey(tableName)) {
            throw new TableException("Table " + tableName + " not exist");
        }
        int sortByIndex = -1;
        String sortByColumnName = null;
        if (statement.getSortByColumn() != null) {
            SelectedColumn sortByColumn = statement.getSortByColumn();
            if(sortByColumn.getTableName() == null) {
                // do nothing
            }
            else if(sortByColumn.getTableName() != null && !this.metaData.getTableDefinitionMap().containsKey(sortByColumn.getTableName())) {
                throw new TableException("Cannot find table " + sortByColumn.getTableName() + " in sort clause");
            }else if(!this.metaData.getTableDefinitionMap().get(sortByColumn.getTableName()).getColumns().containsKey(sortByColumn.getColumnName())) {
                throw new TableException("Cannot find column  " + sortByColumn.getColumnName() + " in table " + sortByColumn.getTableName() + " in sort by column");
            }
            sortByColumnName = sortByColumn.getColumnName();
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
        if (statement.getSelectedColumn().size() == 1 && statement.getSelectedColumn().get(0).getColumnName().equals("*")) {
            List<String> fileList = this.metaData.getTableDefinitionMap().get(tableName).getFileList();
            for (String s : columnsInfo.keySet()) {
                indexes.add(columnsInfo.get(s).getIndex());
                dataTypes.add(columnsInfo.get(s).getType());
            }
            for (String file : fileList) {
                JavaRDD<List<Object>> rdd = sparkReader.readTableDataWithCondition(STORAGE_PATH + file,
                        indexes,
                        dataTypes,
                        columnsInfo,
                        statement.getCondition());
                rdd.collect().forEach(System.out::println);
            }
            return;
        }
        for (int i = 0; i < selectedColumns.size(); i++) {
            SelectedColumn column = selectedColumns.get(i);
            String columnTableName = column.getTableName();
            String columnName = column.getColumnName();
            AggregateType aggregateType = column.getType();

            if (columnTableName != null && !columnTableName.equals(tableName)) {
                throw new TableException("Mismatched table name between " + columnTableName + " and " + tableName);
            }
            if (Objects.equals(columnName, "*")) {
                //todo:
                continue;

            }
            if (!columnName.equals("*") && !columnsInfo.containsKey(columnName)) {
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
            if(columnName.equals(sortByColumnName)) {
                sortByIndex = i;
            }
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
        JavaRDD<Tuple2<List<Object>, List<Object>>> combinedRDD = null;
        JavaRDD<List<Object>> finalRDD = null;
        for (String path : fileList) {
            // filtering and projection
            JavaRDD<List<Object>> rdd = sparkReader.readTableDataWithCondition(STORAGE_PATH + path,
                    indexes,
                    dataTypes,
                    columnsInfo,
                    statement.getCondition());
            // group by and aggregate
            if (needGroupBy) {
//                System.out.println(aggregatedColumnIndex);
//                System.out.println(unAggregatedColumnIndex);
                JavaPairRDD<List<Object>, List<Object>> pairRDD = rdd.mapToPair(row -> {
                    List<Object> key = new ArrayList<>();
                    List<Object> value = new ArrayList<>();
                    for (Integer index : unAggregatedColumnIndex) {
                        key.add(row.get(index));
                    }
                    for (Integer index : aggregatedColumnIndex) {
                        value.add(row.get(index));
                    }
                    return new Tuple2<>(key, value);
                });
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
                    for (int i = 0; i < aggregateColumnTypes.size(); i++) {
                        String dataType = aggregateColumnTypes.get(i);
                        String aggregateType = columnAggregateTypes.get(i);
                        List<Object> list = value.get(i);
                        if (dataType.equalsIgnoreCase("float")) {
                            DoubleStream doubleStream = list.stream().mapToDouble(val -> (double) val);
                            switch (aggregateType) {
                                case "AVG" -> {
                                    double sum = doubleStream.sum();
                                    long count = list.stream().mapToDouble(val -> (double) val).count();
                                    if (count > 0) {
                                        res.add("" + sum + "/" + count);
                                    } else {
                                        // Handle the case when the stream is empty
                                        res.add("0/0");
                                    }
                                }
                                case "MAX" -> {
                                    res.add(doubleStream.max().orElse(0.0));
                                }
                                case "MIN" -> {
                                    res.add(doubleStream.min().orElse(0.0));
                                }
                                case "SUM" -> {
                                    res.add(doubleStream.sum());
                                }
                                case "COUNT" -> {
                                    res.add(doubleStream.count());
                                }
                            }
                        } else if (dataType.equalsIgnoreCase("int")) {
                            IntStream intStream = list.stream().mapToInt(val -> (int) val);
                            switch (aggregateType) {
                                case "AVG" -> {
                                    int sum = intStream.sum();
                                    long count = list.stream().mapToInt(val -> (int) val).count();

                                    if (count > 0) {
                                        res.add("" + sum + "/" + count);
                                    } else {
                                        // Handle the case when the stream is empty
                                        res.add("0/0");
                                    }
                                }
                                case "MAX" -> {
                                    res.add(intStream.max().orElse(0));
                                }
                                case "MIN" -> {
                                    res.add(intStream.min().orElse(0));
                                }
                                case "SUM" -> {
                                    res.add(intStream.sum());
                                }
                                case "COUNT" -> {
                                    res.add(intStream.count());
                                }
                            }
                        } else if (dataType.startsWith("s") || dataType.startsWith("S")) {
                            res.add(list.size());
                        }
                    }
                    return new Tuple2<>(key, res);
                });
                if (combinedRDD == null) {
                    combinedRDD = resultRDD;
                } else {
                    combinedRDD = combinedRDD.union(resultRDD);
                }
            } else {
                if(finalRDD == null) {
                    finalRDD = rdd;
                } else {
                    finalRDD = finalRDD.union(rdd);
                }
            }
        }


        if (needGroupBy) {
            JavaPairRDD<List<Object>, List<Object>> pairRDD = combinedRDD.mapToPair(tuple -> new Tuple2<>(tuple._1(), tuple._2()));
            JavaPairRDD<List<Object>, List<Object>> summedRDD = pairRDD.reduceByKey((list1, list2) -> {
                List<Object> resValues = new ArrayList<>();
                for (int i = 0; i < columnAggregateTypes.size(); i++) {
                    String aggregateType = columnAggregateTypes.get(i);
                    switch (aggregateType) {
                        case "AVG" -> {
//                            System.out.println(list1.get(i));
                            String[] avg1 = ((String) list1.get(i)).split("/");
                            String[] avg2 = ((String) list1.get(i)).split("/");
                            resValues.add((Double.parseDouble(avg1[0]) + Double.parseDouble(avg2[0])) + "/" + (Double.parseDouble(avg1[1]) + Double.parseDouble(avg2[1])));
                        }
                        case "MAX" -> {
                            if (aggregateColumnTypes.get(i).equals("int")) {
                                resValues.add(Math.min((int) list1.get(i), (int) list2.get(i)));
                            } else {
                                resValues.add(Math.min((double) list1.get(i), (double) list2.get(i)));
                            }
                        }
                        case "MIN" -> {
                            if (aggregateColumnTypes.get(i).equals("int")) {
                                resValues.add(Math.max((int) list1.get(i), (int) list2.get(i)));
                            } else {
                                resValues.add(Math.max((double) list1.get(i), (double) list2.get(i)));
                            }
                        }
                        case "SUM", "COUNT" -> {
                            resValues.add((long) list1.get(i) + (long) list2.get(i));
                        }
                    }
                }
                return resValues;
            });
            JavaRDD<List<Object>> map = summedRDD.map(row -> {
                List<Object> res = new ArrayList<>();
                for (Object obj : row._1()) {
                    res.add(obj);
                }
                List<Object> objects = row._2();
                for (Object obj : objects) {
                    if (String.valueOf(obj).contains("/")) {
                        String[] s = String.valueOf(obj).split("/");
                        double value = Double.parseDouble(s[0]) / Double.parseDouble(s[1]);
                        res.add(value);
                    } else {
                        res.add(obj);
                    }
                }
                return res;
            });
            if(sortByIndex != -1) {
                int finalSortByIndex1 = sortByIndex;
                map = map.sortBy(row -> row.get(finalSortByIndex1), !statement.getSortByDesc(), 1);
            }
            map.collect().forEach(System.out::println);
        } else {
            if(sortByIndex != -1) {
                int finalSortByIndex1 = sortByIndex;
                assert finalRDD != null;
                finalRDD = finalRDD.sortBy(row -> row.get(finalSortByIndex1), !statement.getSortByDesc(), 1);
            }
            finalRDD.collect().forEach(System.out::println);
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
//            System.out.println(columnName);
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
                System.out.println(value);
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
//        System.out.println("update all");
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
//        System.out.println("update with condition");
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

    public void findRecordJoin(FindRecordStatement statement) throws TableException {
        List<JoinClause> joinClauseList = statement.getJoinClause();
//        checkJoinClause(joinClauseList);
        String tableName = statement.getTableName();
        if (!this.metaData.getTableDefinitionMap().containsKey(tableName)) {
            throw new TableException("Cannot find table " + tableName);
        }
        List<String> fileList = this.metaData.getTableDefinitionMap().get(tableName).getFileList();
        JavaRDD<List<Object>> resultRDD = null;
        LinkedHashMap<String, Integer> allIndexMap = getAllIndexMap(statement);
//        for (String key : allIndexMap.keySet()) {
//            System.out.println(key + ":" + allIndexMap.get(key));
//        }
        for (String file : fileList) {
            JavaRDD<List<Object>> currentRDD = sparkReader.readTableRaw(STORAGE_PATH + file);

            resultRDD = findRecordFromTableList(allIndexMap, joinClauseList, 0, currentRDD, resultRDD);
        }
//        resultRDD.collect().forEach(System.out::println);
        if (statement.getCondition() != null) {
            resultRDD = filterRDDForJoin(allIndexMap, resultRDD, statement.getCondition());
        }

        List<SelectedColumn> selectedColumn = statement.getSelectedColumn();
        List<Integer> selectedNonAggregatedIndex = new ArrayList<>();
        List<Integer> selectedAggregatedIndex = new ArrayList<>();
        List<AggregateType> aggregateTypeList = new ArrayList<>();
        List<String> aggregateColumnTypes = new ArrayList<>();
        Map<String, Integer> projectionIndex = new HashMap<>();
        int projectionCurrentIndex = 0;

        boolean needGroupBy = false;
        for (SelectedColumn column : selectedColumn) {
            AggregateType aggregateType = column.getType();
            if (!allIndexMap.containsKey(column.getTableName() + "." + column.getColumnName())) {
                throw new TableException("Cannot find column " + column.getColumnName() + " in table " + column.getTableName());
            }
            if (aggregateType == null) {
                selectedNonAggregatedIndex.add(allIndexMap.get(column.getTableName() + "." + column.getColumnName()) - 1);
            } else {
                needGroupBy = true;
                selectedAggregatedIndex.add(allIndexMap.get(column.getTableName() + "." + column.getColumnName()) - 1);
                aggregateTypeList.add(aggregateType);
                aggregateColumnTypes.add(this.metaData.getTableDefinitionMap().get(column.getTableName()).getColumns().get(column.getColumnName()).getType());
            }
            projectionIndex.put(column.getTableName() + "." + column.getColumnName(), projectionCurrentIndex);
            projectionCurrentIndex++;
        }

        // perform group by or not
        if (!needGroupBy) {
            JavaRDD<List<Object>> finalRDD = resultRDD.map(row -> {
                List<Object> resList = new ArrayList<>();
                for (int i = 0; i < selectedNonAggregatedIndex.size(); i++) {
                    resList.add(row.get(selectedNonAggregatedIndex.get(i)));
                }
                return resList;
            });
            finalRDD.collect().forEach(System.out::println);
        } else {
            JavaPairRDD<List<Object>, List<Object>> pairedRDD = resultRDD.mapToPair(row -> {
                List<Object> key = new ArrayList<>();
                List<Object> value = new ArrayList<>();
                for (int i = 0; i < selectedNonAggregatedIndex.size(); i++) {
                    key.add(row.get(selectedNonAggregatedIndex.get(i)));
                }
                for (int i = 0; i < selectedAggregatedIndex.size(); i++) {
                    value.add(row.get(selectedAggregatedIndex.get(i)));
                }
                return new Tuple2<>(key, value);
            });
            JavaPairRDD<List<Object>, Iterable<List<Object>>> pairRDD = pairedRDD.groupByKey();
            int size = aggregateTypeList.size();
            JavaRDD<Tuple2<List<Object>, List<List<Object>>>> tuple2JavaRDD = pairRDD.map(row -> {
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
            JavaRDD<Tuple2<List<Object>, List<Object>>> aggregatedRDD = tuple2JavaRDD.map(row -> {
                List<Object> key = row._1();
                List<List<Object>> value = row._2();
                // Calculate the mean of the first list
                List<Object> res = new ArrayList<>();
                for (int i = 0; i < aggregateColumnTypes.size(); i++) {
                    String dataType = aggregateColumnTypes.get(i);
                    AggregateType aggregateType = aggregateTypeList.get(i);
                    List<Object> list = value.get(i);
                    DoubleStream doubleStream = list.stream().mapToDouble(val -> Double.parseDouble(String.valueOf(val)));
                    if (dataType.equalsIgnoreCase("float")) {
                        switch (aggregateType) {
                            case AVG -> {
                                double count = list.stream().mapToDouble(val -> Double.parseDouble(String.valueOf(val))).count();
                                res.add(doubleStream.sum() / count);
                            }
                            case MAX -> {
                                res.add(doubleStream.max().orElse(0.0));
                            }
                            case MIN -> {
                                res.add(doubleStream.min().orElse(0.0));
                            }
                            case SUM -> {
                                res.add(doubleStream.sum());
                            }
                            case COUNT -> {
                                res.add(doubleStream.count());
                            }
                        }
                    } else if (dataType.equalsIgnoreCase("int")) {
                        IntStream intStream = list.stream().mapToInt(val -> Integer.parseInt(String.valueOf(val)));
                        switch (aggregateType) {
                            case AVG -> {
                                int sum = intStream.sum();
                                long count = list.stream().mapToInt(val -> Integer.parseInt(String.valueOf(val))).count();

                                if (count > 0) {
                                    res.add("" + sum + "/" + count);
                                } else {
                                    // Handle the case when the stream is empty
                                    res.add("0/0");
                                }
                            }
                            case MAX -> {
                                res.add(intStream.max().orElse(0));
                            }
                            case MIN -> {
                                res.add(intStream.min().orElse(0));
                            }
                            case SUM -> {
                                res.add(intStream.sum());
                            }
                            case COUNT -> {
                                res.add(intStream.count());
                            }
                        }
                    } else if (dataType.startsWith("s") || dataType.startsWith("S")) {
                        res.add(list.size());
                    }
                }
                return new Tuple2<>(key, res);
            });
            JavaRDD<List<Object>> finalRDD = aggregatedRDD.map(row -> {
                List<Object> key = row._1();
                List<Object> value = row._2();
                List<Object> res = new ArrayList<>();
                res.addAll(key);
                res.addAll(value);
                return res;
            });

            if (statement.getSortByColumn() != null) {
                System.out.println("multiple join sort by");
                String sortByTableName = statement.getSortByColumn().getTableName();
                String sortByColumnName = statement.getSortByColumn().getColumnName();
                // get index
                int index = projectionIndex.get(sortByTableName + "." + sortByColumnName);
                System.out.println("sorted");
                finalRDD = finalRDD.sortBy(row -> row.get(index), !statement.getSortByDesc(), 1);
            }
            finalRDD.collect().forEach(System.out::println);
        }
    }

    private JavaRDD<List<Object>> filterRDDForJoin(LinkedHashMap<String, Integer> allIndexMap, JavaRDD<List<Object>> resultRDD, ConditionNode condition) throws TableException {
        if (condition instanceof ConditionExpression expression) {
            String tableName = expression.getColumnName().getTableName();
            if (tableName == null) {
                throw new TableException("Please declare table name when performing join");
            }
            if (!this.metaData.getTableDefinitionMap().containsKey(tableName)) {
                throw new TableException("Cannot find Table " + tableName);
            }
            String columnName = expression.getColumnName().getColumnName();
            if (!this.metaData.getTableDefinitionMap().get(tableName).getColumns().containsKey(columnName)) {
                throw new TableException("Cannot find column " + columnName + " in table " + tableName);
            }

            int index = allIndexMap.get(tableName + "." + columnName) - 1;
            String columnType = this.metaData.getTableDefinitionMap().get(tableName).getColumns().get(columnName).getType();
            ComparisonOperator comparator = expression.getComparator();
            String value = expression.getValue();
            if (columnType.startsWith("s") || columnType.startsWith("S")) {
                if (value.charAt(0) != '\'' || value.charAt(value.length() - 1) != '\'') {
                    throw new TableException("wrong value format for " + value);
                }
            }
            if (columnType.equals("int")) {
                try {
                    int res = Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new TableException("Expected Integer for column " + tableName + "." + columnName);
                }
            } else if (columnType.equals("float")) {
                try {
                    double res = Double.parseDouble(value);
                } catch (NumberFormatException e) {
                    throw new TableException("Expected Float for column " + tableName + "." + columnName);
                }
            }

            return resultRDD.filter(record -> {
                if (columnType.equals("int")) {
                    Integer origin = Integer.parseInt((String) record.get(index));
                    Integer target = Integer.parseInt(value);
                    switch (comparator) {
                        case EQ -> {
                            return origin.equals(target);
                        }
                        case GT -> {
                            return origin > target;
                        }
                        case GTE -> {
                            return origin >= target;
                        }
                        case LT -> {
                            return origin < target;
                        }
                        case LTE -> {
                            return origin <= target;
                        }
                        case NEQ -> {
                            return !origin.equals(target);
                        }
                    }
                    return false;
                } else if (columnType.equals("float")) {
                    Double origin = Double.parseDouble((String) record.get(index));
                    Double target = Double.parseDouble(value);
                    switch (comparator) {
                        case EQ -> {
                            return origin.equals(target);
                        }
                        case GT -> {
                            return origin > target;
                        }
                        case GTE -> {
                            return origin >= target;
                        }
                        case LT -> {
                            return origin < target;
                        }
                        case LTE -> {
                            return origin <= target;
                        }
                        case NEQ -> {
                            return !origin.equals(target);
                        }
                    }
                    return false;
                } else {
                    String org = (String) record.get(index);
                    boolean res = org.equals(value.substring(1, value.length() - 1));
                    switch (comparator) {
                        case EQ -> {
                            return res;
                        }
                        case NEQ -> {
                            return !res;
                        }
                    }
                    return false;
                }
            });
        } else {
            LogicalConditionNode logicalConditionNode = (LogicalConditionNode) condition;
            JavaRDD<List<Object>> leftRDD = filterRDDForJoin(allIndexMap, resultRDD, logicalConditionNode.getLeft());
            JavaRDD<List<Object>> rightRDD = filterRDDForJoin(allIndexMap, resultRDD, logicalConditionNode.getRight());
            if (logicalConditionNode.getOperator().equals(LogicalOperator.AND)) {
                return leftRDD.intersection(rightRDD);
            } else {
                return leftRDD.union(rightRDD);
            }
        }
    }


    private LinkedHashMap<String, Integer> getAllIndexMap(FindRecordStatement statement) throws TableException {
        String mainTable = statement.getTableName();
        LinkedHashMap<String, Integer> allIndexMap = new LinkedHashMap<>();
        Map<String, ColumnInfo> columns = this.metaData.getTableDefinitionMap().get(mainTable).getColumns();
        int currentIndex = 0;
        for (String key : columns.keySet()) {
            currentIndex++;
            allIndexMap.put(mainTable + "." + key, currentIndex);
        }
        List<JoinClause> joinClauseList = statement.getJoinClause();
        for (JoinClause clause : joinClauseList) {
            String tableName = clause.getTableName();

            if (!this.metaData.getTableDefinitionMap().containsKey(tableName)) {
                throw new TableException("Cannot find table " + tableName);
            }
            if (clause.getLeft().getTableName() == null) {
                throw new TableException("Must declare table name in join clause");
            }
            if (clause.getRight().getTableName() == null) {
                throw new TableException("Must declare table name in join clause");
            }
            if (!this.metaData.getTableDefinitionMap().containsKey(clause.getLeft().getTableName())) {
                throw new TableException("Cannot find table " + clause.getLeft().getTableName());
            }
            if (!this.metaData.getTableDefinitionMap().get(clause.getLeft().getTableName()).getColumns().containsKey(clause.getLeft().getColumnName())) {
                throw new TableException("Cannot find column " + clause.getLeft().getColumnName() + " in table " + clause.getLeft().getTableName());
            }
            if (!this.metaData.getTableDefinitionMap().containsKey(clause.getRight().getTableName())) {
                throw new TableException("Cannot find table " + clause.getRight().getTableName());
            }
            if (!this.metaData.getTableDefinitionMap().get(clause.getRight().getTableName()).getColumns().containsKey(clause.getRight().getColumnName())) {
                throw new TableException("Cannot find column " + clause.getRight().getColumnName() + " in table " + clause.getRight().getTableName());
            }


            Map<String, ColumnInfo> tableColumns = this.metaData.getTableDefinitionMap().get(tableName).getColumns();
            for (String key : tableColumns.keySet()) {
                currentIndex++;
                allIndexMap.put(tableName + "." + key, currentIndex);
            }
        }

        return allIndexMap;
    }

    private JavaRDD<List<Object>> findRecordFromTableList(Map<String, Integer> allIndex, List<JoinClause> joinClauseList, int index, JavaRDD<List<Object>> currentRDD, JavaRDD<List<Object>> res) throws TableException {
        if (index == joinClauseList.size()) {
            if (res == null) {
                return currentRDD;
            } else {
                return res.union(currentRDD);
            }
        }

        JoinClause clause = joinClauseList.get(index);
        String currentTable = clause.getTableName();
        List<String> fileList = this.metaData.getTableDefinitionMap().get(currentTable).getFileList();
        int leftIndex;
        SelectedColumn left = clause.getLeft();
        SelectedColumn right = clause.getRight();
        if (left.getTableName() == null || right.getTableName() == null) {
            throw new TableException("Must declare table names in join clause");
        }
        if (!this.metaData.getTableDefinitionMap().containsKey(left.getTableName())) {
            throw new TableException("Cannot find table" + left.getTableName());
        }
        if (!this.metaData.getTableDefinitionMap().containsKey(right.getTableName())) {
            throw new TableException("Cannot find table" + right.getTableName());
        }

        if (left.getTableName().equals(currentTable)) {
            // means
            leftIndex = allIndex.get(right.getTableName() + "." + right.getColumnName()) - 1;
        } else if (right.getTableName().equals(currentTable)) {
            leftIndex = allIndex.get(left.getTableName() + "." + left.getColumnName()) - 1;
        } else {
            throw new TableException("Cannot find table " + currentTable);
        }

        for (String file : fileList) {
            JavaRDD<List<Object>> fileRDD = sparkReader.readTableRaw(STORAGE_PATH + file);
            JavaRDD<List<Object>> joinedRDD = performJoin(currentRDD, clause, leftIndex, fileRDD);
            res = findRecordFromTableList(allIndex, joinClauseList, index + 1, joinedRDD, res);
            // currentRDD redo the join
        }
        return res;
    }

    private JavaRDD<List<Object>> performJoin(JavaRDD<List<Object>> currentRDD, JoinClause joinClause, int leftIndex, JavaRDD<List<Object>> tableRDD) throws TableException {
        String leftTable = joinClause.getLeft().getTableName();
        String rightTable = joinClause.getRight().getTableName();
        if (leftTable == null || rightTable == null) {
            throw new TableException("Must indicate table name in join clause");
        }
        int rightIndex = 0;
        if (leftTable.equals(joinClause.getTableName())) {
            String rightColumn = joinClause.getLeft().getColumnName();
            if (!this.metaData.getTableDefinitionMap().containsKey(leftTable)) {
                throw new TableException("Cannot find table " + leftTable);
            }
            if (!this.metaData.getTableDefinitionMap().get(leftTable).getColumns().containsKey(rightColumn)) {
                throw new TableException("Cannot find column " + rightColumn + " in table " + leftTable);
            }
            rightIndex = this.metaData.getTableDefinitionMap().get(leftTable).getColumns().get(rightColumn).getIndex() - 1;
        } else if (rightTable.equals(joinClause.getTableName())) {
            String rightColumn = joinClause.getRight().getColumnName();
            if (!this.metaData.getTableDefinitionMap().containsKey(rightTable)) {
                throw new TableException("Cannot find table " + rightTable);
            }
            if (!this.metaData.getTableDefinitionMap().get(rightTable).getColumns().containsKey(rightColumn)) {
                throw new TableException("Cannot find column " + rightColumn + " in table " + rightTable);
            }
            rightIndex = this.metaData.getTableDefinitionMap().get(rightTable).getColumns().get(rightColumn).getIndex() - 1;
        }


        JavaPairRDD<Object, List<Object>> currentPairedRDD = currentRDD.mapToPair(list -> new Tuple2<>(list.get(leftIndex), list));
        int finalRightIndex = rightIndex;
        JavaPairRDD<Object, List<Object>> tablePairedRDD = tableRDD.mapToPair(list -> new Tuple2<>(list.get(finalRightIndex), list));
        // Perform the join on the pair RDDs
        JavaPairRDD<Object, Tuple2<List<Object>, List<Object>>> joinedRDD = currentPairedRDD.join(tablePairedRDD);
        JavaRDD<List<Object>> resultRDD = joinedRDD.map(record -> {
            List<Object> resList = new ArrayList<>();
            List<Object> list1 = record._2()._1();
            List<Object> list2 = record._2()._2();
            resList.addAll(list1);
            resList.addAll(list2);
            return resList;
        });
        return resultRDD;
    }

    private void checkJoinClause(List<JoinClause> joinClauseList) throws TableException {
        for (JoinClause clause : joinClauseList) {
            // check table name existence
            if (!this.metaData.getTableDefinitionMap().containsKey(clause.getTableName())) {
                throw new TableException("Table " + clause.getTableName() + " not found!");
            }
            // check on condition
            SelectedColumn left = clause.getLeft();
            SelectedColumn right = clause.getRight();
            if (!this.metaData.getTableDefinitionMap().get(left.getTableName()).getColumns().containsKey(left.getColumnName())) {
                throw new TableException("Column " + left.getColumnName() + " does not exist in Table " + left.getTableName());
            }

            if (!this.metaData.getTableDefinitionMap().get(right.getTableName()).getColumns().containsKey(right.getColumnName())) {
                throw new TableException("Column " + right.getColumnName() + " does not exist in Table " + right.getTableName());
            }

            String dataTypeLeft = this.metaData.getTableDefinitionMap().get(left.getTableName()).getColumns().get(left.getColumnName()).getType();
            String dataTypeRight = this.metaData.getTableDefinitionMap().get(right.getTableName()).getColumns().get(right.getColumnName()).getType();
            if (!dataTypeLeft.equals(dataTypeRight)) {
                throw new TableException("Cannot perform join operation on columns with different data types");
            }
        }
    }


}
