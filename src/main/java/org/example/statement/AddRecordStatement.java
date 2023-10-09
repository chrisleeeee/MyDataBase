package org.example.statement;

import org.example.gen.TableQueryGrammarParser;
import org.example.model.ColumnAssignment;

import java.util.ArrayList;
import java.util.List;

public class AddRecordStatement extends Statement {

    private List<ColumnAssignment> columnAssignment;

    public AddRecordStatement() {
        this.columnAssignment = new ArrayList<>();
    }


    public List<ColumnAssignment> getColumnAssignment() {
        return columnAssignment;
    }

    public void setColumnAssignment(List<ColumnAssignment> assignment) {
        this.columnAssignment = assignment;
    }

    public void setColumnAssignmentWithContext(
            List<TableQueryGrammarParser.ColumnAssignmentContext> columnAssignment) {
        for (TableQueryGrammarParser.ColumnAssignmentContext context : columnAssignment) {
            this.columnAssignment.add(new ColumnAssignment(context.columnName().getText().toLowerCase(),
                    context.dataValue().getText()));
        }
    }
}
