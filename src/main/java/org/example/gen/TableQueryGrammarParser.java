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
		FindRecord=16, From=17, Having=18, To=19, AND=20, OR=21, NOT=22, Integer=23, 
		Float=24, String=25, INT_VALUE=26, FlOAT_VALUE=27, STRING_VALUE=28, IDENTIFIER=29, 
		DIGIT=30, WS=31;
	public static final int
		RULE_query = 0, RULE_createTableStatement = 1, RULE_dropTableStatement = 2, 
		RULE_addRecordStatement = 3, RULE_findRecordStatement = 4, RULE_conditionList = 5, 
		RULE_expression = 6, RULE_columnList = 7, RULE_logicalExpression = 8, 
		RULE_comparisonExpression = 9, RULE_columnDefinition = 10, RULE_columnAssignment = 11, 
		RULE_columnName = 12, RULE_dataValue = 13, RULE_tableName = 14, RULE_dataType = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"query", "createTableStatement", "dropTableStatement", "addRecordStatement", 
			"findRecordStatement", "conditionList", "expression", "columnList", "logicalExpression", 
			"comparisonExpression", "columnDefinition", "columnAssignment", "columnName", 
			"dataValue", "tableName", "dataType"
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
			null, "CreateTable", "DropTable", "AddRecord", "FindRecord", "From", 
			"Having", "To", "AND", "OR", "NOT", "Integer", "Float", "String", "INT_VALUE", 
			"FlOAT_VALUE", "STRING_VALUE", "IDENTIFIER", "DIGIT", "WS"
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
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CreateTable:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				createTableStatement();
				}
				break;
			case DropTable:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				dropTableStatement();
				}
				break;
			case AddRecord:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				addRecordStatement();
				}
				break;
			case FindRecord:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				findRecordStatement();
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
			setState(38);
			match(CreateTable);
			setState(39);
			tableName();
			setState(40);
			match(T__0);
			setState(41);
			columnDefinition();
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(42);
				match(T__1);
				setState(43);
				columnDefinition();
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
			match(T__2);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(50);
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
			setState(53);
			match(DropTable);
			setState(54);
			tableName();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(55);
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
			setState(58);
			match(AddRecord);
			setState(59);
			match(T__0);
			setState(60);
			columnAssignment();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(61);
				match(T__1);
				setState(62);
				columnAssignment();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			match(T__2);
			setState(69);
			match(To);
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
			setState(74);
			match(FindRecord);
			setState(75);
			columnList();
			setState(76);
			match(From);
			setState(77);
			tableName();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Having) {
				{
				setState(78);
				conditionList();
				}
			}

			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(81);
				match(T__3);
				}
			}

			setState(84);
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
		enterRule(_localctx, 10, RULE_conditionList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(Having);
			setState(87);
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
		enterRule(_localctx, 12, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
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
		enterRule(_localctx, 14, RULE_columnList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__0);
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				{
				setState(92);
				columnName();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(93);
					match(T__1);
					setState(94);
					columnName();
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				}
				break;
			case T__4:
				{
				setState(100);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(103);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_logicalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(106);
				match(NOT);
				setState(107);
				logicalExpression(4);
				}
				break;
			case IDENTIFIER:
				{
				setState(108);
				comparisonExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(117);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(111);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(112);
						match(AND);
						setState(113);
						logicalExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new LogicalExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logicalExpression);
						setState(114);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(115);
						match(OR);
						setState(116);
						logicalExpression(3);
						}
						break;
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		enterRule(_localctx, 18, RULE_comparisonExpression);
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				columnName();
				setState(123);
				match(T__5);
				setState(124);
				dataValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				columnName();
				setState(127);
				match(T__6);
				setState(128);
				dataValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				columnName();
				setState(131);
				match(T__7);
				setState(132);
				dataValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				columnName();
				setState(135);
				match(T__8);
				setState(136);
				dataValue();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(138);
				columnName();
				setState(139);
				match(T__9);
				setState(140);
				dataValue();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(142);
				columnName();
				setState(143);
				match(T__10);
				setState(144);
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
		enterRule(_localctx, 20, RULE_columnDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			columnName();
			setState(149);
			match(T__11);
			setState(150);
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
		enterRule(_localctx, 22, RULE_columnAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			columnName();
			setState(153);
			match(T__5);
			setState(154);
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
		enterRule(_localctx, 24, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
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
		enterRule(_localctx, 26, RULE_dataValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 469762048L) != 0)) ) {
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
		enterRule(_localctx, 28, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
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
		enterRule(_localctx, 30, RULE_dataType);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(Integer);
				}
				break;
			case String:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				match(String);
				setState(164);
				match(T__0);
				setState(165);
				match(INT_VALUE);
				setState(166);
				match(T__2);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
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
		case 8:
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
		"\u0004\u0001\u001f\u00ab\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000%\b"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001-\b\u0001\n\u0001\f\u00010\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u00014\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u00029\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003@\b\u0003\n\u0003\f\u0003C\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003I\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004P\b\u0004\u0001"+
		"\u0004\u0003\u0004S\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007`\b\u0007\n\u0007\f\u0007c\t\u0007\u0001"+
		"\u0007\u0003\u0007f\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\bn\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\bv\b\b\n\b\f\by\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u0093\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00a9\b\u000f\u0001\u000f\u0000\u0001\u0010\u0010"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e\u0000\u0001\u0001\u0000\u001a\u001c\u00b0\u0000$\u0001\u0000"+
		"\u0000\u0000\u0002&\u0001\u0000\u0000\u0000\u00045\u0001\u0000\u0000\u0000"+
		"\u0006:\u0001\u0000\u0000\u0000\bJ\u0001\u0000\u0000\u0000\nV\u0001\u0000"+
		"\u0000\u0000\fY\u0001\u0000\u0000\u0000\u000e[\u0001\u0000\u0000\u0000"+
		"\u0010m\u0001\u0000\u0000\u0000\u0012\u0092\u0001\u0000\u0000\u0000\u0014"+
		"\u0094\u0001\u0000\u0000\u0000\u0016\u0098\u0001\u0000\u0000\u0000\u0018"+
		"\u009c\u0001\u0000\u0000\u0000\u001a\u009e\u0001\u0000\u0000\u0000\u001c"+
		"\u00a0\u0001\u0000\u0000\u0000\u001e\u00a8\u0001\u0000\u0000\u0000 %\u0003"+
		"\u0002\u0001\u0000!%\u0003\u0004\u0002\u0000\"%\u0003\u0006\u0003\u0000"+
		"#%\u0003\b\u0004\u0000$ \u0001\u0000\u0000\u0000$!\u0001\u0000\u0000\u0000"+
		"$\"\u0001\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000%\u0001\u0001\u0000"+
		"\u0000\u0000&\'\u0005\r\u0000\u0000\'(\u0003\u001c\u000e\u0000()\u0005"+
		"\u0001\u0000\u0000).\u0003\u0014\n\u0000*+\u0005\u0002\u0000\u0000+-\u0003"+
		"\u0014\n\u0000,*\u0001\u0000\u0000\u0000-0\u0001\u0000\u0000\u0000.,\u0001"+
		"\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000\u0000\u0000"+
		"0.\u0001\u0000\u0000\u000013\u0005\u0003\u0000\u000024\u0005\u0004\u0000"+
		"\u000032\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u00004\u0003\u0001"+
		"\u0000\u0000\u000056\u0005\u000e\u0000\u000068\u0003\u001c\u000e\u0000"+
		"79\u0005\u0004\u0000\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009\u0005\u0001\u0000\u0000\u0000:;\u0005\u000f\u0000\u0000;<\u0005"+
		"\u0001\u0000\u0000<A\u0003\u0016\u000b\u0000=>\u0005\u0002\u0000\u0000"+
		">@\u0003\u0016\u000b\u0000?=\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0001\u0000"+
		"\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0005\u0003\u0000\u0000EF\u0005"+
		"\u0013\u0000\u0000FH\u0003\u001c\u000e\u0000GI\u0005\u0004\u0000\u0000"+
		"HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000I\u0007\u0001\u0000"+
		"\u0000\u0000JK\u0005\u0010\u0000\u0000KL\u0003\u000e\u0007\u0000LM\u0005"+
		"\u0011\u0000\u0000MO\u0003\u001c\u000e\u0000NP\u0003\n\u0005\u0000ON\u0001"+
		"\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000"+
		"QS\u0005\u0004\u0000\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TU\u0005\u0000\u0000\u0001U\t\u0001\u0000"+
		"\u0000\u0000VW\u0005\u0012\u0000\u0000WX\u0003\f\u0006\u0000X\u000b\u0001"+
		"\u0000\u0000\u0000YZ\u0003\u0010\b\u0000Z\r\u0001\u0000\u0000\u0000[e"+
		"\u0005\u0001\u0000\u0000\\a\u0003\u0018\f\u0000]^\u0005\u0002\u0000\u0000"+
		"^`\u0003\u0018\f\u0000_]\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000"+
		"a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000bf\u0001\u0000\u0000"+
		"\u0000ca\u0001\u0000\u0000\u0000df\u0005\u0005\u0000\u0000e\\\u0001\u0000"+
		"\u0000\u0000ed\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gh\u0005"+
		"\u0003\u0000\u0000h\u000f\u0001\u0000\u0000\u0000ij\u0006\b\uffff\uffff"+
		"\u0000jk\u0005\u0016\u0000\u0000kn\u0003\u0010\b\u0004ln\u0003\u0012\t"+
		"\u0000mi\u0001\u0000\u0000\u0000ml\u0001\u0000\u0000\u0000nw\u0001\u0000"+
		"\u0000\u0000op\n\u0003\u0000\u0000pq\u0005\u0014\u0000\u0000qv\u0003\u0010"+
		"\b\u0004rs\n\u0002\u0000\u0000st\u0005\u0015\u0000\u0000tv\u0003\u0010"+
		"\b\u0003uo\u0001\u0000\u0000\u0000ur\u0001\u0000\u0000\u0000vy\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\u0011"+
		"\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0003\u0018\f\u0000"+
		"{|\u0005\u0006\u0000\u0000|}\u0003\u001a\r\u0000}\u0093\u0001\u0000\u0000"+
		"\u0000~\u007f\u0003\u0018\f\u0000\u007f\u0080\u0005\u0007\u0000\u0000"+
		"\u0080\u0081\u0003\u001a\r\u0000\u0081\u0093\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0003\u0018\f\u0000\u0083\u0084\u0005\b\u0000\u0000\u0084\u0085"+
		"\u0003\u001a\r\u0000\u0085\u0093\u0001\u0000\u0000\u0000\u0086\u0087\u0003"+
		"\u0018\f\u0000\u0087\u0088\u0005\t\u0000\u0000\u0088\u0089\u0003\u001a"+
		"\r\u0000\u0089\u0093\u0001\u0000\u0000\u0000\u008a\u008b\u0003\u0018\f"+
		"\u0000\u008b\u008c\u0005\n\u0000\u0000\u008c\u008d\u0003\u001a\r\u0000"+
		"\u008d\u0093\u0001\u0000\u0000\u0000\u008e\u008f\u0003\u0018\f\u0000\u008f"+
		"\u0090\u0005\u000b\u0000\u0000\u0090\u0091\u0003\u001a\r\u0000\u0091\u0093"+
		"\u0001\u0000\u0000\u0000\u0092z\u0001\u0000\u0000\u0000\u0092~\u0001\u0000"+
		"\u0000\u0000\u0092\u0082\u0001\u0000\u0000\u0000\u0092\u0086\u0001\u0000"+
		"\u0000\u0000\u0092\u008a\u0001\u0000\u0000\u0000\u0092\u008e\u0001\u0000"+
		"\u0000\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094\u0095\u0003\u0018"+
		"\f\u0000\u0095\u0096\u0005\f\u0000\u0000\u0096\u0097\u0003\u001e\u000f"+
		"\u0000\u0097\u0015\u0001\u0000\u0000\u0000\u0098\u0099\u0003\u0018\f\u0000"+
		"\u0099\u009a\u0005\u0006\u0000\u0000\u009a\u009b\u0003\u001a\r\u0000\u009b"+
		"\u0017\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u001d\u0000\u0000\u009d"+
		"\u0019\u0001\u0000\u0000\u0000\u009e\u009f\u0007\u0000\u0000\u0000\u009f"+
		"\u001b\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u001d\u0000\u0000\u00a1"+
		"\u001d\u0001\u0000\u0000\u0000\u00a2\u00a9\u0005\u0017\u0000\u0000\u00a3"+
		"\u00a4\u0005\u0019\u0000\u0000\u00a4\u00a5\u0005\u0001\u0000\u0000\u00a5"+
		"\u00a6\u0005\u001a\u0000\u0000\u00a6\u00a9\u0005\u0003\u0000\u0000\u00a7"+
		"\u00a9\u0005\u0018\u0000\u0000\u00a8\u00a2\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9"+
		"\u001f\u0001\u0000\u0000\u0000\u000f$.38AHORaemuw\u0092\u00a8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}