package org.example.model.table;


import org.example.model.ColumnDefinition;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TableDefinition {

    String name;
    Map<String, String> columns;

    int recordLength;

    public int getRecordLength() {
        return recordLength;
    }

    public void setRecordLength(int recordLength) {
        this.recordLength = recordLength;
    }

    public TableDefinition() {
        this.columns = new LinkedHashMap<>();
    }

    public TableDefinition(Map<String, String> columnsMap) {
        this.columns = columnsMap;
    }

    public Map<String, String> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, String> columnsMap) {
        this.columns = columnsMap;
    }

    public void setColumnsWithStatement(List<ColumnDefinition> definitionList) {
        for(ColumnDefinition definition: definitionList) {
            columns.put(definition.getColumnName(), definition.getDataType());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
