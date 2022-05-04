package com.katas.stringCalculator;

import static com.katas.stringCalculator.PopularScapeSeparators.NEWLINE;
import static com.katas.stringCalculator.PopularScapeSeparators.values;

public class SeparatorProcessorModule {

    private static final String CUSTOM_SEPARATOR_SIGNAL = "//";
    private static final String POPULAR_NON_SCAPED_CHARACTER = ",";

    private String rawData = "";

    public String[] separateElements(String rawDataInput) {
        this.rawData = rawDataInput;

        String regex = this.getRegexForSeparators();

        String[] rawDataSplit = this.rawData.split(regex);

        return rawDataSplit;
    }

    private void removeCustomSeparatorInfraestructure(int lenghtOfCustomSeparator) {
        this.rawData = this.rawData.substring(2 + lenghtOfCustomSeparator);
    }

    private String getRegexForSeparators() {
        StringBuilder resultRegex = new StringBuilder();

        //temporal coupling
        if (this.rawData.startsWith(CUSTOM_SEPARATOR_SIGNAL)) {
            processNewCustomSeparators(resultRegex);
        }
        addDefaultNonScapeSeparatorTo(resultRegex);
        addPopularSeparatorsTo(resultRegex);

        return resultRegex.toString();
    }

    private void processNewCustomSeparators(StringBuilder resultRegex) {
        //check if it is about  many long
        String customSeparator = addCustomSeparatorsByProcessingRawDataTo(resultRegex);
        this.removeCustomSeparatorInfraestructure(customSeparator.length());
    }

    private void addDefaultNonScapeSeparatorTo(StringBuilder resultRegex) {
        resultRegex.append("(" + this.POPULAR_NON_SCAPED_CHARACTER + ")|");
    }

    private String addCustomSeparatorsByProcessingRawDataTo(StringBuilder resultRegex) {
        String[] customSeparatorRawInfoAndNumbersRawInfo = splitRawDataIntoCustomSeparatorInfoAndNumberInfo();
        String newCustomSeparatorRawInformation = customSeparatorRawInfoAndNumbersRawInfo[0];
        String newCustomSeparatorRefined = newCustomSeparatorRawInformation.substring(2);
        resultRegex.append("(" + newCustomSeparatorRefined + ")|");
        return newCustomSeparatorRefined;
    }

    private String[] splitRawDataIntoCustomSeparatorInfoAndNumberInfo() {
        return this.rawData.split(NEWLINE.getSymbol(), 2);
    }

    private void addPopularSeparatorsTo(StringBuilder resultRegex) {
        for (PopularScapeSeparators separator : values())
            resultRegex.append("(" + separator.getSymbol() + ")|");

        removeLastOROperatorFrom(resultRegex);
    }

    private void removeLastOROperatorFrom(StringBuilder resultRegex) {
        resultRegex.deleteCharAt(resultRegex.length() - 1);
    }
}
