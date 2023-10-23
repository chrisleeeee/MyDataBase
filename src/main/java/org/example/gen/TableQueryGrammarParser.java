// Generated from E:/Libraries/code/course/DSCI551/finalProject/MyDB/src/main/java/org/example/antlr/TableQueryGrammar.g4 by ANTLR 4.13.1
package org.example.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TableQueryGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, CreateTable=14, DropTable=15, AddRecord=16, 
		FindRecord=17, UpdateRecord=18, DeleteRecord=19, MAX=20, MIN=21, AVG=22, 
		SUM=23, COUNT=24, GroupBy=25, Join=26, On=27, From=28, Having=29, To=30, 
		AND=31, OR=32, NOT=33, Integer=34, Float=35, String=36, INT_VALUE=37, 
		FlOAT_VALUE=38, STRING_VALUE=39, IDENTIFIER=40, DIGIT=41, WS=42;
	public static final int
		RULE_query = 0, RULE_createTableStatement = 1, RULE_dropTableStatement = 2, 
		RULE_addRecordStatement = 3, RULE_findRecordStatement = 4, RULE_updateRecordStatement = 5, 
		RULE_deleteRecordStatement = 6, RULE_conditionList = 7, RULE_expression = 8, 
		RULE_groupByClause = 9, RULE_columnList = 10, RULE_tableColumnName = 11, 
		RULE_joinConditionList = 12, RULE_joinCondition = 13, RULE_logicalExpression = 14, 
		RULE_comparisonExpression = 15, RULE_columnDefinition = 16, RULE_columnAssignment = 17, 
		RULE_columnName = 18, RULE_aggregateFunctions = 19, RULE_dataValue = 20, 
		RULE_tableName = 21, RULE_dataType = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "createTableStatement", "dropTableStatement", "addRecordStatement", 
			"findRecordStatement", "updateRecordStatement", "deleteRecordStatement", 
			"conditionList", "expression", "groupByClause", "columnList", "tableColumnName", 
			"joinConditionList", "joinCondition", "logicalExpression", "comparisonExpression", 
			"columnDefinition", "columnAssignment", "columnName", "aggregateFunctions", 
			"dataValue", "tableName", "dataType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "';'", "'.'", "'='", "'<'", "'>'", "'>='", 
			"'<='", "'!='", "':'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "CreateTable", "DropTable", "AddRecord", "FindRecord", "UpdateRecord", 
			"DeleteRecord", "MAX", "MIN", "AVG", "SUM", "COUNT", "GroupBy", "Join", 
			"On", "From", "Having", "To", "AND", "OR", "NOT", "Integer", "Float", 
			"String", "INT_VALUE", "FlOAT_VALUE", "STRING_VALUE", "IDENTIFIER", "DIGIT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TableQueryGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TableQueryGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QueryContext extends ParserRuleContext {
		public CreateTableStatementContext createTableStatement() {
			return getRuleContext(CreateTableStatementContext.class,0);
		}
		public DropTableStatementContext dropTableStatement() {
			return getRuleContext(DropTableStatementContext.class,0);
		}
		public AddRecordStatementContext addRecordStatement() {
			return getRuleContext(AddRecordStatementContext.class,0);
		}
		public FindRecordStatementContext findRecordStatement() {
			return getRuleContext(FindRecordStatementContext.class,0);
		}
		public UpdateRecordStatementContext updateRecordStatement() {
			return getRuleContext(UpdateRecordStatementContext.class,0);
		}
		public DeleteRecordStatementContext deleteRecordStatement() {
			return getRuleContext(DeleteRecordStatementContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CreateTable:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				createTableStatement();
				}
				break;
			case DropTable:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				dropTableStatement();
				}
				break;
			case AddRecord:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				addRecordStatement();
				}
				break;
			case FindRecord:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				findRecordStatement();
				}
				break;
			case UpdateRecord:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				updateRecordStatement();
				}
				break;
			case DeleteRecord:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				deleteRecordStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreateTableStatementContext extends ParserRuleContext {
		public TerminalNode CreateTable() { return getToken(TableQueryGrammarParser.CreateTable, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<ColumnDefinitionContext> columnDefinition() {
			return getRuleContexts(ColumnDefinitionContext.class);
		}
		public ColumnDefinitionContext columnDefinition(int i) {
			return getRuleContext(ColumnDefinitionContext.class,i);
		}
		public CreateTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterCreateTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitCreateTableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitCreateTableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreateTableStatementContext createTableStatement() throws RecognitionException {
		CreateTableStatementContext _localctx = new CreateTableStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_createTableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(CreateTable);
			setState(55);
			tableName();
			setState(56);
			match(T__0);
			setState(57);
			columnDefinition();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(58);
				match(T__1);
				setState(59);
				columnDefinition();
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			match(T__2);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(66);
				match(T__3);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DropTableStatementContext extends ParserRuleContext {
		public TerminalNode DropTable() { return getToken(TableQueryGrammarParser.DropTable, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public DropTableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropTableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterDropTableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitDropTableStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitDropTableStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DropTableStatementContext dropTableStatement() throws RecognitionException {
		DropTableStatementContext _localctx = new DropTableStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dropTableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(DropTable);
			setState(70);
			tableName();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(71);
				match(T__3);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddRecordStatementContext extends ParserRuleContext {
		public TerminalNode AddRecord() { return getToken(TableQueryGrammarParser.AddRecord, 0); }
		public List<ColumnAssignmentContext> columnAssignment() {
			return getRuleContexts(ColumnAssignmentContext.class);
		}
		public ColumnAssignmentContext columnAssignment(int i) {
			return getRuleContext(ColumnAssignmentContext.class,i);
		}
		public TerminalNode To() { return getToken(TableQueryGrammarParser.To, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public AddRecordStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addRecordStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterAddRecordStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitAddRecordStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitAddRecordStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddRecordStatementContext addRecordStatement() throws RecognitionException {
		AddRecordStatementContext _localctx = new AddRecordStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_addRecordStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(AddRecord);
			setState(75);
			match(T__0);
			setState(76);
			columnAssignment();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(77);
				match(T__1);
				setState(78);
				columnAssignment();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(T__2);
			setState(85);
			match(To);
			setState(86);
			tableName();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(87);
				match(T__3);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FindRecordStatementContext extends ParserRuleContext {
		public TerminalNode FindRecord() { return getToken(TableQueryGrammarParser.FindRecord, 0); }
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public TerminalNode From() { return getToken(TableQueryGrammarParser.From, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TableQueryGrammarParser.EOF, 0); }
		public JoinConditionListContext joinConditionList() {
			return getRuleContext(JoinConditionListContext.class,0);
		}
		public ConditionListContext conditionList() {
			return getRuleContext(ConditionListContext.class,0);
		}
		public GroupByClauseContext groupByClause() {
			return getRuleContext(GroupByClauseContext.class,0);
		}
		public FindRecordStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_findRecordStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterFindRecordStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitFindRecordStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitFindRecordStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FindRecordStatementContext findRecordStatement() throws RecognitionException {
		FindRecordStatementContext _localctx = new FindRecordStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_findRecordStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(FindRecord);
			setState(91);
			columnList();
			setState(92);
			match(From);
			setState(93);
			tableName();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Join) {
				{
				setState(94);
				joinConditionList();
				}
			}

			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Having) {
				{
				setState(97);
				conditionList();
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GroupBy) {
				{
				setState(100);
				groupByClause();
				}
			}

			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(103);
				match(T__3);
				}
			}

			setState(106);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UpdateRecordStatementContext extends ParserRuleContext {
		public TerminalNode UpdateRecord() { return getToken(TableQueryGrammarParser.UpdateRecord, 0); }
		public List<ColumnAssignmentContext> columnAssignment() {
			return getRuleContexts(ColumnAssignmentContext.class);
		}
		public ColumnAssignmentContext columnAssignment(int i) {
			return getRuleContext(ColumnAssignmentContext.class,i);
		}
		public TerminalNode From() { return getToken(TableQueryGrammarParser.From, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ConditionListContext conditionList() {
			return getRuleContext(ConditionListContext.class,0);
		}
		public UpdateRecordStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateRecordStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterUpdateRecordStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitUpdateRecordStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitUpdateRecordStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdateRecordStatementContext updateRecordStatement() throws RecognitionException {
		UpdateRecordStatementContext _localctx = new UpdateRecordStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_updateRecordStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(UpdateRecord);
			setState(109);
			match(T__0);
			setState(110);
			columnAssignment();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(111);
				match(T__1);
				setState(112);
				columnAssignment();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(T__2);
			setState(119);
			match(From);
			setState(120);
			tableName();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Having) {
				{
				setState(121);
				conditionList();
				}
			}

			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(124);
				match(T__3);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeleteRecordStatementContext extends ParserRuleContext {
		public TerminalNode DeleteRecord() { return getToken(TableQueryGrammarParser.DeleteRecord, 0); }
		public TerminalNode From() { return getToken(TableQueryGrammarParser.From, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ConditionListContext conditionList() {
			return getRuleContext(ConditionListContext.class,0);
		}
		public DeleteRecordStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteRecordStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterDeleteRecordStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitDeleteRecordStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitDeleteRecordStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeleteRecordStatementContext deleteRecordStatement() throws RecognitionException {
		DeleteRecordStatementContext _localctx = new DeleteRecordStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_deleteRecordStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(DeleteRecord);
			setState(128);
			match(From);
			setState(129);
			tableName();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Having) {
				{
				setState(130);
				conditionList();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionListContext extends ParserRuleContext {
		public TerminalNode Having() { return getToken(TableQueryGrammarParser.Having, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterConditionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitConditionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitConditionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionListContext conditionList() throws RecognitionException {
		ConditionListContext _localctx = new ConditionListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conditionList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(Having);
			setState(134);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public LogicalExpressionContext logicalExpression() {
			return getRuleContext(LogicalExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			logicalExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GroupByClauseContext extends ParserRuleContext {
		public TerminalNode GroupBy() { return getToken(TableQueryGrammarParser.GroupBy, 0); }
		public ColumnListContext columnList() {
			return getRuleContext(ColumnListContext.class,0);
		}
		public GroupByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterGroupByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitGroupByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitGroupByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupByClauseContext groupByClause() throws RecognitionException {
		GroupByClauseContext _localctx = new GroupByClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_groupByClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(GroupBy);
			setState(139);
			columnList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnListContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public ColumnListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterColumnList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitColumnList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitColumnList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnListContext columnList() throws RecognitionException {
		ColumnListContext _localctx = new ColumnListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__0);
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case IDENTIFIER:
				{
				{
				{
				setState(142);
				columnName();
				}
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(143);
					match(T__1);
					{
					setState(144);
					columnName();
					}
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case T__2:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(153);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableColumnNameContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TableColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableColumnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterTableColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitTableColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitTableColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableColumnNameContext tableColumnName() throws RecognitionException {
		TableColumnNameContext _localctx = new TableColumnNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tableColumnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			tableName();
			setState(156);
			match(T__4);
			setState(157);
			columnName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JoinConditionListContext extends ParserRuleContext {
		public List<JoinConditionContext> joinCondition() {
			return getRuleContexts(JoinConditionContext.class);
		}
		public JoinConditionContext joinCondition(int i) {
			return getRuleContext(JoinConditionContext.class,i);
		}
		public JoinConditionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinConditionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterJoinConditionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitJoinConditionList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitJoinConditionList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinConditionListContext joinConditionList() throws RecognitionException {
		JoinConditionListContext _localctx = new JoinConditionListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_joinConditionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(159);
				joinCondition();
				}
				}
				setState(162); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Join );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JoinConditionContext extends ParserRuleContext {
		public TerminalNode Join() { return getToken(TableQueryGrammarParser.Join, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode On() { return getToken(TableQueryGrammarParser.On, 0); }
		public List<TableColumnNameContext> tableColumnName() {
			return getRuleContexts(TableColumnNameContext.class);
		}
		public TableColumnNameContext tableColumnName(int i) {
			return getRuleContext(TableColumnNameContext.class,i);
		}
		public JoinConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterJoinCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitJoinCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitJoinCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JoinConditionContext joinCondition() throws RecognitionException {
		JoinConditionContext _localctx = new JoinConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_joinCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(Join);
			setState(165);
			tableName();
			setState(166);
			match(On);
			setState(167);
			tableColumnName();
			setState(168);
			match(T__5);
			setState(169);
			tableColumnName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpressionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(TableQueryGrammarParser.NOT, 0); }
		public List<LogicalExpressionContext> logicalExpression() {
			return getRuleContexts(LogicalExpressionContext.class);
		}
		public LogicalExpressionContext logicalExpression(int i) {
			return getRuleContext(LogicalExpressionContext.class,i);
		}
		public ComparisonExpressionContext comparisonExpression() {
			return getRuleContext(ComparisonExpressionContext.class,0);
		}
		public TerminalNode AND() { return getToken(TableQueryGrammarParser.AND, 0); }
		public TerminalNode OR() { return getToken(TableQueryGrammarParser.OR, 0); }
		public LogicalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitLogicalExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitLogicalExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalExpressionContext logicalExpression() throws RecognitionException {
		return logicalExpression(0);
	}

	private LogicalExpressionContext logicalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalExpressionContext _localctx = new LogicalExpressionContext(_ctx, _parentState);
		LogicalExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_logicalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(172);
				match(NOT);
				setState(173);
				logicalExpression(4);
				}
				break;
			case T__12:
			case IDENTIFIER:
				{
				setState(174);
				comparisonExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(183);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(177);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(178);
						match(AND);
						setState(179);
						logicalExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(180);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(181);
						match(OR);
						setState(182);
						logicalExpression(3);
						}
						break;
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ParserRuleContext {
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
		}
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public ComparisonExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonExpressionContext comparisonExpression() throws RecognitionException {
		ComparisonExpressionContext _localctx = new ComparisonExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparisonExpression);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(188);
				columnName();
				}
				setState(189);
				match(T__5);
				setState(190);
				dataValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(192);
				columnName();
				}
				setState(193);
				match(T__6);
				setState(194);
				dataValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(196);
				columnName();
				}
				setState(197);
				match(T__7);
				setState(198);
				dataValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(200);
				columnName();
				}
				setState(201);
				match(T__8);
				setState(202);
				dataValue();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(204);
				columnName();
				}
				setState(205);
				match(T__9);
				setState(206);
				dataValue();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(208);
				columnName();
				}
				setState(209);
				match(T__10);
				setState(210);
				dataValue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnDefinitionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataTypeContext dataType() {
			return getRuleContext(DataTypeContext.class,0);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitColumnDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitColumnDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_columnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			columnName();
			setState(215);
			match(T__11);
			setState(216);
			dataType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnAssignmentContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
		}
		public ColumnAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterColumnAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitColumnAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitColumnAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnAssignmentContext columnAssignment() throws RecognitionException {
		ColumnAssignmentContext _localctx = new ColumnAssignmentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_columnAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			columnName();
			setState(219);
			match(T__5);
			setState(220);
			dataValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TableQueryGrammarParser.IDENTIFIER, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public AggregateFunctionsContext aggregateFunctions() {
			return getRuleContext(AggregateFunctionsContext.class,0);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitColumnName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitColumnName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_columnName);
		int _la;
		try {
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(225);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(222);
					tableName();
					setState(223);
					match(T__4);
					}
					break;
				}
				setState(227);
				match(IDENTIFIER);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(228);
					match(T__4);
					setState(229);
					aggregateFunctions();
					}
				}

				}
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(232);
				match(T__12);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(233);
					match(T__4);
					setState(234);
					aggregateFunctions();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AggregateFunctionsContext extends ParserRuleContext {
		public TerminalNode MAX() { return getToken(TableQueryGrammarParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(TableQueryGrammarParser.MIN, 0); }
		public TerminalNode AVG() { return getToken(TableQueryGrammarParser.AVG, 0); }
		public TerminalNode SUM() { return getToken(TableQueryGrammarParser.SUM, 0); }
		public TerminalNode COUNT() { return getToken(TableQueryGrammarParser.COUNT, 0); }
		public AggregateFunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateFunctions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterAggregateFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitAggregateFunctions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitAggregateFunctions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateFunctionsContext aggregateFunctions() throws RecognitionException {
		AggregateFunctionsContext _localctx = new AggregateFunctionsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_aggregateFunctions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32505856L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataValueContext extends ParserRuleContext {
		public TerminalNode INT_VALUE() { return getToken(TableQueryGrammarParser.INT_VALUE, 0); }
		public TerminalNode STRING_VALUE() { return getToken(TableQueryGrammarParser.STRING_VALUE, 0); }
		public TerminalNode FlOAT_VALUE() { return getToken(TableQueryGrammarParser.FlOAT_VALUE, 0); }
		public DataValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterDataValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitDataValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitDataValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataValueContext dataValue() throws RecognitionException {
		DataValueContext _localctx = new DataValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_dataValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 962072674304L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TableQueryGrammarParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitTableName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitTableName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DataTypeContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(TableQueryGrammarParser.Integer, 0); }
		public TerminalNode String() { return getToken(TableQueryGrammarParser.String, 0); }
		public TerminalNode INT_VALUE() { return getToken(TableQueryGrammarParser.INT_VALUE, 0); }
		public TerminalNode Float() { return getToken(TableQueryGrammarParser.Float, 0); }
		public DataTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterDataType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitDataType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitDataType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeContext dataType() throws RecognitionException {
		DataTypeContext _localctx = new DataTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dataType);
		try {
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(Integer);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				match(String);
				setState(247);
				match(T__0);
				setState(248);
				match(INT_VALUE);
				setState(249);
				match(T__2);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				match(Float);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return logicalExpression_sempred((LogicalExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicalExpression_sempred(LogicalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001*\u00fe\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u00005\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001=\b\u0001"+
		"\n\u0001\f\u0001@\t\u0001\u0001\u0001\u0001\u0001\u0003\u0001D\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002I\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003P\b\u0003"+
		"\n\u0003\f\u0003S\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003Y\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004`\b\u0004\u0001\u0004\u0003\u0004c\b\u0004\u0001"+
		"\u0004\u0003\u0004f\b\u0004\u0001\u0004\u0003\u0004i\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005r\b\u0005\n\u0005\f\u0005u\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005{\b\u0005\u0001\u0005\u0003\u0005"+
		"~\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u0084\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0092\b\n\n"+
		"\n\f\n\u0095\t\n\u0001\n\u0003\n\u0098\b\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0004\f\u00a1\b\f\u000b\f"+
		"\f\f\u00a2\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00b0\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00b8\b\u000e\n\u000e\f\u000e\u00bb\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00d5\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u00e2\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00e7\b"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00ec\b\u0012\u0003"+
		"\u0012\u00ee\b\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u00fc\b\u0016\u0001\u0016\u0000\u0001\u001c"+
		"\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,\u0000\u0002\u0001\u0000\u0014\u0018\u0001\u0000"+
		"%\'\u0109\u00004\u0001\u0000\u0000\u0000\u00026\u0001\u0000\u0000\u0000"+
		"\u0004E\u0001\u0000\u0000\u0000\u0006J\u0001\u0000\u0000\u0000\bZ\u0001"+
		"\u0000\u0000\u0000\nl\u0001\u0000\u0000\u0000\f\u007f\u0001\u0000\u0000"+
		"\u0000\u000e\u0085\u0001\u0000\u0000\u0000\u0010\u0088\u0001\u0000\u0000"+
		"\u0000\u0012\u008a\u0001\u0000\u0000\u0000\u0014\u008d\u0001\u0000\u0000"+
		"\u0000\u0016\u009b\u0001\u0000\u0000\u0000\u0018\u00a0\u0001\u0000\u0000"+
		"\u0000\u001a\u00a4\u0001\u0000\u0000\u0000\u001c\u00af\u0001\u0000\u0000"+
		"\u0000\u001e\u00d4\u0001\u0000\u0000\u0000 \u00d6\u0001\u0000\u0000\u0000"+
		"\"\u00da\u0001\u0000\u0000\u0000$\u00ed\u0001\u0000\u0000\u0000&\u00ef"+
		"\u0001\u0000\u0000\u0000(\u00f1\u0001\u0000\u0000\u0000*\u00f3\u0001\u0000"+
		"\u0000\u0000,\u00fb\u0001\u0000\u0000\u0000.5\u0003\u0002\u0001\u0000"+
		"/5\u0003\u0004\u0002\u000005\u0003\u0006\u0003\u000015\u0003\b\u0004\u0000"+
		"25\u0003\n\u0005\u000035\u0003\f\u0006\u00004.\u0001\u0000\u0000\u0000"+
		"4/\u0001\u0000\u0000\u000040\u0001\u0000\u0000\u000041\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u000043\u0001\u0000\u0000\u00005\u0001\u0001"+
		"\u0000\u0000\u000067\u0005\u000e\u0000\u000078\u0003*\u0015\u000089\u0005"+
		"\u0001\u0000\u00009>\u0003 \u0010\u0000:;\u0005\u0002\u0000\u0000;=\u0003"+
		" \u0010\u0000<:\u0001\u0000\u0000\u0000=@\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000AC\u0005\u0003\u0000\u0000BD\u0005\u0004\u0000"+
		"\u0000CB\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000D\u0003\u0001"+
		"\u0000\u0000\u0000EF\u0005\u000f\u0000\u0000FH\u0003*\u0015\u0000GI\u0005"+
		"\u0004\u0000\u0000HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"I\u0005\u0001\u0000\u0000\u0000JK\u0005\u0010\u0000\u0000KL\u0005\u0001"+
		"\u0000\u0000LQ\u0003\"\u0011\u0000MN\u0005\u0002\u0000\u0000NP\u0003\""+
		"\u0011\u0000OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001"+
		"\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000TU\u0005\u0003\u0000\u0000UV\u0005\u001e\u0000"+
		"\u0000VX\u0003*\u0015\u0000WY\u0005\u0004\u0000\u0000XW\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000Y\u0007\u0001\u0000\u0000\u0000Z[\u0005"+
		"\u0011\u0000\u0000[\\\u0003\u0014\n\u0000\\]\u0005\u001c\u0000\u0000]"+
		"_\u0003*\u0015\u0000^`\u0003\u0018\f\u0000_^\u0001\u0000\u0000\u0000_"+
		"`\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000ac\u0003\u000e\u0007"+
		"\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000"+
		"\u0000\u0000df\u0003\u0012\t\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000"+
		"\u0000\u0000fh\u0001\u0000\u0000\u0000gi\u0005\u0004\u0000\u0000hg\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000"+
		"jk\u0005\u0000\u0000\u0001k\t\u0001\u0000\u0000\u0000lm\u0005\u0012\u0000"+
		"\u0000mn\u0005\u0001\u0000\u0000ns\u0003\"\u0011\u0000op\u0005\u0002\u0000"+
		"\u0000pr\u0003\"\u0011\u0000qo\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001\u0000"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005\u0003\u0000\u0000wx\u0005"+
		"\u001c\u0000\u0000xz\u0003*\u0015\u0000y{\u0003\u000e\u0007\u0000zy\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000"+
		"|~\u0005\u0004\u0000\u0000}|\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u000b\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0013\u0000\u0000"+
		"\u0080\u0081\u0005\u001c\u0000\u0000\u0081\u0083\u0003*\u0015\u0000\u0082"+
		"\u0084\u0003\u000e\u0007\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\r\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0005\u001d\u0000\u0000\u0086\u0087\u0003\u0010\b\u0000\u0087\u000f\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0003\u001c\u000e\u0000\u0089\u0011\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0005\u0019\u0000\u0000\u008b\u008c\u0003"+
		"\u0014\n\u0000\u008c\u0013\u0001\u0000\u0000\u0000\u008d\u0097\u0005\u0001"+
		"\u0000\u0000\u008e\u0093\u0003$\u0012\u0000\u008f\u0090\u0005\u0002\u0000"+
		"\u0000\u0090\u0092\u0003$\u0012\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0098\u0001\u0000\u0000\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0098\u0001\u0000\u0000\u0000"+
		"\u0097\u008e\u0001\u0000\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0003\u0000\u0000"+
		"\u009a\u0015\u0001\u0000\u0000\u0000\u009b\u009c\u0003*\u0015\u0000\u009c"+
		"\u009d\u0005\u0005\u0000\u0000\u009d\u009e\u0003$\u0012\u0000\u009e\u0017"+
		"\u0001\u0000\u0000\u0000\u009f\u00a1\u0003\u001a\r\u0000\u00a0\u009f\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u0019\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0005\u001a\u0000\u0000\u00a5\u00a6\u0003"+
		"*\u0015\u0000\u00a6\u00a7\u0005\u001b\u0000\u0000\u00a7\u00a8\u0003\u0016"+
		"\u000b\u0000\u00a8\u00a9\u0005\u0006\u0000\u0000\u00a9\u00aa\u0003\u0016"+
		"\u000b\u0000\u00aa\u001b\u0001\u0000\u0000\u0000\u00ab\u00ac\u0006\u000e"+
		"\uffff\uffff\u0000\u00ac\u00ad\u0005!\u0000\u0000\u00ad\u00b0\u0003\u001c"+
		"\u000e\u0004\u00ae\u00b0\u0003\u001e\u000f\u0000\u00af\u00ab\u0001\u0000"+
		"\u0000\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b9\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\n\u0003\u0000\u0000\u00b2\u00b3\u0005\u001f\u0000"+
		"\u0000\u00b3\u00b8\u0003\u001c\u000e\u0004\u00b4\u00b5\n\u0002\u0000\u0000"+
		"\u00b5\u00b6\u0005 \u0000\u0000\u00b6\u00b8\u0003\u001c\u000e\u0003\u00b7"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b7\u00b4\u0001\u0000\u0000\u0000\u00b8"+
		"\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9"+
		"\u00ba\u0001\u0000\u0000\u0000\u00ba\u001d\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bc\u00bd\u0003$\u0012\u0000\u00bd\u00be"+
		"\u0005\u0006\u0000\u0000\u00be\u00bf\u0003(\u0014\u0000\u00bf\u00d5\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0003$\u0012\u0000\u00c1\u00c2\u0005\u0007"+
		"\u0000\u0000\u00c2\u00c3\u0003(\u0014\u0000\u00c3\u00d5\u0001\u0000\u0000"+
		"\u0000\u00c4\u00c5\u0003$\u0012\u0000\u00c5\u00c6\u0005\b\u0000\u0000"+
		"\u00c6\u00c7\u0003(\u0014\u0000\u00c7\u00d5\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0003$\u0012\u0000\u00c9\u00ca\u0005\t\u0000\u0000\u00ca\u00cb"+
		"\u0003(\u0014\u0000\u00cb\u00d5\u0001\u0000\u0000\u0000\u00cc\u00cd\u0003"+
		"$\u0012\u0000\u00cd\u00ce\u0005\n\u0000\u0000\u00ce\u00cf\u0003(\u0014"+
		"\u0000\u00cf\u00d5\u0001\u0000\u0000\u0000\u00d0\u00d1\u0003$\u0012\u0000"+
		"\u00d1\u00d2\u0005\u000b\u0000\u0000\u00d2\u00d3\u0003(\u0014\u0000\u00d3"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d4\u00bc\u0001\u0000\u0000\u0000\u00d4"+
		"\u00c0\u0001\u0000\u0000\u0000\u00d4\u00c4\u0001\u0000\u0000\u0000\u00d4"+
		"\u00c8\u0001\u0000\u0000\u0000\u00d4\u00cc\u0001\u0000\u0000\u0000\u00d4"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d5\u001f\u0001\u0000\u0000\u0000\u00d6"+
		"\u00d7\u0003$\u0012\u0000\u00d7\u00d8\u0005\f\u0000\u0000\u00d8\u00d9"+
		"\u0003,\u0016\u0000\u00d9!\u0001\u0000\u0000\u0000\u00da\u00db\u0003$"+
		"\u0012\u0000\u00db\u00dc\u0005\u0006\u0000\u0000\u00dc\u00dd\u0003(\u0014"+
		"\u0000\u00dd#\u0001\u0000\u0000\u0000\u00de\u00df\u0003*\u0015\u0000\u00df"+
		"\u00e0\u0005\u0005\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1"+
		"\u00de\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e6\u0005(\u0000\u0000\u00e4\u00e5"+
		"\u0005\u0005\u0000\u0000\u00e5\u00e7\u0003&\u0013\u0000\u00e6\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00ee\u0001"+
		"\u0000\u0000\u0000\u00e8\u00eb\u0005\r\u0000\u0000\u00e9\u00ea\u0005\u0005"+
		"\u0000\u0000\u00ea\u00ec\u0003&\u0013\u0000\u00eb\u00e9\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ed\u00e1\u0001\u0000\u0000\u0000\u00ed\u00e8\u0001\u0000\u0000"+
		"\u0000\u00ee%\u0001\u0000\u0000\u0000\u00ef\u00f0\u0007\u0000\u0000\u0000"+
		"\u00f0\'\u0001\u0000\u0000\u0000\u00f1\u00f2\u0007\u0001\u0000\u0000\u00f2"+
		")\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005(\u0000\u0000\u00f4+\u0001"+
		"\u0000\u0000\u0000\u00f5\u00fc\u0005\"\u0000\u0000\u00f6\u00f7\u0005$"+
		"\u0000\u0000\u00f7\u00f8\u0005\u0001\u0000\u0000\u00f8\u00f9\u0005%\u0000"+
		"\u0000\u00f9\u00fc\u0005\u0003\u0000\u0000\u00fa\u00fc\u0005#\u0000\u0000"+
		"\u00fb\u00f5\u0001\u0000\u0000\u0000\u00fb\u00f6\u0001\u0000\u0000\u0000"+
		"\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc-\u0001\u0000\u0000\u0000\u001a"+
		"4>CHQX_behsz}\u0083\u0093\u0097\u00a2\u00af\u00b7\u00b9\u00d4\u00e1\u00e6"+
		"\u00eb\u00ed\u00fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}