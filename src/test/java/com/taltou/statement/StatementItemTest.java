package com.taltou.statement;


import static com.taltou.helpers.Helper.date;
import static com.taltou.operation.OperationHelper.aTransaction;
import static com.taltou.amount.Amount.newAmount;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;



@RunWith(MockitoJUnitRunner.class)
public class StatementItemTest {

    @Mock
    PrintStream printer;

    @Test
    public void
    should_print_an_operation() {
        StatementItem statementItem = new StatementItem(
                aTransaction()
                        .with(newAmount(4000))
                        .with(date("15/03/2021")).build(),
                newAmount(4000));

        statementItem.printProcess(printer);

        verify(printer).println("15/03/2021 || 4000,00  ||          || 4000,00");
    }

    @Test public void
    test_print_withdrawal() {
        StatementItem statementItem = new StatementItem(
                aTransaction()
                        .with(newAmount(-500))
                        .with(date("15/03/2021")).build(),
                newAmount(-500));

        statementItem.printProcess(printer);

        verify(printer).println("15/03/2021 ||          || 500,00   || -500,00");
    }

}
