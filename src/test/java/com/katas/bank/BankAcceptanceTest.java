package com.katas.bank;


import com.katas.bank.account.BankAccount;
import com.katas.bank.account.PersonalBankAccount;
import com.katas.bank.clock.BankClock;
import com.katas.bank.feedbackForUser.ATMConsole;
import com.katas.bank.feedbackForUser.BankStatementFeed;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class BankAcceptanceTest {

    @Test
    void givenAPredesignedUserActions_WhenUsingAPersonalAccountOnATMMachine_ThenSystemPrintsTheCorrectBankStatementCalculations() {
        BankStatementFeed consoleMock = mock(ATMConsole.class);
        BankClock clockMock = mock(BankClock.class);
        BankAccount accountSpy = spy(new PersonalBankAccount());
        AccountService accountServiceMock = new ATMPersonalAccountService(consoleMock, clockMock, accountSpy);
        String expectedBankStatement = """
                Date       || Amount || Balance
                14/01/2012 || -500   || 2500
                13/01/2012 || 2000   || 3000
                10/01/2012 || 1000   || 1000
                """;

        when(clockMock.getCurrentDateAsString()).thenReturn("10/01/2012");
        accountServiceMock.deposit(1000);
        when(clockMock.getCurrentDateAsString()).thenReturn("13/01/2012");
        accountServiceMock.deposit(2000);
        when(clockMock.getCurrentDateAsString()).thenReturn("14/01/2012");
        accountServiceMock.withdraw(500);
        accountServiceMock.printStatement();

        verify(consoleMock, times(1)).printBankStatement(expectedBankStatement);
    }


}
