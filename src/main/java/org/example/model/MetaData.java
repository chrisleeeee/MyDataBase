package org.example.model;

import org.example.model.table.TableDefinition;

import java.util.LinkedHashMap;
import java.util.Map;

public class MetaData {
    Map<String, TableDefinition> tableDefinitionMap;

    public MetaData() {
        this.tableDefinitionMap = new LinkedHashMap<>();
    }

    public Map<String, TableDefinition> getTableDefinitionMap() {
        return tableDefinitionMap;
    }

    public void setTableDefinitionMap(Map<String, TableDefinition> tableDefinitionMap) {
        this.tableDefinitionMap = tableDefinitionMap;
    }


}
