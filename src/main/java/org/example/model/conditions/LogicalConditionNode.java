package org.example.model.conditions;


public class LogicalConditionNode extends ConditionNode {
    private ConditionNode left;
    private LogicalOperator operator;
    private ConditionNode right;

    public LogicalConditionNode() {
    }

    public LogicalConditionNode(ConditionNode left, LogicalOperator operator) {
        this.left = left;
        this.operator = operator;
    }

    public LogicalConditionNode(ConditionNode left, LogicalOperator operator, ConditionNode right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    public ConditionNode getLeft() {
        return left;
    }

    public void setLeft(ConditionNode left) {
        this.left = left;
    }

    public LogicalOperator getOperator() {
        return operator;
    }

    public void setOperator(LogicalOperator operator) {
        this.operator = operator;
    }

    public ConditionNode getRight() {
        return right;
    }

    public void setRight(ConditionNode right) {
        this.right = right;
    }
}
