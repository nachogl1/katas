package com.katas.stringCalculator;

public class StringCalculator {

    private ProcessorModule processorModule;

    public StringCalculator() {
        this.processorModule = new ProcessorModule();
    }

    public int sum(String rawData) {
        if (!rawData.isEmpty()) {
            int result = processSum(rawData);
            return result;
        } else {
            return 0;
        }
    }

    private int processSum(String rawData) {
        int[] numbersToSum = this.transformDataToValidFormat(rawData);
        int result = 0;

        for (int elementToSum : numbersToSum)
            result += elementToSum;

        return result;
    }

    private int[] transformDataToValidFormat(String rawData) {
        int[] numbersToSum = this.processorModule.processData(rawData);
        return numbersToSum;
    }
}
