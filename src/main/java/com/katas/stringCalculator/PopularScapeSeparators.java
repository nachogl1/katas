package com.katas.stringCalculator;

public enum PopularScapeSeparators {
    NEWLINE("\\n"),
    TAB("\\t"),
//    BACKSPACE("\\b"), this ws playing with me
    CARRIAGE_RETURN("\\r"),
    FORM_FEED("\\f"),
    SINGLE_QUOTE("\\\'"),
    DOUBLE_QUOTE("\\\""),
    BACKSLASH("\\\\");

    private final String symbol;

    PopularScapeSeparators(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
