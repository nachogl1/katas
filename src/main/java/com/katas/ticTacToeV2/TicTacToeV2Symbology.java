package com.katas.ticTacToeV2;

public enum TicTacToeV2Symbology {
    PLAYER_ONE("X"),
    PLAYER_TWO("O"),
    EMPTY("-");

    private final String symbol;
//    private static int currentIndex = 0;
//    private static TicTacToeV2Symbology[] symbols = TicTacToeV2Symbology.values();

    TicTacToeV2Symbology(String symbol) {
        this.symbol = symbol;
    }

    //    public TicTacToeV2Symbology getNextPlayerV1() {
//        currentIndex = (currentIndex + 1) % getLengthAdaptedWithoutEmptyElement();
//        return symbols[currentIndex];
//    }
    public TicTacToeV2Symbology getNextPlayerV2() {
        return switch (this) {
            case PLAYER_ONE -> PLAYER_TWO;
            case PLAYER_TWO -> PLAYER_ONE;
            case EMPTY -> throw new IllegalArgumentException();
        };
    }

    public TicTacToeV2Symbology getNextPlayer() {
        TicTacToeV2Symbology[] values = TicTacToeV2Symbology.values();
        return values[(this.ordinal() + 1) % (values.length - 1)];
    }

//    private int getLengthAdaptedWithoutEmptyElement() {
//        return symbols.length - 1;
//    }

    public String getSymbol() {
        return this.symbol;
    }
}
