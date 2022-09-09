package com.katas.newBank;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class NewBankShould {

    @Test
    void givenPredefinedSetOfActions_WhenAccountIsNew_ThenCorrectBankStatementIsPrinted() {
        StatementPrinter console = mock(StatementPrinter.class);
        StatementPrinter printer = new ConsoleStatementPrinter();
        DateProvider dateProvider = mock(DateProvider.class);
        NewBankAccountService accountService = new NewPersonalAccountService(printer,dateProvider);
        when(dateProvider.getCurrentDate()).thenReturn("10/01/2012", "13/01/2012", "14/01/2012");
        String bankStatement = """
                Date       || Amount || Balance
                14/01/2012 || -500   || 2500
                13/01/2012 || 2000   || 3000
                10/01/2012 || 1000   || 1000
                """;

        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);
        accountService.printStatement();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);

        accountService.printStatement();

        String statement = baos.toString();

        assertEquals(bankStatement, statement);
    }

}
