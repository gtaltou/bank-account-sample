package com.taltou.statement;

import com.taltou.helpers.Helper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {

    @Mock
    PrintStream printer;

    private Statement statement;

    @Before
    public void initialise() {
        statement = new Statement();
    }

    @Test
    public void
    test_print_statement_header() {
        statement.printProcess(printer);

        verify(printer).println(Helper.HEADER);
    }


}
