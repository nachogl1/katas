package com.katas.bank.transaction;

public class WithdrawTransaction implements BankTransaction {

    private int negativeAmount;
    private String date;
    private int temporalProcessedTotalBalance;


    public WithdrawTransaction(int amount, String date) {
        this.negativeAmount = -amount;
        this.date = date;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder()
                .append(date)
                .append(" || ")
                .append(negativeAmount)
                .append("   || ")
                .append(temporalProcessedTotalBalance)
                .append("\n");

        return sb.toString();
    }

    @Override
    public void updateCurrentInternalTotalBalance(int currentTotal) {
        this.temporalProcessedTotalBalance = currentTotal + negativeAmount;
    }

    @Override
    public int getCurrentInternalTotalBalance() {
        return this.temporalProcessedTotalBalance;
    }
}
