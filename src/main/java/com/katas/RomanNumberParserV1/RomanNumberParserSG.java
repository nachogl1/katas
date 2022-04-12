package com.katas.RomanNumberParserV1;

public class RomanNumberParserSG {
    public String parse(int source) {
        String result = "";
        for (RomanNumbersEnum number : RomanNumbersEnum.values()) {
            while (source >= number.getArabicFormat()) {
                source = substract(source, number);
                result = add(result, number);
            }

        }
        return result;
    }

    private String add(String result, RomanNumbersEnum number) {
        result += number;
        return result;
    }

    private int substract(int source, RomanNumbersEnum number) {
        source -= number.getArabicFormat();
        return source;
    }

}
