package com.katas.bowling;

public enum BowlingGameSymbol {
    FRAME("|"),
    MISS("-"),
    STRIKE("X"),
    SPARE("/");

    private final String symbol;

    BowlingGameSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
