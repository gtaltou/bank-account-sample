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

    public void printTo(PrintStream printer) {
        this.operation.printTo(printer, currentBalance);
    }

}
