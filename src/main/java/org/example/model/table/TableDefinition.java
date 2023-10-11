package org.example.model.table;


import org.example.model.ColumnDefinition;
import org.example.model.ColumnInfo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TableDefinition {

    String name;
    Map<String, ColumnInfo> columns;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, ColumnInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumnInfo> columns) {
        this.columns = columns;
    }

    public void setColumnsWithStatement(List<ColumnDefinition> columnDefinition) {
        int index = 1;
        for (ColumnDefinition definition: columnDefinition) {
            this.columns.put(definition.getColumnName(), new ColumnInfo(definition.getDataType(), index));
            index ++;
        }
    }
}
