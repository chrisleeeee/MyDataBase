package org.example.statement;

import org.example.model.conditions.ConditionNode;

public class DeleteStatement extends Statement{

    private ConditionNode condition;

    public DeleteStatement() {
    }

    public DeleteStatement(ConditionNode condition) {
        this.condition = condition;
    }

    public ConditionNode getCondition() {
        return condition;
    }

    public void setCondition(ConditionNode condition) {
        this.condition = condition;
    }
}
