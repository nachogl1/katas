package com.katas.newBank;

public abstract class NewTransaction {

    protected int amount;
    protected String date;

    public NewTransaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

}
