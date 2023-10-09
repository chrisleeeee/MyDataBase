package org.example.statement;

import org.example.gen.TableQueryGrammarParser;
import org.example.model.ColumnDefinition;

import java.util.ArrayList;
import java.util.List;

public class CreateTableStatement extends Statement {

    private List<ColumnDefinition> columnDefinition;

    public CreateTableStatement() {
        this.columnDefinition = new ArrayList<>();
    }

    public List<ColumnDefinition> getColumnDefinition() {
        return columnDefinition;
    }

    public void setColumnDefinition(List<ColumnDefinition> columnDefinition) {
        this.columnDefinition = columnDefinition;
    }

    public void setColumnDefinitionWithContext(List<TableQueryGrammarParser.ColumnDefinitionContext> columnDefinition) {
        for (TableQueryGrammarParser.ColumnDefinitionContext context : columnDefinition) {
            this.columnDefinition.add(new ColumnDefinition(context.columnName().getText(), context.dataType().getText()));
        }
    }


}
