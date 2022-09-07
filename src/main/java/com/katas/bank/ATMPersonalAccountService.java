package com.katas.bank;

import com.katas.bank.account.BankAccount;
import com.katas.bank.clock.BankClock;
import com.katas.bank.feedbackForUser.BankStatementFeed;
import com.katas.bank.transaction.DepositTransaction;
import com.katas.bank.transaction.WithdrawTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ATMPersonalAccountService implements AccountService {

    BankStatementFeed console;
    BankClock clock;
    BankAccount account;

    @Autowired
    public ATMPersonalAccountService(BankStatementFeed console, BankClock clock, BankAccount account) {
        this.account = account;
        this.console = console;
        this.clock = clock;
    }

    @Override
    public void deposit(int amount) {
        DepositTransaction newDeposit = new DepositTransaction(amount, clock.getCurrentDateAsString());
        this.account.addTransaction(newDeposit);
    }

    @Override
    public void withdraw(int amount) {
        WithdrawTransaction newWithdraw = new WithdrawTransaction(amount, clock.getCurrentDateAsString());
        this.account.addTransaction(newWithdraw);
    }

    @Override
    public void printStatement() {
        String statementToBePrinted = this.account.returnTransactionStackAsString();
        this.console.printBankStatement(statementToBePrinted);
    }
}
