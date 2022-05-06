package com.katas.stringCalculator;

public class ProcessorModule {
    private final SeparatorProcessorModule separatorProcessorModule;
    private final NumericProcessorModule numericProcessorModule;

    public ProcessorModule() {
        this.separatorProcessorModule = new SeparatorProcessorModule();
        this.numericProcessorModule = new NumericProcessorModule();
    }

    public int[] processData(String rawData) {

        String[] numbersAsText = processSeparators(rawData);

        int[] numbersToSum = processNumbers(numbersAsText);

        return numbersToSum;
    }

    private int[] processNumbers(String[] numbersAsText) {
        int[] numbersToSum = this.numericProcessorModule.transformToValidArrayOfNumbers(numbersAsText);
        return numbersToSum;
    }

    private String[] processSeparators(String rawData) {
        this.separatorProcessorModule.initModule(rawData);
        String[] numbersAsText = this.separatorProcessorModule.processSeparators();
        return numbersAsText;
    }

}
