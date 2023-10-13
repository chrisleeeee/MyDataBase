package org.example.Components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.util.Pair;
import org.example.Exception.TableException;
import org.example.model.ColumnInfo;
import org.example.model.MetaData;
import org.example.model.conditions.ComparisonOperator;
import org.example.model.conditions.ConditionExpression;
import org.example.model.conditions.ConditionNode;
import org.example.model.conditions.LogicalConditionNode;
import org.example.model.table.TableAssignment;
import org.example.model.table.TableDefinition;
import org.example.statement.DeleteStatement;
import org.example.statement.FindRecordStatement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        System.out.println();
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
                } else if (dataType.startsWith("string")) {
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
            writer.write(sb + "\n");
        } catch (IOException e) {
            System.out.println(STORAGE_PATH + outputFile);
            e.printStackTrace();
            throw new TableException("Error occurred when inserting the data");
        }
        updateMetadata();

    }


    public void findRecord(FindRecordStatement statement) throws TableException {
        String tableName = statement.getTableName();
        List<String> selectedColumns = statement.getSelectedColumn();
        // check table existence
        if (!this.metaData.getTableDefinitionMap().containsKey(statement.getTableName())) {
            throw new TableException("Table does not exist");
        }
        // check column validity
        List<Pair<Integer, String>> indexesAndTypes = getFindSelectedIndexTypes(tableName, selectedColumns);

        // check condition validity
        checkFindCondition(tableName, statement.getCondition());
        // perform find
        List<Integer> indexes = new ArrayList<>();
        List<String> dataTypes = new ArrayList<>();
        for (Pair<Integer, String> pair : indexesAndTypes) {
            indexes.add(pair.getKey());
            dataTypes.add(pair.getValue());
        }
        List<String> fileList = this.metaData.getTableDefinitionMap().get(tableName).getFileList();
        for (String filePath : fileList) {
            if (statement.getCondition() == null) {
                sparkReader.readTableData(STORAGE_PATH + filePath, indexes, dataTypes);
            } else {
                sparkReader.readTableDataWithCondition(STORAGE_PATH + filePath,
                        indexes,
                        dataTypes,
                        this.metaData.getTableDefinitionMap().get(tableName).getColumns(),
                        statement.getCondition());
            }
        }
    }

    private void checkFindCondition(String tableName, ConditionNode condition) throws TableException {
        TableDefinition tableDefinition = this.metaData.getTableDefinitionMap().get(tableName);
        Map<String, ColumnInfo> columnsDefinition = tableDefinition.getColumns();
        if (condition instanceof ConditionExpression expression) {
            // only one condition
            String columnName = expression.getColumnName();
            String value = expression.getValue();
            if (!columnsDefinition.containsKey(columnName)) {
                throw new TableException("Column " + columnName + " does not exist in table " + tableName);
            }

            String dataType = columnsDefinition.get(columnName).getType();
            checkColumnConditionValidity(columnName, dataType, value, expression.getComparator());

        }
        if (condition instanceof LogicalConditionNode logicalConditionNode) {
            checkFindCondition(tableName, logicalConditionNode.getLeft());
            checkFindCondition(tableName, logicalConditionNode.getRight());
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
        } else if (dataType.startsWith("string")) {
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


    private List<Pair<Integer, String>> getFindSelectedIndexTypes(String tableName, List<String> selectedColumn) throws TableException {
        TableDefinition tableDefinition = this.metaData.getTableDefinitionMap().get(tableName);
        if (selectedColumn.size() == 1 && selectedColumn.get(0).equals("*")) {
            List<Pair<Integer, String>> ret = new ArrayList<>();
            for (String s : tableDefinition.getColumns().keySet()) {
                ret.add(new Pair<>(tableDefinition.getColumns().get(s).getIndex(), tableDefinition.getColumns().get(s).getType()));
            }
            return ret;
        }

        for (String column : selectedColumn) {
            if (!tableDefinition.getColumns().containsKey(column)) {
                throw new TableException("Column " + column + " does not exist in table " + tableName);
            }
        }
        List<Pair<Integer, String>> ret = new ArrayList<>();
        for (String column : selectedColumn) {
            ret.add(new Pair<>(tableDefinition.getColumns().get(column).getIndex(), tableDefinition.getColumns().get(column).getType()));
        }
        return ret;
    }

    public void deleteWithCondition(DeleteStatement statement) {
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
}
