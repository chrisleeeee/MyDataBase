package org.example.model;


public class ColumnAssignment {

    private String columnName;

    private String dataValue;

    public ColumnAssignment(String columnName, String dataValue) {
        this.columnName = columnName;
        this.dataValue = dataValue;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }
}
