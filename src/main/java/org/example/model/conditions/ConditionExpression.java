package org.example.model.conditions;

public class ConditionExpression extends ConditionNode {
    private String columnName;
    private ComparisonOperator comparator;
    private String value;

    public ConditionExpression() {
    }

    public ConditionExpression(String columnName, ComparisonOperator comparator, String value) {
        this.columnName = columnName;
        this.comparator = comparator;
        this.value = value;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
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
