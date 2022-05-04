package com.katas.ticTacToeV2;

public enum TicTacToeV2Symbology {
    PLAYER_ONE("X"),
    PLAYER_TWO("O"),
    EMPTY("-");

    private final String symbol;
    private static int currentIndex = 0;
    private static TicTacToeV2Symbology[] symbols = TicTacToeV2Symbology.values();

    TicTacToeV2Symbology(String symbol) {
        this.symbol = symbol;
    }

    public static TicTacToeV2Symbology getNextPlayer() {
        currentIndex = (currentIndex + 1) % getLengthAdaptedWithoutEmptyElement();
        return symbols[currentIndex];
    }

    private static int getLengthAdaptedWithoutEmptyElement() {
        return symbols.length - 1;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
