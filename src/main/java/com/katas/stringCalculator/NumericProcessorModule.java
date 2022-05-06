package com.katas.stringCalculator;

public class NumericProcessorModule {
    public int[] transformToValidArrayOfNumbers(String[] numbersAsText) {

        int[] result = convertTextNumbersToResultIntArray(numbersAsText);
        result = cleanArray(result);

        return result;
    }

    private int[] cleanArray(int[] dataToClean) {
        int[] result = new int[dataToClean.length];

        for (int i = 0; i < dataToClean.length; i++) {
            if (dataToClean[i] < 0) throw new NotNegativeNumbersAllowedException();
            result[i] = turnToZeroAnyNumberBiggerThan1000(dataToClean, i);
        }

        return result;
    }

    private int turnToZeroAnyNumberBiggerThan1000(int[] data, int i) {
        return data[i] > 1000 ? 0 : data[i];
    }

    private int[] convertTextNumbersToResultIntArray(String[] input) {
        int[] result = new int[input.length];

        for (int i = 0; i < input.length; i++)
            result[i] = parseToInt(input, i);

        return result;
    }

    private int parseToInt(String[] numbersAsText, int i) {
        try {
            return Integer.parseInt(numbersAsText[i]);
        } catch (NumberFormatException e) {
            return assignZeroIfEmptyCell();
        }
    }


    private int assignZeroIfEmptyCell() {
        return 0;
    }
}
