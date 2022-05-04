package com.katas.stringCalculator;

public class ProcessorModule {

    private SeparatorProcessorModule separatorProcessorModule;
    private NumericProcessorModule numericProcessorModule;

    public ProcessorModule() {
        this.separatorProcessorModule = new SeparatorProcessorModule();
        this.numericProcessorModule = new NumericProcessorModule();
    }

    public int[] processData(String rawData) {
        String[] numbersAsText = this.separatorProcessorModule.separateElements(rawData);
        int[] numbersToSum = this.numericProcessorModule.transformToValidArrayOfNumbers(numbersAsText);

        return numbersToSum;
    }

}
