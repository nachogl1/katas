package com.katas.bank.account;

import com.katas.bank.transaction.BankTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BankAccount {

    public static final String TABLE_HEADER = "Date       || Amount || Balance\n";
    List<BankTransaction> transactionList = new ArrayList<>();
    Stack<String> transactionResultStack = new Stack();

    public void addTransaction(BankTransaction newTransaction) {
        this.transactionList.add(newTransaction);
    }

    public String returnTransactionStackAsString() {
        populateTransactionResultStack();

        StringBuilder statementBuilder = new StringBuilder(TABLE_HEADER);
        while (!this.transactionResultStack.isEmpty()) {
            statementBuilder.append(this.transactionResultStack.pop());
        }

        return statementBuilder.toString();
    }

    private void populateTransactionResultStack() {
        int currentTotalBalance = 0;

        for (BankTransaction bankTransaction : this.transactionList) {
            bankTransaction.updateCurrentInternalTotalBalance(currentTotalBalance);
            currentTotalBalance = bankTransaction.getCurrentInternalTotalBalance();

            this.transactionResultStack.push(bankTransaction.toString());

        }

    }


}
