package com.katas.bank.transaction;

public class WithdrawTransaction extends BankTransaction {

    public WithdrawTransaction(int amount, String date) {
        super(transformIntoNegativeAmount(amount), date);
    }

    private static int transformIntoNegativeAmount(int amount) {
        return -amount;
    }
}
