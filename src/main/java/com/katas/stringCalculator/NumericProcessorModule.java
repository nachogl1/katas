package com.katas.stringCalculator;

public class NumericProcessorModule {
    public int[] transformToValidArrayOfNumbers(String[] numbersAsText) {
        int[] result = new int[numbersAsText.length];

        convertToResultIntArray(result, numbersAsText);
        cleanArray(result);

        return result;
    }

    private void cleanArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] < 0) throw new NotNegativeNumbersAllowedException();
            data[i] = turnToZeroAnyNumberBiggerThan1000(data, i);
        }
    }

    private int turnToZeroAnyNumberBiggerThan1000(int[] data, int i) {
        return data[i] > 1000 ? 0 : data[i];
    }

    private void convertToResultIntArray(int[] target, String[] input) {
        for (int i = 0; i < input.length; i++) {
            parseOrAssignZeroIfEmpty(input, target, i);
        }
    }

    private void parseOrAssignZeroIfEmpty(String[] numbersAsText, int[] result, int i) {
        try {
            result[i] = Integer.parseInt(numbersAsText[i]);
        } catch (NumberFormatException e) {
            result[i] = assignZeroIfEmptyCell();
        }
    }


    private int assignZeroIfEmptyCell() {
        return 0;
    }
}
