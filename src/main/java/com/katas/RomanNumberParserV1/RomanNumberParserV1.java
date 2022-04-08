package com.katas.RomanNumberParserV1;

public class RomanNumberParserV1 {

    public String convert(int amount) {
        String result = "";

        for (RomanNumbersEnum number : RomanNumbersEnum.values()) {
            while (amount >= number.getArabicFormat()) {
                if (amount >= number.getArabicFormat()) {
                    result += number;
                    amount -= number.getArabicFormat();
                }
            }
        }

        return result;
    }
}

