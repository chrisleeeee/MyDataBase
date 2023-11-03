package org.example.Components;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Exception.TableException;
import org.example.model.ColumnDefinition;
import org.example.model.table.TableAssignment;
import org.example.model.table.TableDefinition;
import org.example.statement.*;

public class Executor {

    private static final StorageManager storageManager = StorageManager.getInstance();

    private static final Logger logger = LogManager.getLogger(Executor.class);

    public static void executeCreateStatement(CreateTableStatement statement) throws TableException {
        TableDefinition tableDefinition = new TableDefinition();
        tableDefinition.setName(statement.getTableName());
        tableDefinition.setColumnsWithStatement(statement.getColumnDefinition());

        // validate String definition, must be positive integer
        int recordLength = 1;
        for (ColumnDefinition definition : statement.getColumnDefinition()) {
            if (definition.getDataType().startsWith("s") || definition.getDataType().startsWith("S")) {
                int startIndex = definition.getDataType().indexOf("(");
                int endIndex = definition.getDataType().indexOf(")");
                String number = definition.getDataType().substring(startIndex + 1, endIndex);

                if (Integer.parseInt(number) <= 0) {
                    throw new TableException("The length of String must be positive");
                }
                recordLength += Integer.parseInt(number);
            }
            if (definition.getDataType().equals("int")) {
                recordLength += 4;
            }
            if (definition.getDataType().equals("float")) {
                recordLength += 8;
            }
        }
        tableDefinition.setRecordLength(recordLength);
        tableDefinition.getFileList().add(statement.getTableName() + "1.txt");
        storageManager.createTableMetaData(tableDefinition);

    }

    public static void executeDropStatement(Statement statement) throws TableException {
        storageManager.dropTable(statement.getTableName());
    }

    public static void executeAddStatement(AddRecordStatement statement) throws TableException {
        TableAssignment assignment = new TableAssignment();
        assignment.setTableName(statement.getTableName());
        assignment.setAssignmentsWithList(statement.getColumnAssignment());
        storageManager.insertRecord(assignment);
    }

    public static void executeFindStatement(FindRecordStatement statement) throws TableException {
        storageManager.findRecord(statement);
    }

    public static void executeDeleteStatement(DeleteStatement statement) throws TableException {
        if (statement.getCondition() == null) {
            // delete all data files
            storageManager.deleteAllData(statement.getTableName());
        } else {
            storageManager.deleteWithCondition(statement);
        }
    }

    public static void executeUpdateStatement(UpdateStatement statement) throws TableException {
        if (statement.getCondition() == null) {
            storageManager.updateAllData(statement);
        } else {
            storageManager.updateWithCondition(statement);
        }
    }
}
