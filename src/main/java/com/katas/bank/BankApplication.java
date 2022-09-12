package com.katas.bank;

import com.katas.bank.account.BankAccount;
import com.katas.bank.account.PersonalBankAccount;
import com.katas.bank.clock.AtomicBankClock;
import com.katas.bank.clock.IBankClock;
import com.katas.bank.feedbackForUser.ATMConsole;
import com.katas.bank.feedbackForUser.IBankStatementPrinter;

public class BankApplication {

    public static void main(String[] args) {
        IBankStatementPrinter console = new ATMConsole();
        IBankClock clock = new AtomicBankClock();
        BankAccount account = new PersonalBankAccount();
        IAccountService accountServiceMock = new ATMPersonalAccountService(console, clock, account);

        accountServiceMock.deposit(10000);
        accountServiceMock.deposit(2000);
        accountServiceMock.withdraw(500);
        accountServiceMock.printStatement();
    }

}
