package com.katas.bank.feedbackForUser;

import org.springframework.stereotype.Component;

@Component
public class ATMConsole implements IBankStatementPrinter {
    @Override
    public void printBankStatement(String statement) {
        System.out.println(statement);
    }
}
