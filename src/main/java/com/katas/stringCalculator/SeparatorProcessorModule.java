package com.katas.stringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private void removeCustomSeparatorInfraestructure() {
        this.rawData = removeCustomSeparatorsDataFromRawData();
    }

    private String removeCustomSeparatorsDataFromRawData() {
        return this.rawData.split("\\n", 2)[1];
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
        String[] customSeparators = returnNewCustomSeparatorsByProcessingRawData(resultRegex);

        addNewSeparators(resultRegex, customSeparators);

        this.removeCustomSeparatorInfraestructure();
    }

    private void addNewSeparators(StringBuilder resultRegex, String[] customSeparators) {
        for (String separator : customSeparators) {
            resultRegex.append("(" + separator + ")|");
        }
    }

    private void addDefaultNonScapeSeparatorTo(StringBuilder resultRegex) {
        resultRegex.append("(" + this.POPULAR_NON_SCAPED_CHARACTER + ")|");
    }

    private String[] returnNewCustomSeparatorsByProcessingRawData(StringBuilder resultRegex) {
        String[] customSeparatorRawInfoAndNumbersRawInfo = splitRawDataIntoCustomSeparatorInfoAndNumberInfo();
        String newCustomSeparatorRawInformation = customSeparatorRawInfoAndNumbersRawInfo[0];
        String newCustomSeparatorsRefined = newCustomSeparatorRawInformation.substring(2);

        if (newCustomSeparatorsRefined.startsWith("[")) {

            List<String> result = new ArrayList<>();
            Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(newCustomSeparatorsRefined);

            while (m.find()) {//Finds Matching Pattern in String
                result.add(m.group(1));
            }

            String[] r2 = result.toArray(new String[0]);

            return r2;
        }

        return new String[]{newCustomSeparatorsRefined};
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
