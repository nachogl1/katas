package com.katas.RomanNumberParserV1;

public class RomanNumberParserSG {
    public String parse(int i) {
        String result = "";
        for (RomanNumbersEnum number : RomanNumbersEnum.values()) {
            while (i >= number.getArabicFormat()) {
                i -= number.getArabicFormat();
                result = result+ number;
            }

        }
        return result;
    }

}
