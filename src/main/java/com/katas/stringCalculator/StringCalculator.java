package com.katas.stringCalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static final String BASIC_SEPARATORS = "(,)|(\\n)";
    public static final String LIMIT_FOR_CUSTOM_SEPARATORS_PATTERN = "\\n";
    public static final String CUSTOM_SEPARTOR_PATTERN_CODE = "//";
    public static final String MULTIPLE_CUSTOM_SEPARATOR_CODE = "//[";
    String separators = "";
    int[] numbersReadyForOperation;
    String numbersToBeProcessed = "";


    public StringCalculator() {
        this.separators = BASIC_SEPARATORS;
    }

    public int add() {
        int result = 0;

        if (isNoNumberProvided()) {
            return result;
        }

        if (isOnlyOneNumberProvided(this.numbersReadyForOperation)) {
            result = this.numbersReadyForOperation[0];
        } else {
            for (int i = 0; i < this.numbersReadyForOperation.length; i++) {
                result += this.numbersReadyForOperation[i];
            }
        }

        return result;
    }

    public void initCalculator(String rawData) {

        if (isCustomSeparatorCodeDetected(rawData)) rawData = separateCustomSeparatorFromNumbericData(rawData);
        if (this.isMultipleCustomSeparatorCodeDetected(rawData))
            rawData = separateMultipleCustomSeparatorFromNumbericData(rawData);

        this.numbersToBeProcessed = rawData;
        String[] numberAsText = rawData.split(this.separators);
        this.numbersReadyForOperation = new int[numberAsText.length];
        for (int i = 0; i < numberAsText.length && isNumberListEmpty(); i++) {
            this.numbersReadyForOperation[i] = Integer.parseInt(numberAsText[i]);
        }
        this.runChecks();
    }

    private boolean isNumberListEmpty() {
        return !this.numbersToBeProcessed.isEmpty();
    }

    private void runChecks() {
        String negatives = lookForNegativeNumbers();

        if (!negatives.isEmpty())
            throw new IllegalArgumentException("No negative number are allowed, detected: " + negatives);

        cleanNumbersOver1000();

    }

    private void cleanNumbersOver1000() {
        for (int i = 0; i < this.numbersReadyForOperation.length; i++) {
            if (this.numbersReadyForOperation[i] > 1000) {
                this.numbersReadyForOperation[i] = 0;
            }
        }
    }

    private String lookForNegativeNumbers() {
        String result = "";
        for (int number : this.numbersReadyForOperation) {
            if (number < 0) result += "," + number;
        }
        return result;
    }

    private String separateCustomSeparatorFromNumbericData(String numbersRow) {
        String[] dataPreProcessed = numbersRow.split(LIMIT_FOR_CUSTOM_SEPARATORS_PATTERN, 2);
        String newCustomSeparator = dataPreProcessed[0].substring(2);

        assignNewSeparator(newCustomSeparator);

        return dataPreProcessed[1];
    }

    private void assignNewSeparator(String newCustomSeparator) {
        if (alphanumericSeparatorDetected(newCustomSeparator)) {
            this.separators += "|(\\" + newCustomSeparator + ")";
        } else {
            this.separators += "|(" + newCustomSeparator + ")";
        }
    }

    private boolean alphanumericSeparatorDetected(String newCustomSeparator) {
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        return p.matcher(newCustomSeparator).find();
    }

    private String separateMultipleCustomSeparatorFromNumbericData(String numbersRow) {
        String[] dataPreProcessed = numbersRow.split(LIMIT_FOR_CUSTOM_SEPARATORS_PATTERN, 2);
        String newCustomSeparators = dataPreProcessed[0].substring(3, dataPreProcessed[0].length() - 1);

        if (alphanumericSeparatorDetected(newCustomSeparators)) {
            String singleSeparator = newCustomSeparators.split("")[0];
            String aux = "";
            for (int i = 0; i < newCustomSeparators.length(); i++) {
                aux += "\\" + singleSeparator;
            }
            this.separators += "|(" + aux + ")";
        } else {
            this.separators += "|(" + newCustomSeparators + ")";
        }

        System.out.println(this.separators);
        return dataPreProcessed[1];
    }

    private boolean isCustomSeparatorCodeDetected(String numbersRow) {
        return numbersRow.startsWith(CUSTOM_SEPARTOR_PATTERN_CODE) && !numbersRow.startsWith(MULTIPLE_CUSTOM_SEPARATOR_CODE);
    }

    private boolean isMultipleCustomSeparatorCodeDetected(String numbersRow) {
        return numbersRow.startsWith(CUSTOM_SEPARTOR_PATTERN_CODE) && numbersRow.startsWith(MULTIPLE_CUSTOM_SEPARATOR_CODE);
    }

    private boolean isOnlyOneNumberProvided(int[] numbers) {
        return numbers.length == 1;
    }

    private boolean isNoNumberProvided() {
        return this.numbersToBeProcessed.isEmpty();
    }


}
