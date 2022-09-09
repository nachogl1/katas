package com.katas.newBank;


public class NewPersonalAccountService implements NewBankAccountService{

    private StatementPrinter printer;
    private NewPersonalBankAccount account;

    public NewPersonalAccountService(StatementPrinter printer) {
        this.printer = printer;
        this.account = new NewPersonalBankAccount();
    }

    @Override
    public void deposit(int amount) {
        account.addTransaction(new Deposit(amount));
    }

    @Override
    public void withdraw(int amount) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void printStatement() {
        throw new UnsupportedOperationException();
    }
}
