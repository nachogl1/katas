package com.katas.newBank;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class NewBankShould {

    @Test
    void givenPredefinedSetOfActions_WhenAccountIsNew_ThenCorrectBankStatementIsPrinted() {
        StatementPrinter console = mock(StatementPrinter.class);
        DateProvider dateProvider = mock(DateProvider.class);
        NewBankAccountService accountService = new NewPersonalAccountService(console);
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

        verify(console, times(1)).printStatement(bankStatement);
    }
}
