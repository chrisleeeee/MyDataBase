// Generated from E:/Libraries/code/course/DSCI551/finalProject/MyDB/src/main/java/org/example/antlr/TableQueryGrammar.g4 by ANTLR 4.13.1
package org.example.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TableQueryGrammarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "CreateTable", "DropTable", "AddRecord", "FindRecord", 
			"From", "Having", "To", "AND", "OR", "NOT", "Integer", "Float", "String", 
			"INT_VALUE", "FlOAT_VALUE", "STRING_VALUE", "IDENTIFIER", "DIGIT", "WS"
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


	public TableQueryGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TableQueryGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001f\u00ea\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0003\u0019\u00b4\b\u0019\u0001\u0019\u0004\u0019\u00b7\b\u0019\u000b"+
		"\u0019\f\u0019\u00b8\u0001\u001a\u0003\u001a\u00bc\b\u001a\u0001\u001a"+
		"\u0004\u001a\u00bf\b\u001a\u000b\u001a\f\u001a\u00c0\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u00c5\b\u001a\n\u001a\f\u001a\u00c8\t\u001a\u0001\u001a"+
		"\u0001\u001a\u0004\u001a\u00cc\b\u001a\u000b\u001a\f\u001a\u00cd\u0003"+
		"\u001a\u00d0\b\u001a\u0001\u001b\u0001\u001b\u0005\u001b\u00d4\b\u001b"+
		"\n\u001b\f\u001b\u00d7\t\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0005\u001c\u00dd\b\u001c\n\u001c\f\u001c\u00e0\t\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0004\u001e\u00e5\b\u001e\u000b\u001e\f\u001e"+
		"\u00e6\u0001\u001e\u0001\u001e\u0000\u0000\u001f\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011"+
		"#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b"+
		"7\u001c9\u001d;\u001e=\u001f\u0001\u0000\u0017\u0002\u0000CCcc\u0002\u0000"+
		"RRrr\u0002\u0000EEee\u0002\u0000AAaa\u0002\u0000TTtt\u0002\u0000BBbb\u0002"+
		"\u0000LLll\u0002\u0000DDdd\u0002\u0000OOoo\u0002\u0000PPpp\u0002\u0000"+
		"FFff\u0002\u0000IIii\u0002\u0000NNnn\u0002\u0000MMmm\u0002\u0000HHhh\u0002"+
		"\u0000VVvv\u0002\u0000GGgg\u0002\u0000SSss\u0002\u0000++--\u0001\u0000"+
		"\'\'\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u00f3"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="+
		"\u0001\u0000\u0000\u0000\u0001?\u0001\u0000\u0000\u0000\u0003A\u0001\u0000"+
		"\u0000\u0000\u0005C\u0001\u0000\u0000\u0000\u0007E\u0001\u0000\u0000\u0000"+
		"\tG\u0001\u0000\u0000\u0000\u000bI\u0001\u0000\u0000\u0000\rK\u0001\u0000"+
		"\u0000\u0000\u000fM\u0001\u0000\u0000\u0000\u0011O\u0001\u0000\u0000\u0000"+
		"\u0013R\u0001\u0000\u0000\u0000\u0015U\u0001\u0000\u0000\u0000\u0017X"+
		"\u0001\u0000\u0000\u0000\u0019Z\u0001\u0000\u0000\u0000\u001bf\u0001\u0000"+
		"\u0000\u0000\u001dp\u0001\u0000\u0000\u0000\u001fz\u0001\u0000\u0000\u0000"+
		"!\u0085\u0001\u0000\u0000\u0000#\u008a\u0001\u0000\u0000\u0000%\u0091"+
		"\u0001\u0000\u0000\u0000\'\u0096\u0001\u0000\u0000\u0000)\u009a\u0001"+
		"\u0000\u0000\u0000+\u009d\u0001\u0000\u0000\u0000-\u00a1\u0001\u0000\u0000"+
		"\u0000/\u00a5\u0001\u0000\u0000\u00001\u00ab\u0001\u0000\u0000\u00003"+
		"\u00b3\u0001\u0000\u0000\u00005\u00bb\u0001\u0000\u0000\u00007\u00d1\u0001"+
		"\u0000\u0000\u00009\u00da\u0001\u0000\u0000\u0000;\u00e1\u0001\u0000\u0000"+
		"\u0000=\u00e4\u0001\u0000\u0000\u0000?@\u0005(\u0000\u0000@\u0002\u0001"+
		"\u0000\u0000\u0000AB\u0005,\u0000\u0000B\u0004\u0001\u0000\u0000\u0000"+
		"CD\u0005)\u0000\u0000D\u0006\u0001\u0000\u0000\u0000EF\u0005;\u0000\u0000"+
		"F\b\u0001\u0000\u0000\u0000GH\u0005*\u0000\u0000H\n\u0001\u0000\u0000"+
		"\u0000IJ\u0005=\u0000\u0000J\f\u0001\u0000\u0000\u0000KL\u0005<\u0000"+
		"\u0000L\u000e\u0001\u0000\u0000\u0000MN\u0005>\u0000\u0000N\u0010\u0001"+
		"\u0000\u0000\u0000OP\u0005>\u0000\u0000PQ\u0005=\u0000\u0000Q\u0012\u0001"+
		"\u0000\u0000\u0000RS\u0005<\u0000\u0000ST\u0005=\u0000\u0000T\u0014\u0001"+
		"\u0000\u0000\u0000UV\u0005!\u0000\u0000VW\u0005=\u0000\u0000W\u0016\u0001"+
		"\u0000\u0000\u0000XY\u0005:\u0000\u0000Y\u0018\u0001\u0000\u0000\u0000"+
		"Z[\u0007\u0000\u0000\u0000[\\\u0007\u0001\u0000\u0000\\]\u0007\u0002\u0000"+
		"\u0000]^\u0007\u0003\u0000\u0000^_\u0007\u0004\u0000\u0000_`\u0007\u0002"+
		"\u0000\u0000`a\u0007\u0004\u0000\u0000ab\u0007\u0003\u0000\u0000bc\u0007"+
		"\u0005\u0000\u0000cd\u0007\u0006\u0000\u0000de\u0007\u0002\u0000\u0000"+
		"e\u001a\u0001\u0000\u0000\u0000fg\u0007\u0007\u0000\u0000gh\u0007\u0001"+
		"\u0000\u0000hi\u0007\b\u0000\u0000ij\u0007\t\u0000\u0000jk\u0007\u0004"+
		"\u0000\u0000kl\u0007\u0003\u0000\u0000lm\u0007\u0005\u0000\u0000mn\u0007"+
		"\u0006\u0000\u0000no\u0007\u0002\u0000\u0000o\u001c\u0001\u0000\u0000"+
		"\u0000pq\u0007\u0003\u0000\u0000qr\u0007\u0007\u0000\u0000rs\u0007\u0007"+
		"\u0000\u0000st\u0007\u0001\u0000\u0000tu\u0007\u0002\u0000\u0000uv\u0007"+
		"\u0000\u0000\u0000vw\u0007\b\u0000\u0000wx\u0007\u0001\u0000\u0000xy\u0007"+
		"\u0007\u0000\u0000y\u001e\u0001\u0000\u0000\u0000z{\u0007\n\u0000\u0000"+
		"{|\u0007\u000b\u0000\u0000|}\u0007\f\u0000\u0000}~\u0007\u0007\u0000\u0000"+
		"~\u007f\u0007\u0001\u0000\u0000\u007f\u0080\u0007\u0002\u0000\u0000\u0080"+
		"\u0081\u0007\u0000\u0000\u0000\u0081\u0082\u0007\b\u0000\u0000\u0082\u0083"+
		"\u0007\u0001\u0000\u0000\u0083\u0084\u0007\u0007\u0000\u0000\u0084 \u0001"+
		"\u0000\u0000\u0000\u0085\u0086\u0007\n\u0000\u0000\u0086\u0087\u0007\u0001"+
		"\u0000\u0000\u0087\u0088\u0007\b\u0000\u0000\u0088\u0089\u0007\r\u0000"+
		"\u0000\u0089\"\u0001\u0000\u0000\u0000\u008a\u008b\u0007\u000e\u0000\u0000"+
		"\u008b\u008c\u0007\u0003\u0000\u0000\u008c\u008d\u0007\u000f\u0000\u0000"+
		"\u008d\u008e\u0007\u000b\u0000\u0000\u008e\u008f\u0007\f\u0000\u0000\u008f"+
		"\u0090\u0007\u0010\u0000\u0000\u0090$\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005 \u0000\u0000\u0092\u0093\u0007\u0004\u0000\u0000\u0093\u0094\u0007"+
		"\b\u0000\u0000\u0094\u0095\u0005 \u0000\u0000\u0095&\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0007\u0003\u0000\u0000\u0097\u0098\u0007\f\u0000\u0000"+
		"\u0098\u0099\u0007\u0007\u0000\u0000\u0099(\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0007\b\u0000\u0000\u009b\u009c\u0007\u0001\u0000\u0000\u009c*"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0007\f\u0000\u0000\u009e\u009f\u0007"+
		"\b\u0000\u0000\u009f\u00a0\u0007\u0004\u0000\u0000\u00a0,\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0007\u000b\u0000\u0000\u00a2\u00a3\u0007\f\u0000"+
		"\u0000\u00a3\u00a4\u0007\u0004\u0000\u0000\u00a4.\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0007\n\u0000\u0000\u00a6\u00a7\u0007\u0006\u0000\u0000\u00a7"+
		"\u00a8\u0007\b\u0000\u0000\u00a8\u00a9\u0007\u0003\u0000\u0000\u00a9\u00aa"+
		"\u0007\u0004\u0000\u0000\u00aa0\u0001\u0000\u0000\u0000\u00ab\u00ac\u0007"+
		"\u0011\u0000\u0000\u00ac\u00ad\u0007\u0004\u0000\u0000\u00ad\u00ae\u0007"+
		"\u0001\u0000\u0000\u00ae\u00af\u0007\u000b\u0000\u0000\u00af\u00b0\u0007"+
		"\f\u0000\u0000\u00b0\u00b1\u0007\u0010\u0000\u0000\u00b12\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b4\u0007\u0012\u0000\u0000\u00b3\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b7\u000209\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b94\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bc\u0007\u0012\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u00cf\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bf\u0003;\u001d\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c6"+
		"\u0005.\u0000\u0000\u00c3\u00c5\u0003;\u001d\u0000\u00c4\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00d0\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cb\u0005.\u0000"+
		"\u0000\u00ca\u00cc\u0003;\u001d\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0\u0001\u0000\u0000\u0000"+
		"\u00cf\u00be\u0001\u0000\u0000\u0000\u00cf\u00c9\u0001\u0000\u0000\u0000"+
		"\u00d06\u0001\u0000\u0000\u0000\u00d1\u00d5\u0005\'\u0000\u0000\u00d2"+
		"\u00d4\b\u0013\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d5"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\'\u0000\u0000\u00d98\u0001"+
		"\u0000\u0000\u0000\u00da\u00de\u0007\u0014\u0000\u0000\u00db\u00dd\u0007"+
		"\u0015\u0000\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001"+
		"\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001"+
		"\u0000\u0000\u0000\u00df:\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000"+
		"\u0000\u0000\u00e1\u00e2\u000209\u0000\u00e2<\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e5\u0007\u0016\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e9\u0006\u001e\u0000\u0000\u00e9>\u0001\u0000\u0000\u0000\u000b"+
		"\u0000\u00b3\u00b8\u00bb\u00c0\u00c6\u00cd\u00cf\u00d5\u00de\u00e6\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}