package org.example.model;

public class JoinClause {
    private String tableName;
    private SelectedColumn left;
    private SelectedColumn right;

    public JoinClause() {
    }

    public JoinClause(String tableName, SelectedColumn left, SelectedColumn right) {
        this.tableName = tableName;
        this.left = left;
        this.right = right;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public SelectedColumn getLeft() {
        return left;
    }

    public void setLeft(SelectedColumn left) {
        this.left = left;
    }

    public SelectedColumn getRight() {
        return right;
    }

    public void setRight(SelectedColumn right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "JoinClause{" +
                "tableName='" + tableName + '\'' +
                ", left=" + left.toString() +
                ", right=" + right.toString() +
                '}';
    }
}
