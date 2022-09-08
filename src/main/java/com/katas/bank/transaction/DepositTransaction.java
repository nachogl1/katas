package com.katas.bank.transaction;

public class DepositTransaction implements BankTransaction {
    private int amount;
    private String date;
    private int temporalProcessedTotalBalance;

    public DepositTransaction(int amount, String date) {
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

    @Override
    public void updateCurrentLocalTotalBalance(int currentTotal) {
        this.temporalProcessedTotalBalance = currentTotal + amount;
    }

    @Override
    public int getCurrentLocalTotalBalance() {
        return this.temporalProcessedTotalBalance;
    }


}
