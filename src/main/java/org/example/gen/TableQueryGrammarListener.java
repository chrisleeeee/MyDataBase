// Generated from E:/Libraries/code/course/DSCI551/finalProject/MyDB/src/main/java/org/example/antlr/TableQueryGrammar.g4 by ANTLR 4.13.1
package org.example.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TableQueryGrammarParser}.
 */
public interface TableQueryGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(TableQueryGrammarParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(TableQueryGrammarParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableStatement(TableQueryGrammarParser.CreateTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#createTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableStatement(TableQueryGrammarParser.CreateTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#dropTableStatement}.
	 * @param ctx the parse tree
	 */
	void enterDropTableStatement(TableQueryGrammarParser.DropTableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#dropTableStatement}.
	 * @param ctx the parse tree
	 */
	void exitDropTableStatement(TableQueryGrammarParser.DropTableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#addRecordStatement}.
	 * @param ctx the parse tree
	 */
	void enterAddRecordStatement(TableQueryGrammarParser.AddRecordStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#addRecordStatement}.
	 * @param ctx the parse tree
	 */
	void exitAddRecordStatement(TableQueryGrammarParser.AddRecordStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#findRecordStatement}.
	 * @param ctx the parse tree
	 */
	void enterFindRecordStatement(TableQueryGrammarParser.FindRecordStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#findRecordStatement}.
	 * @param ctx the parse tree
	 */
	void exitFindRecordStatement(TableQueryGrammarParser.FindRecordStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#conditionList}.
	 * @param ctx the parse tree
	 */
	void enterConditionList(TableQueryGrammarParser.ConditionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#conditionList}.
	 * @param ctx the parse tree
	 */
	void exitConditionList(TableQueryGrammarParser.ConditionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TableQueryGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TableQueryGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#columnList}.
	 * @param ctx the parse tree
	 */
	void enterColumnList(TableQueryGrammarParser.ColumnListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#columnList}.
	 * @param ctx the parse tree
	 */
	void exitColumnList(TableQueryGrammarParser.ColumnListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExpression(TableQueryGrammarParser.LogicalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#logicalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExpression(TableQueryGrammarParser.LogicalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(TableQueryGrammarParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#comparisonExpression}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(TableQueryGrammarParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterColumnDefinition(TableQueryGrammarParser.ColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitColumnDefinition(TableQueryGrammarParser.ColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#columnAssignment}.
	 * @param ctx the parse tree
	 */
	void enterColumnAssignment(TableQueryGrammarParser.ColumnAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#columnAssignment}.
	 * @param ctx the parse tree
	 */
	void exitColumnAssignment(TableQueryGrammarParser.ColumnAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(TableQueryGrammarParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(TableQueryGrammarParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#dataValue}.
	 * @param ctx the parse tree
	 */
	void enterDataValue(TableQueryGrammarParser.DataValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#dataValue}.
	 * @param ctx the parse tree
	 */
	void exitDataValue(TableQueryGrammarParser.DataValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(TableQueryGrammarParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(TableQueryGrammarParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TableQueryGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(TableQueryGrammarParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TableQueryGrammarParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(TableQueryGrammarParser.DataTypeContext ctx);
}