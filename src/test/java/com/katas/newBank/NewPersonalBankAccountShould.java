package com.katas.newBank;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NewPersonalBankAccountShould {

    @Test
    void givenATransactionIsAdded_WhenAccountIsEmpty_ThenItHasOneTransaction() {
        NewPersonalBankAccount account = new NewPersonalBankAccount();

        account.addTransaction(new Deposit(2000, "01/01/01"));
        List<NewTransaction> transactions = account.getTransactions();

        assertEquals(1, transactions.size());

    }

}