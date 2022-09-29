package com.katas.textProcessor;

import java.util.Arrays;
import java.util.List;

public class TextProcessor {
    public static final String SYMBOLS = "[-+.^:,]";

    public String analyse(String testInputText) {
        String processedText = preProcessInputText(testInputText);

        List<String> words = splitWordsIntoList(processedText);

        String resultSummary = computeResultSummary(words);

        return resultSummary;
    }

    private String preProcessInputText(String testInputText) {
        String lowercaseInput = testInputText.toLowerCase();
        String lowercaseNoSymbolsInput = lowercaseInput.replaceAll(SYMBOLS, "");
        return lowercaseNoSymbolsInput;
    }

    private List<String> splitWordsIntoList(String testInputText) {
        String[] words = testInputText.split(" ");
        return Arrays.asList(words);
    }

    private String computeResultSummary(List<String> words) {
        ProcessorSummary summary = new ProcessorSummary(words);
        return summary.getSummary();
    }

}
