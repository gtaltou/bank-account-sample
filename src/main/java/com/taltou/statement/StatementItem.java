package com.taltou.statement;

import com.taltou.amount.Amount;
import com.taltou.operation.Operation;

import java.io.PrintStream;

public class StatementItem {

    private Operation operation;
    private Amount currentBalance;

    public StatementItem(Operation operation, Amount currentBalance) {
        this.operation = operation;
        this.currentBalance = currentBalance;
    }

    /**
     * Print the process
     * @param printer : The print stream object
     */
    public void printProcess(PrintStream printer) {
        this.operation.printProcess(printer, currentBalance);
    }

}
