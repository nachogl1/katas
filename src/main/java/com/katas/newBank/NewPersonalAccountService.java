package com.katas.newBank;


public class NewPersonalAccountService implements NewBankAccountService {

    private StatementPrinter printer;
    private NewPersonalBankAccount account;
    private DateProvider dateProvider;

    public NewPersonalAccountService(StatementPrinter printer, DateProvider dateProvider) {
        this.printer = printer;
        this.account = new NewPersonalBankAccount();
        this.dateProvider = dateProvider;
    }

    @Override
    public void deposit(int amount) {
        account.addTransaction(new Deposit(amount, getCurrentDate()));
    }

    @Override
    public void withdraw(int amount) {
        account.addTransaction(new Withdraw(amount, getCurrentDate()));
    }

    @Override
    public void printStatement() {
        this.printer.printStatement(account.getTransactions());
    }

    private String getCurrentDate() {
        return dateProvider.getCurrentDate();
    }
}
