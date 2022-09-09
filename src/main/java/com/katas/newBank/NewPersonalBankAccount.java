package com.katas.newBank;

import java.util.ArrayList;
import java.util.List;

public class NewPersonalBankAccount {

    private List<NewTransaction> transactions = new ArrayList<>();

    public void addTransaction(NewTransaction transaction) {
        this.transactions.add(transaction);

    }

    public List<NewTransaction> getTransactions() {
        return this.transactions;
    }
}
