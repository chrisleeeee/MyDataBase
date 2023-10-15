package org.example;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.example.Exception.ParsingException;
import org.example.Exception.TableException;
import org.example.Components.Executor;
import org.example.Components.StorageManager;
import org.example.gen.TableQueryGrammarLexer;
import org.example.gen.TableQueryGrammarParser;
import org.example.statement.*;
import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            StorageManager.getInstance();
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();

            System.out.println("Welcome to My Database App!");
            System.out.println("Type 'exit' to quit.");

            String prompt = "zeyDB> ";
            String line;

            while (true) {
                try {
                    line = lineReader.readLine(prompt);
                    if (line == null || line.equalsIgnoreCase("exit")) {
                        System.out.println("Exiting...");
                        break;
                    }

//                    System.out.println(line);
                    parseQuery(line);

                } catch (UserInterruptException e) {
                    System.out.println("Interrupted.");
                } catch (TableException | ParsingException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (EndOfFileException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseQuery(String line) throws TableException, ParsingException {
        CharStream input = CharStreams.fromString(line);

        TableQueryGrammarLexer lexer = new TableQueryGrammarLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        TableQueryGrammarParser parser = new TableQueryGrammarParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new StatementErrorListener());
        TableQueryGrammarParser.QueryContext queryContext = parser.query();
        StatementVisitor visitor = new StatementVisitor();
        Statement statement = visitor.visit(queryContext);

        switch (statement.getType()) {
            case CREATE:
                Executor.executeCreateStatement((CreateTableStatement) statement);
                System.out.println("Successfully created the Table");
                break;
            case DROP:
                Executor.executeDropStatement(statement);
                System.out.println("Successfully dropped the Table");
                break;
            case ADD:
                System.out.println("add command");
                Executor.executeAddStatement((AddRecordStatement) statement);
                break;
            case FIND:
                System.out.println("Find command");
                Executor.executeFindStatement((FindRecordStatement) statement);
                break;
            case DELETE:
                System.out.println("Delete command");
                Executor.executeDeleteStatement((DeleteStatement) statement);
                break;
            case UPDATE:
                System.out.println("update command");
                break;
        }

    }


}
