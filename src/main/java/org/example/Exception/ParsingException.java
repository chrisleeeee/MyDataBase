package org.example.Exception;

public class ParsingException extends RuntimeException{
    public ParsingException() {
        super();
    }

    public ParsingException(String msg) {
        super(msg);
    }
}
