package com.katas.bank.transaction;

public interface BankTransaction {

    void updateCurrentLocalTotalBalance(int currentTotal);

    int getCurrentLocalTotalBalance();

}
