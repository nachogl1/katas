package com.katas.stringCalculator;

public enum PopularScapedSeparators {
    NEWLINE("\\n"),
    COMMA(","),
    TAB("\\t"),
//    BACKSPACE("\\b"), this ws playing with me wih the negative numbers
    CARRIAGE_RETURN("\\r"),
    FORM_FEED("\\f"),
    SINGLE_QUOTE("\'"),
    DOUBLE_QUOTE("\\\""),
    BACKSLASH("\\\\");

    private final String symbol;

    PopularScapedSeparators(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
