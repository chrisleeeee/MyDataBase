package org.example.statement;

import org.example.gen.TableQueryGrammarBaseVisitor;
import org.example.gen.TableQueryGrammarParser;
import org.example.model.TypeEnum;
import org.example.model.conditions.*;

import java.util.ArrayList;
import java.util.List;

public class StatementVisitor extends TableQueryGrammarBaseVisitor<Statement> {

    @Override
    public Statement visitCreateTableStatement(TableQueryGrammarParser.CreateTableStatementContext ctx) {
        CreateTableStatement statement = new CreateTableStatement();
        statement.setType(TypeEnum.CREATE);
        statement.setTableName(ctx.tableName().IDENTIFIER().getText().toLowerCase());
        statement.setColumnDefinitionWithContext(ctx.columnDefinition());
        return statement;
    }

    @Override
    public Statement visitDropTableStatement(TableQueryGrammarParser.DropTableStatementContext ctx) {
        Statement statement = new Statement();
        statement.setType(TypeEnum.DROP);
        statement.setTableName(ctx.tableName().getText().toLowerCase());
        return statement;
    }

    @Override
    public Statement visitAddRecordStatement(TableQueryGrammarParser.AddRecordStatementContext ctx) {
        AddRecordStatement statement = new AddRecordStatement();
        statement.setTableName(ctx.tableName().getText().toLowerCase());
        statement.setType(TypeEnum.ADD);
        statement.setColumnAssignmentWithContext(ctx.columnAssignment());
        return statement;
    }

    @Override
    public Statement visitFindRecordStatement(TableQueryGrammarParser.FindRecordStatementContext ctx) {
        FindRecordStatement statement = new FindRecordStatement();
        statement.setSelectedColumn(parseSelectedColumns(ctx.columnList()));
        statement.setTableName(ctx.tableName().getText().toLowerCase());
        statement.setType(TypeEnum.FIND);
        if (ctx.conditionList() != null) {
            TableQueryGrammarParser.LogicalExpressionContext root = ctx.conditionList().expression().logicalExpression();
            statement.setCondition(parseCondition(root));
        }
        return statement;
    }

    public Statement visitDeleteRecordStatement(TableQueryGrammarParser.DeleteRecordStatementContext ctx) {
        DeleteStatement statement = new DeleteStatement();
        statement.setTableName(ctx.tableName().getText());
        statement.setType(TypeEnum.DELETE);
        if (ctx.conditionList() != null) {
            TableQueryGrammarParser.LogicalExpressionContext root = ctx.conditionList().expression().logicalExpression();
            statement.setCondition(parseCondition(root));
        }
        return statement;
    }

    private List<String> parseSelectedColumns(TableQueryGrammarParser.ColumnListContext columnList) {
        List<String> selectedColumns = new ArrayList<>();
        if (columnList.columnName().size() == 0) {
            selectedColumns.add("*");
        }

        for (TableQueryGrammarParser.ColumnNameContext columnNameContext : columnList.columnName()) {
            selectedColumns.add(columnNameContext.getText().toLowerCase());
        }
        return selectedColumns;
    }


    private ConditionNode parseCondition(TableQueryGrammarParser.LogicalExpressionContext root) {
        if (root.logicalExpression().size() == 0) {
            // there is only condition, without 'NOT'
            // use ConditionExpression
            ConditionExpression expression = new ConditionExpression();
            expression.setColumnName(root.comparisonExpression().columnName().getText());
            expression.setValue(root.comparisonExpression().dataValue().getText());
            switch (root.comparisonExpression().children.get(1).getText()) {
                case "=" -> expression.setComparator(ComparisonOperator.EQ);
                case ">" -> expression.setComparator(ComparisonOperator.GT);
                case ">=" -> expression.setComparator(ComparisonOperator.GTE);
                case "<" -> expression.setComparator(ComparisonOperator.LT);
                case "<=" -> expression.setComparator(ComparisonOperator.LTE);
                case "!=" -> expression.setComparator(ComparisonOperator.NEQ);
            }
            return expression;
        } else if (root.logicalExpression().size() == 1) {
            // there is only one condition, but after a 'NOT'
            // use ConditionExpression to change it
            // !!! does not support nested conditions that needs inference like not (A and B)
            // use can only input not A or not B
            // !!!!!! no nested
            ConditionExpression expression = new ConditionExpression();
            expression.setColumnName(root.logicalExpression(0).comparisonExpression().columnName().getText());
            expression.setValue(root.logicalExpression(0).comparisonExpression().dataValue().getText());
            switch (root.logicalExpression(0).comparisonExpression().children.get(1).getText()) {
                case "=" -> expression.setComparator(ComparisonOperator.NEQ);
                case ">" -> expression.setComparator(ComparisonOperator.LTE);
                case ">=" -> expression.setComparator(ComparisonOperator.LT);
                case "<" -> expression.setComparator(ComparisonOperator.GTE);
                case "<=" -> expression.setComparator(ComparisonOperator.GT);
                case "!=" -> expression.setComparator(ComparisonOperator.EQ);
            }
            return expression;
        } else {
            LogicalConditionNode node = new LogicalConditionNode();
            node.setLeft(parseCondition(root.logicalExpression(0)));
            node.setRight(parseCondition(root.logicalExpression(1)));
            if (root.AND() != null) {
                node.setOperator(LogicalOperator.AND);
            } else if (root.OR() != null) {
                node.setOperator(LogicalOperator.OR);
            }
            return node;
        }
    }


}
