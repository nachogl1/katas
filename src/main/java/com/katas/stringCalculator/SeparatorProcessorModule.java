package com.katas.stringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.katas.stringCalculator.PopularScapedSeparators.values;

public class SeparatorProcessorModule {

    public static final String NEXUS_BETWEEN_SEPARATORS_AND_NUMERIC_DATA = "\\n";
    private final String CUSTOM_SEPARATOR_SIGNAL = "//";

    private String rawData = "";

    public void initModule(String rawDataInput) {
        this.rawData = rawDataInput;
    }

    public String[] processSeparators() {

        if (this.rawData == null) throw new ModuleNotInitiatedException();

        String regex = this.getRegexForSeparators();

        return this.rawData.split(regex);

    }

    private String getRegexForSeparators() {
        StringBuilder resultRegex = new StringBuilder();

        //temporal coupling
        if (this.rawData.startsWith(CUSTOM_SEPARATOR_SIGNAL)) {
            appendNewCustomSeparatorsTo(resultRegex);
        }
        appendPopularSeparatorsTo(resultRegex);

        return resultRegex.toString();
    }

    private void appendNewCustomSeparatorsTo(StringBuilder resultRegex) {
        String[] customSeparators = returnNewCustomSeparatorsByProcessingRawData(resultRegex);

        appendNewCustomSeparatorsTo(resultRegex, customSeparators);

        this.rawData = removeCustomSeparatorsDataFromRawData();
    }

    private String[] returnNewCustomSeparatorsByProcessingRawData(StringBuilder resultRegex) {
        String[] customSeparatorRawInfoAndNumbersRawInfo = splitRawDataIntoCustomSeparatorInfoAndNumberInfo();
        String newCustomSeparatorRawInformation = customSeparatorRawInfoAndNumbersRawInfo[0];
        String newCustomSeparatorsRefined = removeCustomSeparatorStartingPattern(newCustomSeparatorRawInformation);

        if (isComplexCustomSeparatorDetected(newCustomSeparatorsRefined)) {
            return processComplexCustomSeparators(newCustomSeparatorsRefined);
        }

        return new String[]{newCustomSeparatorsRefined};
    }

    private String[] processComplexCustomSeparators(String newCustomSeparatorsRefined) {
        List<String> matches = new ArrayList<>();
        Matcher m = Pattern.compile("\\[(.*?)\\]").matcher(newCustomSeparatorsRefined);

        while (m.find()) {
            matches.add(m.group(1));
        }

        String[] result = matches.toArray(new String[0]);

        return result;
    }

    private boolean isComplexCustomSeparatorDetected(String newCustomSeparatorsRefined) {
        return newCustomSeparatorsRefined.startsWith("[");
    }

    private String removeCustomSeparatorStartingPattern(String newCustomSeparatorRawInformation) {
        return newCustomSeparatorRawInformation.substring(2);
    }

    private void appendNewCustomSeparatorsTo(StringBuilder resultRegex, String[] customSeparators) {
        for (String separator : customSeparators) {
            resultRegex.append("(").append(separator).append(")|");
        }
    }

    private String removeCustomSeparatorsDataFromRawData() {
        return this.rawData.split(NEXUS_BETWEEN_SEPARATORS_AND_NUMERIC_DATA, 2)[1];
    }

    private String[] splitRawDataIntoCustomSeparatorInfoAndNumberInfo() {
        return this.rawData.split(NEXUS_BETWEEN_SEPARATORS_AND_NUMERIC_DATA, 2);
    }

    private void appendPopularSeparatorsTo(StringBuilder resultRegex) {
        for (PopularScapedSeparators separator : values())
            resultRegex.append("(").append(separator.getSymbol()).append(")|");

        removeLastOROperatorFrom(resultRegex);
    }

    private void removeLastOROperatorFrom(StringBuilder resultRegex) {
        resultRegex.deleteCharAt(resultRegex.length() - 1);
    }


    private class ModuleNotInitiatedException extends RuntimeException {
    }
}
