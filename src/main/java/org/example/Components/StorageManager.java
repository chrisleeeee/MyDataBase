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
import org.example.statement.FindRecordStatement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
                File tableStorageFile = new File(STORAGE_PATH + "/" + definition.getName() + ".txt");
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
        metaData.getTableDefinitionMap().remove(tableName);
        //
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File(META_FILE_PATH), this.metaData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File(STORAGE_PATH + tableName + ".txt");
        file.delete();

    }

    public void insertRecord(TableAssignment tableAssignment) throws TableException {
        if (!this.metaData.getTableDefinitionMap().containsKey(tableAssignment.getTableName())) {
            throw new TableException("Table does not exist");
        }
        // check data type
        TableDefinition tableDefinition = this.metaData.getTableDefinitionMap().get(tableAssignment.getTableName());
        Map<String, ColumnInfo> columns = tableDefinition.getColumns();

        String outputFile = STORAGE_PATH + tableAssignment.getTableName() + ".txt";
        // it's linkedHashSet, so the order is fixed.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {
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
            writer.write(sb.toString() + "\n");
        } catch (IOException e) {
            throw new TableException("Error occurred when inserting the data");
        }

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
        sparkReader.readTableData(STORAGE_PATH + statement.getTableName() + ".txt", indexes, dataTypes);

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
}
