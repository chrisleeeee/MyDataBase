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
		T__9=10, T__10=11, T__11=12, T__12=13, CreateTable=14, DropTable=15, AddRecord=16, 
		FindRecord=17, UpdateRecord=18, DeleteRecord=19, MAX=20, MIN=21, AVG=22, 
		SUM=23, COUNT=24, GroupBy=25, Join=26, On=27, From=28, Having=29, To=30, 
		AND=31, OR=32, NOT=33, Integer=34, Float=35, String=36, INT_VALUE=37, 
		FlOAT_VALUE=38, STRING_VALUE=39, IDENTIFIER=40, DIGIT=41, WS=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "CreateTable", "DropTable", "AddRecord", 
			"FindRecord", "UpdateRecord", "DeleteRecord", "MAX", "MIN", "AVG", "SUM", 
			"COUNT", "GroupBy", "Join", "On", "From", "Having", "To", "AND", "OR", 
			"NOT", "Integer", "Float", "String", "INT_VALUE", "FlOAT_VALUE", "STRING_VALUE", 
			"IDENTIFIER", "DIGIT", "WS"
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
		"\u0004\u0000*\u0143\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001"+
		"!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001$\u0003$\u010d\b$\u0001$\u0004$\u0110"+
		"\b$\u000b$\f$\u0111\u0001%\u0003%\u0115\b%\u0001%\u0004%\u0118\b%\u000b"+
		"%\f%\u0119\u0001%\u0001%\u0005%\u011e\b%\n%\f%\u0121\t%\u0001%\u0001%"+
		"\u0004%\u0125\b%\u000b%\f%\u0126\u0003%\u0129\b%\u0001&\u0001&\u0005&"+
		"\u012d\b&\n&\f&\u0130\t&\u0001&\u0001&\u0001\'\u0001\'\u0005\'\u0136\b"+
		"\'\n\'\f\'\u0139\t\'\u0001(\u0001(\u0001)\u0004)\u013e\b)\u000b)\f)\u013f"+
		"\u0001)\u0001)\u0000\u0000*\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		";\u001e=\u001f? A!C\"E#G$I%K&M\'O(Q)S*\u0001\u0000\u001c\u0002\u0000C"+
		"Ccc\u0002\u0000RRrr\u0002\u0000EEee\u0002\u0000AAaa\u0002\u0000TTtt\u0002"+
		"\u0000BBbb\u0002\u0000LLll\u0002\u0000DDdd\u0002\u0000OOoo\u0002\u0000"+
		"PPpp\u0002\u0000FFff\u0002\u0000IIii\u0002\u0000NNnn\u0002\u0000UUuu\u0002"+
		"\u0000MMmm\u0002\u0000XXxx\u0002\u0000VVvv\u0002\u0000GGgg\u0002\u0000"+
		"SSss\u0001\u0000  \u0002\u0000YYyy\u0002\u0000JJjj\u0002\u0000HHhh\u0002"+
		"\u0000++--\u0001\u0000\'\'\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003"+
		"\u0000\t\n\r\r  \u014c\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000"+
		"\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000"+
		"E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001"+
		"\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000"+
		"\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000"+
		"S\u0001\u0000\u0000\u0000\u0001U\u0001\u0000\u0000\u0000\u0003W\u0001"+
		"\u0000\u0000\u0000\u0005Y\u0001\u0000\u0000\u0000\u0007[\u0001\u0000\u0000"+
		"\u0000\t]\u0001\u0000\u0000\u0000\u000b_\u0001\u0000\u0000\u0000\ra\u0001"+
		"\u0000\u0000\u0000\u000fc\u0001\u0000\u0000\u0000\u0011e\u0001\u0000\u0000"+
		"\u0000\u0013h\u0001\u0000\u0000\u0000\u0015k\u0001\u0000\u0000\u0000\u0017"+
		"n\u0001\u0000\u0000\u0000\u0019p\u0001\u0000\u0000\u0000\u001br\u0001"+
		"\u0000\u0000\u0000\u001d~\u0001\u0000\u0000\u0000\u001f\u0088\u0001\u0000"+
		"\u0000\u0000!\u0092\u0001\u0000\u0000\u0000#\u009d\u0001\u0000\u0000\u0000"+
		"%\u00aa\u0001\u0000\u0000\u0000\'\u00b7\u0001\u0000\u0000\u0000)\u00bb"+
		"\u0001\u0000\u0000\u0000+\u00bf\u0001\u0000\u0000\u0000-\u00c3\u0001\u0000"+
		"\u0000\u0000/\u00c7\u0001\u0000\u0000\u00001\u00cd\u0001\u0000\u0000\u0000"+
		"3\u00d6\u0001\u0000\u0000\u00005\u00db\u0001\u0000\u0000\u00007\u00de"+
		"\u0001\u0000\u0000\u00009\u00e3\u0001\u0000\u0000\u0000;\u00ea\u0001\u0000"+
		"\u0000\u0000=\u00ef\u0001\u0000\u0000\u0000?\u00f3\u0001\u0000\u0000\u0000"+
		"A\u00f6\u0001\u0000\u0000\u0000C\u00fa\u0001\u0000\u0000\u0000E\u00fe"+
		"\u0001\u0000\u0000\u0000G\u0104\u0001\u0000\u0000\u0000I\u010c\u0001\u0000"+
		"\u0000\u0000K\u0114\u0001\u0000\u0000\u0000M\u012a\u0001\u0000\u0000\u0000"+
		"O\u0133\u0001\u0000\u0000\u0000Q\u013a\u0001\u0000\u0000\u0000S\u013d"+
		"\u0001\u0000\u0000\u0000UV\u0005(\u0000\u0000V\u0002\u0001\u0000\u0000"+
		"\u0000WX\u0005,\u0000\u0000X\u0004\u0001\u0000\u0000\u0000YZ\u0005)\u0000"+
		"\u0000Z\u0006\u0001\u0000\u0000\u0000[\\\u0005;\u0000\u0000\\\b\u0001"+
		"\u0000\u0000\u0000]^\u0005.\u0000\u0000^\n\u0001\u0000\u0000\u0000_`\u0005"+
		"=\u0000\u0000`\f\u0001\u0000\u0000\u0000ab\u0005<\u0000\u0000b\u000e\u0001"+
		"\u0000\u0000\u0000cd\u0005>\u0000\u0000d\u0010\u0001\u0000\u0000\u0000"+
		"ef\u0005>\u0000\u0000fg\u0005=\u0000\u0000g\u0012\u0001\u0000\u0000\u0000"+
		"hi\u0005<\u0000\u0000ij\u0005=\u0000\u0000j\u0014\u0001\u0000\u0000\u0000"+
		"kl\u0005!\u0000\u0000lm\u0005=\u0000\u0000m\u0016\u0001\u0000\u0000\u0000"+
		"no\u0005:\u0000\u0000o\u0018\u0001\u0000\u0000\u0000pq\u0005*\u0000\u0000"+
		"q\u001a\u0001\u0000\u0000\u0000rs\u0007\u0000\u0000\u0000st\u0007\u0001"+
		"\u0000\u0000tu\u0007\u0002\u0000\u0000uv\u0007\u0003\u0000\u0000vw\u0007"+
		"\u0004\u0000\u0000wx\u0007\u0002\u0000\u0000xy\u0007\u0004\u0000\u0000"+
		"yz\u0007\u0003\u0000\u0000z{\u0007\u0005\u0000\u0000{|\u0007\u0006\u0000"+
		"\u0000|}\u0007\u0002\u0000\u0000}\u001c\u0001\u0000\u0000\u0000~\u007f"+
		"\u0007\u0007\u0000\u0000\u007f\u0080\u0007\u0001\u0000\u0000\u0080\u0081"+
		"\u0007\b\u0000\u0000\u0081\u0082\u0007\t\u0000\u0000\u0082\u0083\u0007"+
		"\u0004\u0000\u0000\u0083\u0084\u0007\u0003\u0000\u0000\u0084\u0085\u0007"+
		"\u0005\u0000\u0000\u0085\u0086\u0007\u0006\u0000\u0000\u0086\u0087\u0007"+
		"\u0002\u0000\u0000\u0087\u001e\u0001\u0000\u0000\u0000\u0088\u0089\u0007"+
		"\u0003\u0000\u0000\u0089\u008a\u0007\u0007\u0000\u0000\u008a\u008b\u0007"+
		"\u0007\u0000\u0000\u008b\u008c\u0007\u0001\u0000\u0000\u008c\u008d\u0007"+
		"\u0002\u0000\u0000\u008d\u008e\u0007\u0000\u0000\u0000\u008e\u008f\u0007"+
		"\b\u0000\u0000\u008f\u0090\u0007\u0001\u0000\u0000\u0090\u0091\u0007\u0007"+
		"\u0000\u0000\u0091 \u0001\u0000\u0000\u0000\u0092\u0093\u0007\n\u0000"+
		"\u0000\u0093\u0094\u0007\u000b\u0000\u0000\u0094\u0095\u0007\f\u0000\u0000"+
		"\u0095\u0096\u0007\u0007\u0000\u0000\u0096\u0097\u0007\u0001\u0000\u0000"+
		"\u0097\u0098\u0007\u0002\u0000\u0000\u0098\u0099\u0007\u0000\u0000\u0000"+
		"\u0099\u009a\u0007\b\u0000\u0000\u009a\u009b\u0007\u0001\u0000\u0000\u009b"+
		"\u009c\u0007\u0007\u0000\u0000\u009c\"\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0007\r\u0000\u0000\u009e\u009f\u0007\t\u0000\u0000\u009f\u00a0\u0007"+
		"\u0007\u0000\u0000\u00a0\u00a1\u0007\u0003\u0000\u0000\u00a1\u00a2\u0007"+
		"\u0004\u0000\u0000\u00a2\u00a3\u0007\u0002\u0000\u0000\u00a3\u00a4\u0007"+
		"\u0001\u0000\u0000\u00a4\u00a5\u0007\u0002\u0000\u0000\u00a5\u00a6\u0007"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0007\b\u0000\u0000\u00a7\u00a8\u0007\u0001"+
		"\u0000\u0000\u00a8\u00a9\u0007\u0007\u0000\u0000\u00a9$\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0007\u0007\u0000\u0000\u00ab\u00ac\u0007\u0002\u0000"+
		"\u0000\u00ac\u00ad\u0007\u0006\u0000\u0000\u00ad\u00ae\u0007\u0002\u0000"+
		"\u0000\u00ae\u00af\u0007\u0004\u0000\u0000\u00af\u00b0\u0007\u0002\u0000"+
		"\u0000\u00b0\u00b1\u0007\u0001\u0000\u0000\u00b1\u00b2\u0007\u0002\u0000"+
		"\u0000\u00b2\u00b3\u0007\u0000\u0000\u0000\u00b3\u00b4\u0007\b\u0000\u0000"+
		"\u00b4\u00b5\u0007\u0001\u0000\u0000\u00b5\u00b6\u0007\u0007\u0000\u0000"+
		"\u00b6&\u0001\u0000\u0000\u0000\u00b7\u00b8\u0007\u000e\u0000\u0000\u00b8"+
		"\u00b9\u0007\u0003\u0000\u0000\u00b9\u00ba\u0007\u000f\u0000\u0000\u00ba"+
		"(\u0001\u0000\u0000\u0000\u00bb\u00bc\u0007\u000e\u0000\u0000\u00bc\u00bd"+
		"\u0007\u000b\u0000\u0000\u00bd\u00be\u0007\f\u0000\u0000\u00be*\u0001"+
		"\u0000\u0000\u0000\u00bf\u00c0\u0007\u0003\u0000\u0000\u00c0\u00c1\u0007"+
		"\u0010\u0000\u0000\u00c1\u00c2\u0007\u0011\u0000\u0000\u00c2,\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0007\u0012\u0000\u0000\u00c4\u00c5\u0007\r\u0000"+
		"\u0000\u00c5\u00c6\u0007\u000e\u0000\u0000\u00c6.\u0001\u0000\u0000\u0000"+
		"\u00c7\u00c8\u0007\u0000\u0000\u0000\u00c8\u00c9\u0007\b\u0000\u0000\u00c9"+
		"\u00ca\u0007\r\u0000\u0000\u00ca\u00cb\u0007\f\u0000\u0000\u00cb\u00cc"+
		"\u0007\u0004\u0000\u0000\u00cc0\u0001\u0000\u0000\u0000\u00cd\u00ce\u0007"+
		"\u0011\u0000\u0000\u00ce\u00cf\u0007\u0001\u0000\u0000\u00cf\u00d0\u0007"+
		"\b\u0000\u0000\u00d0\u00d1\u0007\r\u0000\u0000\u00d1\u00d2\u0007\t\u0000"+
		"\u0000\u00d2\u00d3\u0007\u0013\u0000\u0000\u00d3\u00d4\u0007\u0005\u0000"+
		"\u0000\u00d4\u00d5\u0007\u0014\u0000\u0000\u00d52\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d7\u0007\u0015\u0000\u0000\u00d7\u00d8\u0007\b\u0000\u0000\u00d8"+
		"\u00d9\u0007\u000b\u0000\u0000\u00d9\u00da\u0007\f\u0000\u0000\u00da4"+
		"\u0001\u0000\u0000\u0000\u00db\u00dc\u0007\b\u0000\u0000\u00dc\u00dd\u0007"+
		"\f\u0000\u0000\u00dd6\u0001\u0000\u0000\u0000\u00de\u00df\u0007\n\u0000"+
		"\u0000\u00df\u00e0\u0007\u0001\u0000\u0000\u00e0\u00e1\u0007\b\u0000\u0000"+
		"\u00e1\u00e2\u0007\u000e\u0000\u0000\u00e28\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0007\u0016\u0000\u0000\u00e4\u00e5\u0007\u0003\u0000\u0000\u00e5"+
		"\u00e6\u0007\u0010\u0000\u0000\u00e6\u00e7\u0007\u000b\u0000\u0000\u00e7"+
		"\u00e8\u0007\f\u0000\u0000\u00e8\u00e9\u0007\u0011\u0000\u0000\u00e9:"+
		"\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005 \u0000\u0000\u00eb\u00ec\u0007"+
		"\u0004\u0000\u0000\u00ec\u00ed\u0007\b\u0000\u0000\u00ed\u00ee\u0005 "+
		"\u0000\u0000\u00ee<\u0001\u0000\u0000\u0000\u00ef\u00f0\u0007\u0003\u0000"+
		"\u0000\u00f0\u00f1\u0007\f\u0000\u0000\u00f1\u00f2\u0007\u0007\u0000\u0000"+
		"\u00f2>\u0001\u0000\u0000\u0000\u00f3\u00f4\u0007\b\u0000\u0000\u00f4"+
		"\u00f5\u0007\u0001\u0000\u0000\u00f5@\u0001\u0000\u0000\u0000\u00f6\u00f7"+
		"\u0007\f\u0000\u0000\u00f7\u00f8\u0007\b\u0000\u0000\u00f8\u00f9\u0007"+
		"\u0004\u0000\u0000\u00f9B\u0001\u0000\u0000\u0000\u00fa\u00fb\u0007\u000b"+
		"\u0000\u0000\u00fb\u00fc\u0007\f\u0000\u0000\u00fc\u00fd\u0007\u0004\u0000"+
		"\u0000\u00fdD\u0001\u0000\u0000\u0000\u00fe\u00ff\u0007\n\u0000\u0000"+
		"\u00ff\u0100\u0007\u0006\u0000\u0000\u0100\u0101\u0007\b\u0000\u0000\u0101"+
		"\u0102\u0007\u0003\u0000\u0000\u0102\u0103\u0007\u0004\u0000\u0000\u0103"+
		"F\u0001\u0000\u0000\u0000\u0104\u0105\u0007\u0012\u0000\u0000\u0105\u0106"+
		"\u0007\u0004\u0000\u0000\u0106\u0107\u0007\u0001\u0000\u0000\u0107\u0108"+
		"\u0007\u000b\u0000\u0000\u0108\u0109\u0007\f\u0000\u0000\u0109\u010a\u0007"+
		"\u0011\u0000\u0000\u010aH\u0001\u0000\u0000\u0000\u010b\u010d\u0007\u0017"+
		"\u0000\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u0110\u000209\u0000"+
		"\u010f\u010e\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000"+
		"\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112J\u0001\u0000\u0000\u0000\u0113\u0115\u0007\u0017\u0000\u0000\u0114"+
		"\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115"+
		"\u0128\u0001\u0000\u0000\u0000\u0116\u0118\u0003Q(\u0000\u0117\u0116\u0001"+
		"\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000\u0000\u0119\u0117\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011b\u0001"+
		"\u0000\u0000\u0000\u011b\u011f\u0005.\u0000\u0000\u011c\u011e\u0003Q("+
		"\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011e\u0121\u0001\u0000\u0000"+
		"\u0000\u011f\u011d\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000"+
		"\u0000\u0120\u0129\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000"+
		"\u0000\u0122\u0124\u0005.\u0000\u0000\u0123\u0125\u0003Q(\u0000\u0124"+
		"\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126"+
		"\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127"+
		"\u0129\u0001\u0000\u0000\u0000\u0128\u0117\u0001\u0000\u0000\u0000\u0128"+
		"\u0122\u0001\u0000\u0000\u0000\u0129L\u0001\u0000\u0000\u0000\u012a\u012e"+
		"\u0005\'\u0000\u0000\u012b\u012d\b\u0018\u0000\u0000\u012c\u012b\u0001"+
		"\u0000\u0000\u0000\u012d\u0130\u0001\u0000\u0000\u0000\u012e\u012c\u0001"+
		"\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0131\u0001"+
		"\u0000\u0000\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0131\u0132\u0005"+
		"\'\u0000\u0000\u0132N\u0001\u0000\u0000\u0000\u0133\u0137\u0007\u0019"+
		"\u0000\u0000\u0134\u0136\u0007\u001a\u0000\u0000\u0135\u0134\u0001\u0000"+
		"\u0000\u0000\u0136\u0139\u0001\u0000\u0000\u0000\u0137\u0135\u0001\u0000"+
		"\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138P\u0001\u0000\u0000"+
		"\u0000\u0139\u0137\u0001\u0000\u0000\u0000\u013a\u013b\u000209\u0000\u013b"+
		"R\u0001\u0000\u0000\u0000\u013c\u013e\u0007\u001b\u0000\u0000\u013d\u013c"+
		"\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u013d"+
		"\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u0141"+
		"\u0001\u0000\u0000\u0000\u0141\u0142\u0006)\u0000\u0000\u0142T\u0001\u0000"+
		"\u0000\u0000\u000b\u0000\u010c\u0111\u0114\u0119\u011f\u0126\u0128\u012e"+
		"\u0137\u013f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}