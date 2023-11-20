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
		SUM=23, COUNT=24, GroupBy=25, SortBy=26, Join=27, On=28, From=29, Having=30, 
		To=31, AND=32, OR=33, NOT=34, Integer=35, Float=36, String=37, DESC=38, 
		INC=39, INT_VALUE=40, FlOAT_VALUE=41, STRING_VALUE=42, IDENTIFIER=43, 
		DIGIT=44, WS=45;
	public static final int
		RULE_query = 0, RULE_createTableStatement = 1, RULE_dropTableStatement = 2, 
		RULE_addRecordStatement = 3, RULE_findRecordStatement = 4, RULE_sortByClause = 5, 
		RULE_updateRecordStatement = 6, RULE_deleteRecordStatement = 7, RULE_conditionList = 8, 
		RULE_expression = 9, RULE_groupByClause = 10, RULE_columnList = 11, RULE_tableColumnName = 12, 
		RULE_joinConditionList = 13, RULE_joinCondition = 14, RULE_logicalExpression = 15, 
		RULE_comparisonExpression = 16, RULE_columnDefinition = 17, RULE_columnAssignment = 18, 
		RULE_columnName = 19, RULE_aggregateFunctions = 20, RULE_dataValue = 21, 
		RULE_tableName = 22, RULE_dataType = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "createTableStatement", "dropTableStatement", "addRecordStatement", 
			"findRecordStatement", "sortByClause", "updateRecordStatement", "deleteRecordStatement", 
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
			"DeleteRecord", "MAX", "MIN", "AVG", "SUM", "COUNT", "GroupBy", "SortBy", 
			"Join", "On", "From", "Having", "To", "AND", "OR", "NOT", "Integer", 
			"Float", "String", "DESC", "INC", "INT_VALUE", "FlOAT_VALUE", "STRING_VALUE", 
			"IDENTIFIER", "DIGIT", "WS"
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
			setState(54);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CreateTable:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				createTableStatement();
				}
				break;
			case DropTable:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				dropTableStatement();
				}
				break;
			case AddRecord:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				addRecordStatement();
				}
				break;
			case FindRecord:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				findRecordStatement();
				}
				break;
			case UpdateRecord:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				updateRecordStatement();
				}
				break;
			case DeleteRecord:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
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
			setState(56);
			match(CreateTable);
			setState(57);
			tableName();
			setState(58);
			match(T__0);
			setState(59);
			columnDefinition();
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(60);
				match(T__1);
				setState(61);
				columnDefinition();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			match(T__2);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(68);
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
			setState(71);
			match(DropTable);
			setState(72);
			tableName();
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(73);
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
			setState(76);
			match(AddRecord);
			setState(77);
			match(T__0);
			setState(78);
			columnAssignment();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(79);
				match(T__1);
				setState(80);
				columnAssignment();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(T__2);
			setState(87);
			match(To);
			setState(88);
			tableName();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(89);
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
		public SortByClauseContext sortByClause() {
			return getRuleContext(SortByClauseContext.class,0);
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
			setState(92);
			match(FindRecord);
			setState(93);
			columnList();
			setState(94);
			match(From);
			setState(95);
			tableName();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Join) {
				{
				setState(96);
				joinConditionList();
				}
			}

			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Having) {
				{
				setState(99);
				conditionList();
				}
			}

			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GroupBy) {
				{
				setState(102);
				groupByClause();
				}
			}

			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SortBy) {
				{
				setState(105);
				sortByClause();
				}
			}

			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(108);
				match(T__3);
				}
			}

			setState(111);
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
	public static class SortByClauseContext extends ParserRuleContext {
		public TerminalNode SortBy() { return getToken(TableQueryGrammarParser.SortBy, 0); }
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode DESC() { return getToken(TableQueryGrammarParser.DESC, 0); }
		public TerminalNode INC() { return getToken(TableQueryGrammarParser.INC, 0); }
		public SortByClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sortByClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).enterSortByClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TableQueryGrammarListener ) ((TableQueryGrammarListener)listener).exitSortByClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TableQueryGrammarVisitor ) return ((TableQueryGrammarVisitor<? extends T>)visitor).visitSortByClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SortByClauseContext sortByClause() throws RecognitionException {
		SortByClauseContext _localctx = new SortByClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sortByClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(SortBy);
			setState(114);
			columnName();
			setState(115);
			_la = _input.LA(1);
			if ( !(_la==DESC || _la==INC) ) {
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
		enterRule(_localctx, 12, RULE_updateRecordStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(UpdateRecord);
			setState(118);
			match(T__0);
			setState(119);
			columnAssignment();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(120);
				match(T__1);
				setState(121);
				columnAssignment();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			match(T__2);
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

			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(133);
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
		enterRule(_localctx, 14, RULE_deleteRecordStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(DeleteRecord);
			setState(137);
			match(From);
			setState(138);
			tableName();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Having) {
				{
				setState(139);
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
		enterRule(_localctx, 16, RULE_conditionList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(Having);
			setState(143);
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
		enterRule(_localctx, 18, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
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
		enterRule(_localctx, 20, RULE_groupByClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(GroupBy);
			setState(148);
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
		enterRule(_localctx, 22, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__0);
			setState(160);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
			case IDENTIFIER:
				{
				{
				{
				setState(151);
				columnName();
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(152);
					match(T__1);
					{
					setState(153);
					columnName();
					}
					}
					}
					setState(158);
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
			setState(162);
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
		enterRule(_localctx, 24, RULE_tableColumnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			tableName();
			setState(165);
			match(T__4);
			setState(166);
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
		enterRule(_localctx, 26, RULE_joinConditionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(168);
				joinCondition();
				}
				}
				setState(171); 
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
		enterRule(_localctx, 28, RULE_joinCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(Join);
			setState(174);
			tableName();
			setState(175);
			match(On);
			setState(176);
			tableColumnName();
			setState(177);
			match(T__5);
			setState(178);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_logicalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(181);
				match(NOT);
				setState(182);
				logicalExpression(4);
				}
				break;
			case T__12:
			case IDENTIFIER:
				{
				setState(183);
				comparisonExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(194);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(192);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(186);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(187);
						match(AND);
						setState(188);
						logicalExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(189);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(190);
						match(OR);
						setState(191);
						logicalExpression(3);
						}
						break;
					}
					} 
				}
				setState(196);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 32, RULE_comparisonExpression);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(197);
				columnName();
				}
				setState(198);
				match(T__5);
				setState(199);
				dataValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(201);
				columnName();
				}
				setState(202);
				match(T__6);
				setState(203);
				dataValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(205);
				columnName();
				}
				setState(206);
				match(T__7);
				setState(207);
				dataValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				{
				setState(209);
				columnName();
				}
				setState(210);
				match(T__8);
				setState(211);
				dataValue();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				{
				setState(213);
				columnName();
				}
				setState(214);
				match(T__9);
				setState(215);
				dataValue();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(217);
				columnName();
				}
				setState(218);
				match(T__10);
				setState(219);
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
		enterRule(_localctx, 34, RULE_columnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			columnName();
			setState(224);
			match(T__11);
			setState(225);
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
		enterRule(_localctx, 36, RULE_columnAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			columnName();
			setState(228);
			match(T__5);
			setState(229);
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
		enterRule(_localctx, 38, RULE_columnName);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(231);
					tableName();
					setState(232);
					match(T__4);
					}
					break;
				}
				setState(236);
				match(IDENTIFIER);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(237);
					match(T__4);
					setState(238);
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
				setState(241);
				match(T__12);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(242);
					match(T__4);
					setState(243);
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
		enterRule(_localctx, 40, RULE_aggregateFunctions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
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
		enterRule(_localctx, 42, RULE_dataValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7696581394432L) != 0)) ) {
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
		enterRule(_localctx, 44, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
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
		enterRule(_localctx, 46, RULE_dataType);
		try {
			setState(260);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				enterOuterAlt(_localctx, 1);
				{
				setState(254);
				match(Integer);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				match(String);
				setState(256);
				match(T__0);
				setState(257);
				match(INT_VALUE);
				setState(258);
				match(T__2);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 3);
				{
				setState(259);
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
		case 15:
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
		"\u0004\u0001-\u0107\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u00007\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001?\b\u0001\n\u0001\f\u0001B\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001F\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"K\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003R\b\u0003\n\u0003\f\u0003U\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003[\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004b\b\u0004\u0001\u0004"+
		"\u0003\u0004e\b\u0004\u0001\u0004\u0003\u0004h\b\u0004\u0001\u0004\u0003"+
		"\u0004k\b\u0004\u0001\u0004\u0003\u0004n\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006{\b\u0006\n\u0006\f\u0006"+
		"~\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u0084\b\u0006\u0001\u0006\u0003\u0006\u0087\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u008d\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u009b\b\u000b\n\u000b\f\u000b\u009e"+
		"\t\u000b\u0001\u000b\u0003\u000b\u00a1\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0004\r\u00aa\b\r\u000b\r\f\r"+
		"\u00ab\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00b9\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u00c1\b\u000f\n\u000f\f\u000f\u00c4\t\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u00de\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00eb\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00f0\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u00f5\b\u0013\u0003\u0013\u00f7\b\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0105\b\u0017\u0001"+
		"\u0017\u0000\u0001\u001e\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0003\u0001"+
		"\u0000&\'\u0001\u0000\u0014\u0018\u0001\u0000(*\u0112\u00006\u0001\u0000"+
		"\u0000\u0000\u00028\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000"+
		"\u0006L\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\nq\u0001\u0000"+
		"\u0000\u0000\fu\u0001\u0000\u0000\u0000\u000e\u0088\u0001\u0000\u0000"+
		"\u0000\u0010\u008e\u0001\u0000\u0000\u0000\u0012\u0091\u0001\u0000\u0000"+
		"\u0000\u0014\u0093\u0001\u0000\u0000\u0000\u0016\u0096\u0001\u0000\u0000"+
		"\u0000\u0018\u00a4\u0001\u0000\u0000\u0000\u001a\u00a9\u0001\u0000\u0000"+
		"\u0000\u001c\u00ad\u0001\u0000\u0000\u0000\u001e\u00b8\u0001\u0000\u0000"+
		"\u0000 \u00dd\u0001\u0000\u0000\u0000\"\u00df\u0001\u0000\u0000\u0000"+
		"$\u00e3\u0001\u0000\u0000\u0000&\u00f6\u0001\u0000\u0000\u0000(\u00f8"+
		"\u0001\u0000\u0000\u0000*\u00fa\u0001\u0000\u0000\u0000,\u00fc\u0001\u0000"+
		"\u0000\u0000.\u0104\u0001\u0000\u0000\u000007\u0003\u0002\u0001\u0000"+
		"17\u0003\u0004\u0002\u000027\u0003\u0006\u0003\u000037\u0003\b\u0004\u0000"+
		"47\u0003\f\u0006\u000057\u0003\u000e\u0007\u000060\u0001\u0000\u0000\u0000"+
		"61\u0001\u0000\u0000\u000062\u0001\u0000\u0000\u000063\u0001\u0000\u0000"+
		"\u000064\u0001\u0000\u0000\u000065\u0001\u0000\u0000\u00007\u0001\u0001"+
		"\u0000\u0000\u000089\u0005\u000e\u0000\u00009:\u0003,\u0016\u0000:;\u0005"+
		"\u0001\u0000\u0000;@\u0003\"\u0011\u0000<=\u0005\u0002\u0000\u0000=?\u0003"+
		"\"\u0011\u0000><\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001"+
		"\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000CE\u0005\u0003\u0000\u0000DF\u0005\u0004\u0000"+
		"\u0000ED\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0003\u0001"+
		"\u0000\u0000\u0000GH\u0005\u000f\u0000\u0000HJ\u0003,\u0016\u0000IK\u0005"+
		"\u0004\u0000\u0000JI\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000"+
		"K\u0005\u0001\u0000\u0000\u0000LM\u0005\u0010\u0000\u0000MN\u0005\u0001"+
		"\u0000\u0000NS\u0003$\u0012\u0000OP\u0005\u0002\u0000\u0000PR\u0003$\u0012"+
		"\u0000QO\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001"+
		"\u0000\u0000\u0000VW\u0005\u0003\u0000\u0000WX\u0005\u001f\u0000\u0000"+
		"XZ\u0003,\u0016\u0000Y[\u0005\u0004\u0000\u0000ZY\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[\u0007\u0001\u0000\u0000\u0000\\]\u0005\u0011"+
		"\u0000\u0000]^\u0003\u0016\u000b\u0000^_\u0005\u001d\u0000\u0000_a\u0003"+
		",\u0016\u0000`b\u0003\u001a\r\u0000a`\u0001\u0000\u0000\u0000ab\u0001"+
		"\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ce\u0003\u0010\b\u0000dc\u0001"+
		"\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000"+
		"fh\u0003\u0014\n\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hj\u0001\u0000\u0000\u0000ik\u0003\n\u0005\u0000ji\u0001\u0000\u0000\u0000"+
		"jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000ln\u0005\u0004\u0000"+
		"\u0000ml\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0001\u0000"+
		"\u0000\u0000op\u0005\u0000\u0000\u0001p\t\u0001\u0000\u0000\u0000qr\u0005"+
		"\u001a\u0000\u0000rs\u0003&\u0013\u0000st\u0007\u0000\u0000\u0000t\u000b"+
		"\u0001\u0000\u0000\u0000uv\u0005\u0012\u0000\u0000vw\u0005\u0001\u0000"+
		"\u0000w|\u0003$\u0012\u0000xy\u0005\u0002\u0000\u0000y{\u0003$\u0012\u0000"+
		"zx\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0005\u0003\u0000\u0000\u0080\u0081\u0005"+
		"\u001d\u0000\u0000\u0081\u0083\u0003,\u0016\u0000\u0082\u0084\u0003\u0010"+
		"\b\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0087\u0005\u0004\u0000"+
		"\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\r\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0013\u0000\u0000"+
		"\u0089\u008a\u0005\u001d\u0000\u0000\u008a\u008c\u0003,\u0016\u0000\u008b"+
		"\u008d\u0003\u0010\b\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0001\u0000\u0000\u0000\u008d\u000f\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0005\u001e\u0000\u0000\u008f\u0090\u0003\u0012\t\u0000\u0090\u0011\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0003\u001e\u000f\u0000\u0092\u0013\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005\u0019\u0000\u0000\u0094\u0095\u0003"+
		"\u0016\u000b\u0000\u0095\u0015\u0001\u0000\u0000\u0000\u0096\u00a0\u0005"+
		"\u0001\u0000\u0000\u0097\u009c\u0003&\u0013\u0000\u0098\u0099\u0005\u0002"+
		"\u0000\u0000\u0099\u009b\u0003&\u0013\u0000\u009a\u0098\u0001\u0000\u0000"+
		"\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u00a1\u0001\u0000\u0000"+
		"\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a0\u0097\u0001\u0000\u0000\u0000\u00a0\u009f\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005\u0003\u0000"+
		"\u0000\u00a3\u0017\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003,\u0016\u0000"+
		"\u00a5\u00a6\u0005\u0005\u0000\u0000\u00a6\u00a7\u0003&\u0013\u0000\u00a7"+
		"\u0019\u0001\u0000\u0000\u0000\u00a8\u00aa\u0003\u001c\u000e\u0000\u00a9"+
		"\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac"+
		"\u001b\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\u001b\u0000\u0000\u00ae"+
		"\u00af\u0003,\u0016\u0000\u00af\u00b0\u0005\u001c\u0000\u0000\u00b0\u00b1"+
		"\u0003\u0018\f\u0000\u00b1\u00b2\u0005\u0006\u0000\u0000\u00b2\u00b3\u0003"+
		"\u0018\f\u0000\u00b3\u001d\u0001\u0000\u0000\u0000\u00b4\u00b5\u0006\u000f"+
		"\uffff\uffff\u0000\u00b5\u00b6\u0005\"\u0000\u0000\u00b6\u00b9\u0003\u001e"+
		"\u000f\u0004\u00b7\u00b9\u0003 \u0010\u0000\u00b8\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00c2\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\n\u0003\u0000\u0000\u00bb\u00bc\u0005 \u0000\u0000"+
		"\u00bc\u00c1\u0003\u001e\u000f\u0004\u00bd\u00be\n\u0002\u0000\u0000\u00be"+
		"\u00bf\u0005!\u0000\u0000\u00bf\u00c1\u0003\u001e\u000f\u0003\u00c0\u00ba"+
		"\u0001\u0000\u0000\u0000\u00c0\u00bd\u0001\u0000\u0000\u0000\u00c1\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c3\u001f\u0001\u0000\u0000\u0000\u00c4\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0003&\u0013\u0000\u00c6\u00c7\u0005"+
		"\u0006\u0000\u0000\u00c7\u00c8\u0003*\u0015\u0000\u00c8\u00de\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0003&\u0013\u0000\u00ca\u00cb\u0005\u0007\u0000"+
		"\u0000\u00cb\u00cc\u0003*\u0015\u0000\u00cc\u00de\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0003&\u0013\u0000\u00ce\u00cf\u0005\b\u0000\u0000\u00cf"+
		"\u00d0\u0003*\u0015\u0000\u00d0\u00de\u0001\u0000\u0000\u0000\u00d1\u00d2"+
		"\u0003&\u0013\u0000\u00d2\u00d3\u0005\t\u0000\u0000\u00d3\u00d4\u0003"+
		"*\u0015\u0000\u00d4\u00de\u0001\u0000\u0000\u0000\u00d5\u00d6\u0003&\u0013"+
		"\u0000\u00d6\u00d7\u0005\n\u0000\u0000\u00d7\u00d8\u0003*\u0015\u0000"+
		"\u00d8\u00de\u0001\u0000\u0000\u0000\u00d9\u00da\u0003&\u0013\u0000\u00da"+
		"\u00db\u0005\u000b\u0000\u0000\u00db\u00dc\u0003*\u0015\u0000\u00dc\u00de"+
		"\u0001\u0000\u0000\u0000\u00dd\u00c5\u0001\u0000\u0000\u0000\u00dd\u00c9"+
		"\u0001\u0000\u0000\u0000\u00dd\u00cd\u0001\u0000\u0000\u0000\u00dd\u00d1"+
		"\u0001\u0000\u0000\u0000\u00dd\u00d5\u0001\u0000\u0000\u0000\u00dd\u00d9"+
		"\u0001\u0000\u0000\u0000\u00de!\u0001\u0000\u0000\u0000\u00df\u00e0\u0003"+
		"&\u0013\u0000\u00e0\u00e1\u0005\f\u0000\u0000\u00e1\u00e2\u0003.\u0017"+
		"\u0000\u00e2#\u0001\u0000\u0000\u0000\u00e3\u00e4\u0003&\u0013\u0000\u00e4"+
		"\u00e5\u0005\u0006\u0000\u0000\u00e5\u00e6\u0003*\u0015\u0000\u00e6%\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0003,\u0016\u0000\u00e8\u00e9\u0005\u0005"+
		"\u0000\u0000\u00e9\u00eb\u0001\u0000\u0000\u0000\u00ea\u00e7\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ef\u0005+\u0000\u0000\u00ed\u00ee\u0005\u0005\u0000"+
		"\u0000\u00ee\u00f0\u0003(\u0014\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f7\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f4\u0005\r\u0000\u0000\u00f2\u00f3\u0005\u0005\u0000\u0000\u00f3"+
		"\u00f5\u0003(\u0014\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f7\u0001\u0000\u0000\u0000\u00f6\u00ea"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f1\u0001\u0000\u0000\u0000\u00f7\'\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f9\u0007\u0001\u0000\u0000\u00f9)\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fb\u0007\u0002\u0000\u0000\u00fb+\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\u0005+\u0000\u0000\u00fd-\u0001\u0000\u0000\u0000\u00fe"+
		"\u0105\u0005#\u0000\u0000\u00ff\u0100\u0005%\u0000\u0000\u0100\u0101\u0005"+
		"\u0001\u0000\u0000\u0101\u0102\u0005(\u0000\u0000\u0102\u0105\u0005\u0003"+
		"\u0000\u0000\u0103\u0105\u0005$\u0000\u0000\u0104\u00fe\u0001\u0000\u0000"+
		"\u0000\u0104\u00ff\u0001\u0000\u0000\u0000\u0104\u0103\u0001\u0000\u0000"+
		"\u0000\u0105/\u0001\u0000\u0000\u0000\u001b6@EJSZadgjm|\u0083\u0086\u008c"+
		"\u009c\u00a0\u00ab\u00b8\u00c0\u00c2\u00dd\u00ea\u00ef\u00f4\u00f6\u0104";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}