package com.katas.ticTacToeGame;

public enum TicTacToeV2Symbology {
    PLAYER_ONE("X"),
    PLAYER_TWO("O"),
    EMPTY("-");

    private final String symbol;

    TicTacToeV2Symbology(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
