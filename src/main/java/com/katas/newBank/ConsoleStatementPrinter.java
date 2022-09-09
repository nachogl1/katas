package com.katas.newBank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsoleStatementPrinter implements StatementPrinter {

    @Override
    public void printStatement(List<NewTransaction> transactions) {
        var header = "Date       || Amount || Balance";
        var statementLines = new ArrayList<String>();
        var balance = 0;

        for (var transaction:transactions) {
            if (transaction instanceof Deposit) {
                balance += transaction.amount;
            } else {
                balance -= transaction.amount;
            }
            var line = formatStatement(transaction, balance);
            statementLines.add(line);
        }
        Collections.reverse(statementLines);
        statementLines.add(0, header);
        var statement = String.join("\n", statementLines);
        System.out.println(statement);
    }

    private String formatStatement(NewTransaction transaction, int runningBalance) {
        if (transaction instanceof Deposit) {
            return transaction.date + " || " + transaction.amount + "   || " + runningBalance;
        }
        if (transaction instanceof Withdraw) {
            return transaction.date + " || " + -transaction.amount + "   || " + runningBalance;
        }
        return null;
    }


}
