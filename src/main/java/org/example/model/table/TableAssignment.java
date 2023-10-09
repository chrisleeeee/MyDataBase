package org.example.model.table;

import org.example.model.ColumnAssignment;
import org.example.model.ColumnDefinition;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TableAssignment {
    private String tableName;
    private Map<String, String> assignments;

    public TableAssignment() {
        this.assignments = new LinkedHashMap<>();
    }

    public TableAssignment(String tableName, Map<String, String> assignments) {
        this.tableName = tableName;
        this.assignments = assignments;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, String> getAssignments() {
        return assignments;
    }

    public void setAssignments(Map<String, String> assignments) {
        this.assignments = assignments;
    }

    public void setAssignmentsWithList(List<ColumnAssignment> columnAssignment) {
        for(ColumnAssignment assignment: columnAssignment) {
            assignments.put(assignment.getColumnName(), assignment.getDataValue());
        }
    }
}
