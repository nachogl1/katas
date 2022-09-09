package com.katas.bank;


import com.katas.bank.account.BankAccount;
import com.katas.bank.account.PersonalBankAccount;
import com.katas.bank.clock.BankClock;
import com.katas.bank.feedbackForUser.BankStatementPrinter;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BankAcceptanceTest {

    @Test
    void givenAPredesignedUserActions_WhenUsingAPersonalAccountOnATMMachine_ThenSystemPrintsTheCorrectBankStatementCalculations() {
        BankStatementPrinter consoleMock = mock(BankStatementPrinter.class);
        BankClock clockMock = mock(BankClock.class);
        BankAccount account = new PersonalBankAccount();
        AccountService accountServiceMock = new ATMPersonalAccountService(consoleMock, clockMock, account);
        when(clockMock.getCurrentDateAsString()).thenReturn("10/01/2012", "13/01/2012", "14/01/2012");

        String expectedBankStatement = """
                Date       || Amount || Balance
                14/01/2012 || -500   || 2500
                13/01/2012 || 2000   || 3000
                10/01/2012 || 1000   || 1000
                """;

        accountServiceMock.deposit(1000);
        accountServiceMock.deposit(2000);
        accountServiceMock.withdraw(500);
        accountServiceMock.printStatement();

        verify(consoleMock, times(1)).printBankStatement(expectedBankStatement);
    }


}
