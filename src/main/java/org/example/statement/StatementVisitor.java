package org.example.statement;

import org.example.gen.TableQueryGrammarBaseVisitor;
import org.example.gen.TableQueryGrammarParser;
import org.example.model.AggregateType;
import org.example.model.JoinClause;
import org.example.model.SelectedColumn;
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


        if(ctx.joinConditionList() != null) {
            List<TableQueryGrammarParser.JoinConditionContext> joinConditionContexts = ctx.joinConditionList().joinCondition();
            List<JoinClause> joinClauses = new ArrayList<>();
            for (TableQueryGrammarParser.JoinConditionContext context : joinConditionContexts) {
                joinClauses.add(new JoinClause(context.tableName().getText().toLowerCase(),
                        new SelectedColumn(null, context.tableColumnName().get(0).tableName().getText().toLowerCase(),context.tableColumnName().get(0).columnName().getText().toLowerCase()),
                        new SelectedColumn(null, context.tableColumnName().get(1).tableName().getText().toLowerCase(),context.tableColumnName().get(1).columnName().getText().toLowerCase())));
            }
            statement.setJoinClause(joinClauses);
        }

        if (ctx.conditionList() != null) {
            TableQueryGrammarParser.LogicalExpressionContext root = ctx.conditionList().expression().logicalExpression();
            statement.setCondition(parseCondition(root));
        }

        if(ctx.groupByClause() != null) {
            List<SelectedColumn> groupByColumns = new ArrayList<>();
            for (TableQueryGrammarParser.ColumnNameContext context : ctx.groupByClause().columnList().columnName()) {
                SelectedColumn r = new SelectedColumn();
                if(context.tableName()!= null) {
                    r.setTableName(context.tableName().getText().toLowerCase());
                }
                r.setColumnName(context.IDENTIFIER().getText().toLowerCase());
                groupByColumns.add(r);
            }
            statement.setGroupByColumn(groupByColumns);
        }
        return statement;
    }

    @Override
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

    @Override
    public Statement visitUpdateRecordStatement(TableQueryGrammarParser.UpdateRecordStatementContext ctx) {
        UpdateStatement statement = new UpdateStatement();
        statement.setType(TypeEnum.UPDATE);
        statement.setTableName(ctx.tableName().getText().toLowerCase());
        if (ctx.conditionList() != null) {
            TableQueryGrammarParser.LogicalExpressionContext root = ctx.conditionList().expression().logicalExpression();
            statement.setCondition(parseCondition(root));
        }
        statement.setColumnAssignmentWithContext(ctx.columnAssignment());
        return statement;
    }

    private List<SelectedColumn> parseSelectedColumns(TableQueryGrammarParser.ColumnListContext columnList) {
        List<SelectedColumn> selectedColumns = new ArrayList<>();
        if (columnList.columnName().size() == 0) {
            SelectedColumn selectedColumn = new SelectedColumn();
            selectedColumn.setColumnName("*");
            selectedColumns.add(selectedColumn);
        }

        for (TableQueryGrammarParser.ColumnNameContext columnNameContext : columnList.columnName()) {
            SelectedColumn selectedColumn = new SelectedColumn();
            if(columnNameContext.tableName()!= null) {
                selectedColumn.setTableName(columnNameContext.tableName().getText().toLowerCase());
            }

            if(columnNameContext.aggregateFunctions() != null) {
                String aggregateType = columnNameContext.aggregateFunctions().getText();
                if(aggregateType.equalsIgnoreCase("min")) {
                    selectedColumn.setType(AggregateType.MIN);
                } else if(aggregateType.equalsIgnoreCase("max")) {
                    selectedColumn.setType(AggregateType.MAX);
                } else if(aggregateType.equalsIgnoreCase("count")) {
                    selectedColumn.setType(AggregateType.COUNT);
                } else if(aggregateType.equalsIgnoreCase("sum")) {
                    selectedColumn.setType(AggregateType.SUM);
                } else if(aggregateType.equalsIgnoreCase("avg")) {
                    selectedColumn.setType(AggregateType.AVG);
                }
            }
            if(columnNameContext.getText().startsWith("*")) {
                selectedColumn.setColumnName("*");
            } else {
                selectedColumn.setColumnName(columnNameContext.IDENTIFIER().toString());
            }

            selectedColumns.add(selectedColumn);
        }
        return selectedColumns;
    }


    private ConditionNode parseCondition(TableQueryGrammarParser.LogicalExpressionContext root) {
        if (root.logicalExpression().size() == 0) {
            // there is only condition, without 'NOT'
            // use ConditionExpression
            ConditionExpression expression = new ConditionExpression();

            SelectedColumn column = new SelectedColumn();
            column.setColumnName(root.comparisonExpression().columnName().IDENTIFIER().getText().toLowerCase());
            if(root.comparisonExpression().columnName().tableName() != null) {
                column.setTableName(root.comparisonExpression().columnName().tableName().getText().toLowerCase());
            }
            expression.setValue(root.comparisonExpression().dataValue().getText());

            expression.setColumnName(column);
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

            SelectedColumn column = new SelectedColumn();
            column.setColumnName(root.logicalExpression(0).comparisonExpression().columnName().IDENTIFIER().getText().toLowerCase());
            if(root.logicalExpression(0).comparisonExpression().columnName().tableName() != null) {
                column.setTableName(root.logicalExpression(0).comparisonExpression().columnName().tableName().getText().toLowerCase());
            }

            expression.setColumnName(column);
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
