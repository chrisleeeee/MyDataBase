package org.example.Components;


import org.example.Exception.TableException;
import org.example.model.ColumnDefinition;
import org.example.model.table.TableAssignment;
import org.example.model.table.TableDefinition;
import org.example.statement.AddRecordStatement;
import org.example.statement.CreateTableStatement;
import org.example.statement.FindRecordStatement;
import org.example.statement.Statement;

public class Executor {

    private static final StorageManager storageManager = StorageManager.getInstance();

    public static void executeCreateStatement(CreateTableStatement statement) throws TableException {
        TableDefinition tableDefinition = new TableDefinition();
        tableDefinition.setName(statement.getTableName());
        tableDefinition.setColumnsWithStatement(statement.getColumnDefinition());

        // validate String definition, must be positive integer
        int recordLength = 1;
        for(ColumnDefinition definition: statement.getColumnDefinition()) {
            if (definition.getDataType().startsWith("s") || definition.getDataType().startsWith("S")) {
                int startIndex = definition.getDataType().indexOf("(");
                int endIndex = definition.getDataType().indexOf(")");
                String number = definition.getDataType().substring(startIndex + 1, endIndex);

                if (Integer.parseInt(number) <= 0) {
                    throw new TableException("The length of String must be positive");
                }
                recordLength += Integer.parseInt(number);
            }
            if(definition.getDataType().equals("int")) {
                recordLength += 4;
            }
            if(definition.getDataType().equals("float")) {
                recordLength += 8;
            }
        }
        tableDefinition.setRecordLength(recordLength);
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

    public static void executeFindStatement(FindRecordStatement statement) throws TableException{
        System.out.println(statement.getTableName());
        System.out.println(statement.getSelectedColumn());
        storageManager.findRecord(statement);
    }
}
