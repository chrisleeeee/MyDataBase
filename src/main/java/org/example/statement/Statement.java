package org.example.statement;

import org.example.model.TypeEnum;

public class Statement {

    protected TypeEnum type;

    protected String tableName;

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
