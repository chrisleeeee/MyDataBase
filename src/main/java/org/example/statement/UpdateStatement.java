package org.example.statement;

import org.example.gen.TableQueryGrammarParser;
import org.example.model.ColumnAssignment;
import org.example.model.conditions.ConditionNode;

import java.util.ArrayList;
import java.util.List;

public class UpdateStatement extends Statement {
    private List<ColumnAssignment> assignments;
    private ConditionNode condition;

    public UpdateStatement() {
        this.assignments = new ArrayList<>();
    }

    public UpdateStatement(List<ColumnAssignment> assignments, ConditionNode condition) {
        this.assignments = assignments;
        this.condition = condition;
    }

    public List<ColumnAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<ColumnAssignment> assignments) {
        this.assignments = assignments;
    }

    public ConditionNode getCondition() {
        return condition;
    }

    public void setCondition(ConditionNode condition) {
        this.condition = condition;
    }

    public void setColumnAssignmentWithContext(
            List<TableQueryGrammarParser.ColumnAssignmentContext> columnAssignment) {
        for (TableQueryGrammarParser.ColumnAssignmentContext context : columnAssignment) {
            this.assignments.add(new ColumnAssignment(context.columnName().getText().toLowerCase(),
                    context.dataValue().getText()));
        }
    }
}
