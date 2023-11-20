// Generated from E:/Libraries/code/course/DSCI551/finalProject/MyDB/src/main/java/org/example/antlr/TableQueryGrammar.g4 by ANTLR 4.13.1
package org.example.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TableQueryGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TableQueryGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(TableQueryGrammarParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#createTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTableStatement(TableQueryGrammarParser.CreateTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#dropTableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropTableStatement(TableQueryGrammarParser.DropTableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#addRecordStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddRecordStatement(TableQueryGrammarParser.AddRecordStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#findRecordStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFindRecordStatement(TableQueryGrammarParser.FindRecordStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#sortByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSortByClause(TableQueryGrammarParser.SortByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#updateRecordStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateRecordStatement(TableQueryGrammarParser.UpdateRecordStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#deleteRecordStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteRecordStatement(TableQueryGrammarParser.DeleteRecordStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#conditionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionList(TableQueryGrammarParser.ConditionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TableQueryGrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#groupByClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupByClause(TableQueryGrammarParser.GroupByClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#columnList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnList(TableQueryGrammarParser.ColumnListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#tableColumnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableColumnName(TableQueryGrammarParser.TableColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#joinConditionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinConditionList(TableQueryGrammarParser.JoinConditionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#joinCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinCondition(TableQueryGrammarParser.JoinConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExpression(TableQueryGrammarParser.LogicalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#comparisonExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(TableQueryGrammarParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#columnDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDefinition(TableQueryGrammarParser.ColumnDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#columnAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnAssignment(TableQueryGrammarParser.ColumnAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#columnName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnName(TableQueryGrammarParser.ColumnNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#aggregateFunctions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunctions(TableQueryGrammarParser.AggregateFunctionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#dataValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataValue(TableQueryGrammarParser.DataValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(TableQueryGrammarParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link TableQueryGrammarParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(TableQueryGrammarParser.DataTypeContext ctx);
}