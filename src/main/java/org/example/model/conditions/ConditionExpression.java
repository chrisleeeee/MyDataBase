package org.example.model.conditions;

import org.example.model.SelectedColumn;

public class ConditionExpression extends ConditionNode {
    private SelectedColumn columnName;
    private ComparisonOperator comparator;
    private String value;

    public ConditionExpression() {
    }

    public ConditionExpression(SelectedColumn columnName, ComparisonOperator comparator, String value) {
        this.columnName = columnName;
        this.comparator = comparator;
        this.value = value;
    }

    public SelectedColumn getColumnName() {
        return columnName;
    }

    public void setColumnName(SelectedColumn columnName) {
        this.columnName = columnName;
    }

    public ComparisonOperator getComparator() {
        return comparator;
    }

    public void setComparator(ComparisonOperator comparator) {
        this.comparator = comparator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
