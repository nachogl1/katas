package com.katas.bank;

import com.katas.bank.account.BankAccount;
import com.katas.bank.account.PersonalBankAccount;
import com.katas.bank.clock.IBankClock;
import com.katas.bank.feedbackForUser.IBankStatementPrinter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.mockito.Mockito.*;

public class BankKataStepsDefinition {

    IBankStatementPrinter consoleMock;
    IBankClock clockMock;
    BankAccount account;
    IAccountService accountServiceMock;
    String expectedBankStatement;

    @Given("Pre-defined trail of user actions")
    public void preDefinedTrailOfUserActions() {
        consoleMock = mock(IBankStatementPrinter.class);
        clockMock = mock(IBankClock.class);
        account = new PersonalBankAccount();
        accountServiceMock = new ATMPersonalAccountService(consoleMock, clockMock, account);

        when(clockMock.getCurrentDateAsString()).thenReturn("10/01/2012", "13/01/2012", "14/01/2012");

        expectedBankStatement = """
                Date       || Amount || Balance
                14/01/2012 || -500   || 2500
                13/01/2012 || 2000   || 3000
                10/01/2012 || 1000   || 1000
                """;
    }

    @When("Using a Personal Account on ATM Machine")
    public void usingAPersonalAccountOnATMMachine() {
        accountServiceMock.deposit(1000);
        accountServiceMock.deposit(2000);
        accountServiceMock.withdraw(500);
        accountServiceMock.printStatement();
    }

    @Then("The system prints the correct bank statement")
    public void theSystemPrintsTheCorrectBankStatement() {

        verify(consoleMock, times(1)).printBankStatement(expectedBankStatement);
    }
}
