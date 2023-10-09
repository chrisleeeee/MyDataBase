package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ColumnDefinition {
    private String columnName;
    private String dataType;

    public ColumnDefinition() {

    }
    public ColumnDefinition(String columnName, String dataType) {
        this.columnName = columnName;
        this.dataType = dataType;
    }

    @JsonProperty("columnName")
    public String getColumnName() {
        return columnName;
    }

    @JsonProperty("columnName")
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    @JsonProperty("dataType")
    public String getDataType() {
        return dataType;
    }

    @JsonProperty("dataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}