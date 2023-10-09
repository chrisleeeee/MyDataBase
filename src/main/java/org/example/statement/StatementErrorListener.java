package org.example.statement;

import org.antlr.v4.runtime.*;
import org.example.Exception.ParsingException;

public class StatementErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Display a custom error message
        throw new ParsingException("Syntax error at line " + line + ":" + charPositionInLine + ": " + msg);
        // You can choose to throw an exception here to stop parsing or handle the error differently
        // For your specific case, you may want to continue parsing with a default value for the size
    }
}
