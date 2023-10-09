package org.example.Executor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.example.Exception.TableException;
import org.example.model.MetaData;
import org.example.model.table.TableAssignment;
import org.example.model.table.TableDefinition;
import org.example.statement.FindRecordStatement;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class StorageManager {

    private static final String META_FILE_PATH = "src/main/resources/Tables/meta.json";

    private static final String STORAGE_PATH = "src/main/resources/Tables/";
    private static StorageManager instance;
    private MetaData metaData;

    private StorageManager() {
        loadMetaData();
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

    private static void dropTableMetaData(String tableName) {

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
                File tableStorageFile = new File(STORAGE_PATH + "/" + definition.getName() + ".zdb");
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
        File file = new File(STORAGE_PATH + tableName + ".zdb");
        file.delete();

    }

    public void insertRecord(TableAssignment tableAssignment) throws TableException {
        if (!this.metaData.getTableDefinitionMap().containsKey(tableAssignment.getTableName())) {
            throw new TableException("Table does not exist");
        }
        // check data type
        TableDefinition tableDefinition = this.metaData.getTableDefinitionMap().get(tableAssignment.getTableName());
        Map<String, String> columns = tableDefinition.getColumns();

        String outputFile = STORAGE_PATH + tableAssignment.getTableName() + ".zdb";
        // it's linkedHashSet, so the order is fixed.
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFile, true))) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            // *******
            byte flag = 1; //
            // *******
            buffer.write(flag);
            for (String key : columns.keySet()) {
                String dataType = columns.get(key);
                String value = tableAssignment.getAssignments().get(key);


                if (dataType.equals("int")) {
                    try {
                        int res = Integer.parseInt(value);
                        buffer.write(ByteBuffer.allocate(4).putInt(res).array());
                    } catch (NumberFormatException e) {
                        throw new TableException("Expected Integer for column " + key);
                    }
                } else if (dataType.equals("float")) {
                    try {
                        double res = Double.parseDouble(value);
                        buffer.write(ByteBuffer.allocate(8).putDouble(res).array());
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
                    if(dataValue.length() < length) {
                        int paddingLength = length - dataValue.length();
                        for (int i = 0; i < paddingLength; i++) {
                            dataValue += '@'; // Padding with the chosen character
                        }
                    }
                    buffer.write(dataValue.getBytes(StandardCharsets.UTF_8));
                }
            }
            outputStream.write(buffer.toByteArray());
        } catch (IOException e) {
            throw new TableException("Error occurred when inserting the data");
        }

    }


    public void findRecord(FindRecordStatement statement) throws TableException{
        // check table existence
        if(!this.metaData.getTableDefinitionMap().containsKey(statement.getTableName())) {
            throw new TableException("Table does not exist");
        }
        // check column validity
        checkFindStatementSelectedColumns(statement.getSelectedColumn());

        // check condition validity
        checkFindCondition(statement.getCondition());
        // perform find

    }
}
