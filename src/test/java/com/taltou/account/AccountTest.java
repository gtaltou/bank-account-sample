package com.taltou.account;

import java.io.PrintStream;
import java.util.Date;

import com.taltou.amount.Amount;
import com.taltou.error.InsufficientFundException;
import com.taltou.statement.Statement;
import com.taltou.helpers.Helper;
import com.taltou.operation.OperationHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock private Statement aStatement;
    private Account account;

    @Before
    public void initialise() {
        account = new Account(aStatement);
    }

    @Test public void
    test_add_deposit_occurrence_to_statement() {
        Date depositDate = Helper.date("01/03/2021");
        Amount depositAmount = Amount.newAmount(3000);        account.computeDeposit(depositAmount, depositDate);

        verify(aStatement).appendOccurrenceContent(OperationHelper.aTransaction()
                        .with(depositDate)
                        .with(depositAmount).build(),
                currentBalanceEqualsTo(depositAmount));
    }

    @Test public void
    test_add_withdraw_occurrence_to_statement() throws InsufficientFundException {
        Date withdrawalDate = Helper.date("25/03/2021");
        account.computeWithdrawal(Amount.newAmount(1000), withdrawalDate);
        verify(aStatement).appendOccurrenceContent(OperationHelper.aTransaction()
                        .with(Amount.newAmount(-1000))
                        .with(withdrawalDate).build(),
                Amount.newAmount(-1000));
    }

    @Test public void
    test_print_statement() {
        PrintStream printer = System.out;
        account.printStatement(printer);
        verify(aStatement).printTo(printer);
    }

    private Amount currentBalanceEqualsTo(Amount amount) {
        return amount;
    }

}
