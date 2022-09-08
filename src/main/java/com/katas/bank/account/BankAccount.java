package com.katas.bank.account;

import com.katas.bank.transaction.BankTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class BankAccount {

    private final String TABLE_HEADER = "Date       || Amount || Balance\n";
    private List<BankTransaction> transactions = new ArrayList<>();
    private Stack<String> transactionsAsString = new Stack();

    public void addTransaction(BankTransaction newTransaction) {
        this.transactions.add(newTransaction);
    }

    public String returnTransactionStackAsString() {
        populateTransactionAsStringStack();

        StringBuilder statementBuilder = new StringBuilder(TABLE_HEADER);
        while (!this.transactionsAsString.isEmpty()) {
            statementBuilder.append(this.transactionsAsString.pop());
        }

        return statementBuilder.toString();
    }

    private void populateTransactionAsStringStack() {
        int currentTotalBalance = 0;

        for (BankTransaction bankTransaction : this.transactions) {
            bankTransaction.updateCurrentLocalTotalBalance(currentTotalBalance);
            currentTotalBalance = bankTransaction.getCurrentLocalTotalBalance();

            this.transactionsAsString.push(bankTransaction.toString());

        }

    }


}
