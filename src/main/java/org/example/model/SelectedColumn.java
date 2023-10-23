package org.example.model;

public class SelectedColumn {
    private AggregateType type;
    private String tableName;
    private String columnName;


    public SelectedColumn() {
    }

    public SelectedColumn(AggregateType type, String tableName, String columnName) {
        this.type = type;
        this.tableName = tableName;
        this.columnName = columnName;
    }

    public AggregateType getType() {
        return type;
    }

    public void setType(AggregateType type) {
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @Override
    public String toString() {
        return "SelectedColumn{" +
                "type=" + type +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                '}';
    }
}
