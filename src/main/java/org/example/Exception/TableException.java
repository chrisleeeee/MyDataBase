package org.example.Exception;

public class TableException extends Exception {
    public TableException() {
        super("Error occurred during manipulate the tables");
    }

    public TableException(String msg) {
        super(msg);
    }
}
