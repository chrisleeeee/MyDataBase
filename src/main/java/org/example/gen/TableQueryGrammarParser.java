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
		T__9=10, T__10=11, T__11=12, CreateTable=13, DropTable=14, AddRecord=15, 
		FindRecord=16, UpdateRecord=17, DeleteRecord=18, From=19, Having=20, To=21, 
		AND=22, OR=23, NOT=24, Integer=25, Float=26, String=27, INT_VALUE=28, 
		FlOAT_VALUE=29, STRING_VALUE=30, IDENTIFIER=31, DIGIT=32, WS=33;
	public static final int
		RULE_query = 0, RULE_createTableStatement = 1, RULE_dropTableStatement = 2, 
		RULE_addRecordStatement = 3, RULE_findRecordStatement = 4, RULE_updateRecordStatement = 5, 
		RULE_deleteRecordStatement = 6, RULE_conditionList = 7, RULE_expression = 8, 
		RULE_columnList = 9, RULE_logicalExpression = 10, RULE_comparisonExpression = 11, 
		RULE_columnDefinition = 12, RULE_columnAssignment = 13, RULE_columnName = 14, 
		RULE_dataValue = 15, RULE_tableName = 16, RULE_dataType = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "createTableStatement", "dropTableStatement", "addRecordStatement", 
			"findRecordStatement", "updateRecordStatement", "deleteRecordStatement", 
			"conditionList", "expression", "columnList", "logicalExpression", "comparisonExpression", 
			"columnDefinition", "columnAssignment", "columnName", "dataValue", "tableName", 
			"dataType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "';'", "'*'", "'='", "'<'", "'>'", "'>='", 
			"'<='", "'!='", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "CreateTable", "DropTable", "AddRecord", "FindRecord", "UpdateRecord", 
			"DeleteRecord", "From", "Having", "To", "AND", "OR", "NOT", "Integer", 
			"Float", "String", "INT_VALUE", "FlOAT_VALUE", "STRING_VALUE", "IDENTIFIER", 
			"DIGIT", "WS"
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
			setState(42);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CreateTable:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				createTableStatement();
				}
				break;
			case DropTable:
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				dropTableStatement();
				}
				break;
			case AddRecord:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				addRecordStatement();
				}
				break;
			case FindRecord:
				enterOuterAlt(_localctx, 4);
				{
				setState(39);
				findRecordStatement();
				}
				break;
			case UpdateRecord:
				enterOuterAlt(_localctx, 5);
				{
				setState(40);
				updateRecordStatement();
				}
				break;
			case DeleteRecord:
				enterOuterAlt(_localctx, 6);
				{
				setState(41);
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
			setState(44);
			match(CreateTable);
			setState(45);
			tableName();
			setState(46);
			match(T__0);
			setState(47);
			columnDefinition();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(48);
				match(T__1);
				setState(49);
				columnDefinition();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(T__2);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(56);
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
			setState(59);
			match(DropTable);
			setState(60);
			tableName();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(61);
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
			setState(64);
			match(AddRecord);
			setState(65);
			match(T__0);
			setState(66);
			columnAssignment();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(67);
				match(T__1);
				setState(68);
				columnAssignment();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__2);
			setState(75);
			match(To);
			setState(76);
			tableName();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(77);
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
		public ConditionListContext conditionList() {
			return getRuleContext(ConditionListContext.class,0);
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
			setState(80);
			match(FindRecord);
			setState(81);
			columnList();
			setState(82);
			match(From);
			setState(83);
			tableName();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Having) {
				{
				setState(84);
				conditionList();
				}
			}

			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(87);
				match(T__3);
				}
			}

			setState(90);
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
			setState(92);
			match(UpdateRecord);
			setState(93);
			match(T__0);
			setState(94);
			columnAssignment();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(95);
				match(T__1);
				setState(96);
				columnAssignment();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(T__2);
			setState(103);
			match(From);
			setState(104);
			tableName();
			setState(105);
			conditionList();
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
			setState(107);
			match(DeleteRecord);
			setState(108);
			match(From);
			setState(109);
			tableName();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Having) {
				{
				setState(110);
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
			setState(113);
			match(Having);
			setState(114);
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
			setState(116);
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
		enterRule(_localctx, 18, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(T__0);
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				{
				setState(119);
				columnName();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(120);
					match(T__1);
					setState(121);
					columnName();
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case T__4:
				{
				setState(127);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(130);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_logicalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(133);
				match(NOT);
				setState(134);
				logicalExpression(4);
				}
				break;
			case IDENTIFIER:
				{
				setState(135);
				comparisonExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(144);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(138);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(139);
						match(AND);
						setState(140);
						logicalExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(141);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(142);
						match(OR);
						setState(143);
						logicalExpression(3);
						}
						break;
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public DataValueContext dataValue() {
			return getRuleContext(DataValueContext.class,0);
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
		enterRule(_localctx, 22, RULE_comparisonExpression);
		try {
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				columnName();
				setState(150);
				match(T__5);
				setState(151);
				dataValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				columnName();
				setState(154);
				match(T__6);
				setState(155);
				dataValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				columnName();
				setState(158);
				match(T__7);
				setState(159);
				dataValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(161);
				columnName();
				setState(162);
				match(T__8);
				setState(163);
				dataValue();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				columnName();
				setState(166);
				match(T__9);
				setState(167);
				dataValue();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(169);
				columnName();
				setState(170);
				match(T__10);
				setState(171);
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
		enterRule(_localctx, 24, RULE_columnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			columnName();
			setState(176);
			match(T__11);
			setState(177);
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
		enterRule(_localctx, 26, RULE_columnAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			columnName();
			setState(180);
			match(T__5);
			setState(181);
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
		enterRule(_localctx, 28, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
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
		enterRule(_localctx, 30, RULE_dataValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) ) {
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
		enterRule(_localctx, 32, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
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
		enterRule(_localctx, 34, RULE_dataType);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(Integer);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(String);
				setState(191);
				match(T__0);
				setState(192);
				match(INT_VALUE);
				setState(193);
				match(T__2);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
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
		case 10:
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
		"\u0004\u0001!\u00c6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000+\b\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001:\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003F\b\u0003\n\u0003\f\u0003I\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004V\b\u0004\u0001\u0004"+
		"\u0003\u0004Y\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005b\b\u0005\n\u0005\f\u0005"+
		"e\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006p\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t{\b\t\n\t\f\t~\t\t\u0001\t\u0003\t\u0081\b\t\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0089\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0091\b\n\n\n\f\n\u0094\t\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00ae\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u00c4\b\u0011\u0001\u0011\u0000\u0001\u0014"+
		"\u0012\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"\u0000\u0001\u0001\u0000\u001c\u001e\u00cd\u0000"+
		"*\u0001\u0000\u0000\u0000\u0002,\u0001\u0000\u0000\u0000\u0004;\u0001"+
		"\u0000\u0000\u0000\u0006@\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000"+
		"\u0000\n\\\u0001\u0000\u0000\u0000\fk\u0001\u0000\u0000\u0000\u000eq\u0001"+
		"\u0000\u0000\u0000\u0010t\u0001\u0000\u0000\u0000\u0012v\u0001\u0000\u0000"+
		"\u0000\u0014\u0088\u0001\u0000\u0000\u0000\u0016\u00ad\u0001\u0000\u0000"+
		"\u0000\u0018\u00af\u0001\u0000\u0000\u0000\u001a\u00b3\u0001\u0000\u0000"+
		"\u0000\u001c\u00b7\u0001\u0000\u0000\u0000\u001e\u00b9\u0001\u0000\u0000"+
		"\u0000 \u00bb\u0001\u0000\u0000\u0000\"\u00c3\u0001\u0000\u0000\u0000"+
		"$+\u0003\u0002\u0001\u0000%+\u0003\u0004\u0002\u0000&+\u0003\u0006\u0003"+
		"\u0000\'+\u0003\b\u0004\u0000(+\u0003\n\u0005\u0000)+\u0003\f\u0006\u0000"+
		"*$\u0001\u0000\u0000\u0000*%\u0001\u0000\u0000\u0000*&\u0001\u0000\u0000"+
		"\u0000*\'\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*)\u0001\u0000"+
		"\u0000\u0000+\u0001\u0001\u0000\u0000\u0000,-\u0005\r\u0000\u0000-.\u0003"+
		" \u0010\u0000./\u0005\u0001\u0000\u0000/4\u0003\u0018\f\u000001\u0005"+
		"\u0002\u0000\u000013\u0003\u0018\f\u000020\u0001\u0000\u0000\u000036\u0001"+
		"\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"57\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000079\u0005\u0003\u0000"+
		"\u00008:\u0005\u0004\u0000\u000098\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:\u0003\u0001\u0000\u0000\u0000;<\u0005\u000e\u0000\u0000"+
		"<>\u0003 \u0010\u0000=?\u0005\u0004\u0000\u0000>=\u0001\u0000\u0000\u0000"+
		">?\u0001\u0000\u0000\u0000?\u0005\u0001\u0000\u0000\u0000@A\u0005\u000f"+
		"\u0000\u0000AB\u0005\u0001\u0000\u0000BG\u0003\u001a\r\u0000CD\u0005\u0002"+
		"\u0000\u0000DF\u0003\u001a\r\u0000EC\u0001\u0000\u0000\u0000FI\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001"+
		"\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0005\u0003\u0000\u0000"+
		"KL\u0005\u0015\u0000\u0000LN\u0003 \u0010\u0000MO\u0005\u0004\u0000\u0000"+
		"NM\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0007\u0001\u0000"+
		"\u0000\u0000PQ\u0005\u0010\u0000\u0000QR\u0003\u0012\t\u0000RS\u0005\u0013"+
		"\u0000\u0000SU\u0003 \u0010\u0000TV\u0003\u000e\u0007\u0000UT\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000VX\u0001\u0000\u0000\u0000WY\u0005"+
		"\u0004\u0000\u0000XW\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z[\u0005\u0000\u0000\u0001[\t\u0001\u0000\u0000"+
		"\u0000\\]\u0005\u0011\u0000\u0000]^\u0005\u0001\u0000\u0000^c\u0003\u001a"+
		"\r\u0000_`\u0005\u0002\u0000\u0000`b\u0003\u001a\r\u0000a_\u0001\u0000"+
		"\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"fg\u0005\u0003\u0000\u0000gh\u0005\u0013\u0000\u0000hi\u0003 \u0010\u0000"+
		"ij\u0003\u000e\u0007\u0000j\u000b\u0001\u0000\u0000\u0000kl\u0005\u0012"+
		"\u0000\u0000lm\u0005\u0013\u0000\u0000mo\u0003 \u0010\u0000np\u0003\u000e"+
		"\u0007\u0000on\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000p\r\u0001"+
		"\u0000\u0000\u0000qr\u0005\u0014\u0000\u0000rs\u0003\u0010\b\u0000s\u000f"+
		"\u0001\u0000\u0000\u0000tu\u0003\u0014\n\u0000u\u0011\u0001\u0000\u0000"+
		"\u0000v\u0080\u0005\u0001\u0000\u0000w|\u0003\u001c\u000e\u0000xy\u0005"+
		"\u0002\u0000\u0000y{\u0003\u001c\u000e\u0000zx\u0001\u0000\u0000\u0000"+
		"{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000"+
		"\u0000}\u0081\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f"+
		"\u0081\u0005\u0005\u0000\u0000\u0080w\u0001\u0000\u0000\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005\u0003\u0000\u0000\u0083\u0013\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0006\n\uffff\uffff\u0000\u0085\u0086\u0005\u0018\u0000\u0000\u0086\u0089"+
		"\u0003\u0014\n\u0004\u0087\u0089\u0003\u0016\u000b\u0000\u0088\u0084\u0001"+
		"\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u0092\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\n\u0003\u0000\u0000\u008b\u008c\u0005\u0016"+
		"\u0000\u0000\u008c\u0091\u0003\u0014\n\u0004\u008d\u008e\n\u0002\u0000"+
		"\u0000\u008e\u008f\u0005\u0017\u0000\u0000\u008f\u0091\u0003\u0014\n\u0003"+
		"\u0090\u008a\u0001\u0000\u0000\u0000\u0090\u008d\u0001\u0000\u0000\u0000"+
		"\u0091\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0015\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0003\u001c\u000e\u0000"+
		"\u0096\u0097\u0005\u0006\u0000\u0000\u0097\u0098\u0003\u001e\u000f\u0000"+
		"\u0098\u00ae\u0001\u0000\u0000\u0000\u0099\u009a\u0003\u001c\u000e\u0000"+
		"\u009a\u009b\u0005\u0007\u0000\u0000\u009b\u009c\u0003\u001e\u000f\u0000"+
		"\u009c\u00ae\u0001\u0000\u0000\u0000\u009d\u009e\u0003\u001c\u000e\u0000"+
		"\u009e\u009f\u0005\b\u0000\u0000\u009f\u00a0\u0003\u001e\u000f\u0000\u00a0"+
		"\u00ae\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003\u001c\u000e\u0000\u00a2"+
		"\u00a3\u0005\t\u0000\u0000\u00a3\u00a4\u0003\u001e\u000f\u0000\u00a4\u00ae"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003\u001c\u000e\u0000\u00a6\u00a7"+
		"\u0005\n\u0000\u0000\u00a7\u00a8\u0003\u001e\u000f\u0000\u00a8\u00ae\u0001"+
		"\u0000\u0000\u0000\u00a9\u00aa\u0003\u001c\u000e\u0000\u00aa\u00ab\u0005"+
		"\u000b\u0000\u0000\u00ab\u00ac\u0003\u001e\u000f\u0000\u00ac\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ad\u0095\u0001\u0000\u0000\u0000\u00ad\u0099\u0001"+
		"\u0000\u0000\u0000\u00ad\u009d\u0001\u0000\u0000\u0000\u00ad\u00a1\u0001"+
		"\u0000\u0000\u0000\u00ad\u00a5\u0001\u0000\u0000\u0000\u00ad\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ae\u0017\u0001\u0000\u0000\u0000\u00af\u00b0\u0003"+
		"\u001c\u000e\u0000\u00b0\u00b1\u0005\f\u0000\u0000\u00b1\u00b2\u0003\""+
		"\u0011\u0000\u00b2\u0019\u0001\u0000\u0000\u0000\u00b3\u00b4\u0003\u001c"+
		"\u000e\u0000\u00b4\u00b5\u0005\u0006\u0000\u0000\u00b5\u00b6\u0003\u001e"+
		"\u000f\u0000\u00b6\u001b\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\u001f"+
		"\u0000\u0000\u00b8\u001d\u0001\u0000\u0000\u0000\u00b9\u00ba\u0007\u0000"+
		"\u0000\u0000\u00ba\u001f\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u001f"+
		"\u0000\u0000\u00bc!\u0001\u0000\u0000\u0000\u00bd\u00c4\u0005\u0019\u0000"+
		"\u0000\u00be\u00bf\u0005\u001b\u0000\u0000\u00bf\u00c0\u0005\u0001\u0000"+
		"\u0000\u00c0\u00c1\u0005\u001c\u0000\u0000\u00c1\u00c4\u0005\u0003\u0000"+
		"\u0000\u00c2\u00c4\u0005\u001a\u0000\u0000\u00c3\u00bd\u0001\u0000\u0000"+
		"\u0000\u00c3\u00be\u0001\u0000\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c4#\u0001\u0000\u0000\u0000\u0011*49>GNUXco|\u0080\u0088\u0090"+
		"\u0092\u00ad\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}