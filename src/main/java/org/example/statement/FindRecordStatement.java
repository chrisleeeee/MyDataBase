package org.example.statement;

import org.example.model.conditions.ConditionNode;

import java.util.ArrayList;
import java.util.List;

public class FindRecordStatement extends Statement{

    private List<String> selectedColumn;

    private ConditionNode condition;

    public FindRecordStatement() {
        selectedColumn = new ArrayList<>();
        condition = null;
    }

    public FindRecordStatement(List<String> selectedColumn, ConditionNode condition) {
        this.selectedColumn = selectedColumn;
        this.condition = condition;
    }

    public List<String> getSelectedColumn() {
        return selectedColumn;
    }

    public void setSelectedColumn(List<String> selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    public ConditionNode getCondition() {
        return condition;
    }

    public void setCondition(ConditionNode condition) {
        this.condition = condition;
    }
}
