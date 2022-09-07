package com.katas.bank.transaction;

public interface BankTransaction {

    void updateCurrentInternalTotalBalance(int currentTotal);

    int getCurrentInternalTotalBalance();

}
