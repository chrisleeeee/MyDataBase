package org.example;

import org.jline.reader.*;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
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
                    System.out.println(line);
                } catch (UserInterruptException e) {
                    // Handle Ctrl+C or other user interruptions if needed.
                    System.out.println("Interrupted.");
                }
            }
        } catch (EndOfFileException | IOException e) {
            System.out.println("");
        }
    }




}
