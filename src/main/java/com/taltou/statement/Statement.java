package com.taltou.statement;

import com.taltou.amount.Amount;
import com.taltou.helpers.Helper;
import com.taltou.operation.Operation;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Statement {



    private final List<StatementItem> statementItems = new LinkedList<>();

    /**
     * @param operation : The operation object
     * @param currentBalance : The current balance object
     */
    public void appendOccurrenceContent(Operation operation, Amount currentBalance) {
        statementItems.add(Helper.START, new StatementItem(operation, currentBalance));
    }

    /**
     * @param printer : The print stream object
     */
    public void printTo(PrintStream printer) {
        printer.println(Helper.HEADER);
        printStatementOccurrence(printer);
    }

    /**
     * @param printer : The print stream object
     */
    private void printStatementOccurrence(PrintStream printer) {
        for (StatementItem statementItem : statementItems) {
            statementItem.printTo(printer);
        }
    }
}
