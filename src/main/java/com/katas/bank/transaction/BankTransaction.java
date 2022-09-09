package com.katas.bank.transaction;

public abstract class BankTransaction {

    protected int amount;
    protected String date;
    protected int temporalProcessedTotalBalance;

    public BankTransaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(date)
                .append(" || ")
                .append(amount)
                .append("   || ")
                .append(temporalProcessedTotalBalance)
                .append("\n");

        return sb.toString();
    }

    public void updateCurrentLocalTotalBalance(int currentTotal) {
        this.temporalProcessedTotalBalance = currentTotal + amount;
    }

    public int getCurrentLocalTotalBalance() {
        return this.temporalProcessedTotalBalance;
    }


}
