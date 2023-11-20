package org.example.statement;

import org.example.model.JoinClause;
import org.example.model.SelectedColumn;
import org.example.model.conditions.ConditionNode;

import java.util.List;

public class FindRecordStatement extends Statement {

    private List<SelectedColumn> selectedColumn;

    private ConditionNode condition;

    private List<JoinClause> joinClause;

    private List<SelectedColumn> groupByColumn;

    private SelectedColumn sortByColumn;

    private boolean sortByDesc;

    public boolean getSortByDesc() {
        return sortByDesc;
    }

    public void setSortByDesc(boolean sortByDesc) {
        this.sortByDesc = sortByDesc;
    }

    public SelectedColumn getSortByColumn() {
        return sortByColumn;
    }

    public void setSortByColumn(SelectedColumn sortByColumn) {
        this.sortByColumn = sortByColumn;
    }

    public FindRecordStatement() {
    }

    public FindRecordStatement(List<SelectedColumn> selectedColumn, ConditionNode condition, List<JoinClause> joinClause, List<SelectedColumn> groupByColumn) {
        this.selectedColumn = selectedColumn;
        this.condition = condition;
        this.joinClause = joinClause;
        this.groupByColumn = groupByColumn;
    }

    public List<SelectedColumn> getSelectedColumn() {
        return selectedColumn;
    }

    public void setSelectedColumn(List<SelectedColumn> selectedColumn) {
        this.selectedColumn = selectedColumn;
    }

    public ConditionNode getCondition() {
        return condition;
    }

    public void setCondition(ConditionNode condition) {
        this.condition = condition;
    }

    public List<JoinClause> getJoinClause() {
        return joinClause;
    }

    public void setJoinClause(List<JoinClause> joinClause) {
        this.joinClause = joinClause;
    }

    public List<SelectedColumn> getGroupByColumn() {
        return groupByColumn;
    }

    public void setGroupByColumn(List<SelectedColumn> groupByColumn) {
        this.groupByColumn = groupByColumn;
    }
}
