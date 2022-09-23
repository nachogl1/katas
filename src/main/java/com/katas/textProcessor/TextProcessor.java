package com.katas.textProcessor;

import java.util.*;

public class TextProcessor {

    public static final String SUMMARY_HEADER = "Those are the top 10 words used:\n\n";

    public String analyse(String testInputText) {
        String lowercaseInput = testInputText.toLowerCase();
        String lowercaseNoSymbolsInput = lowercaseInput.replaceAll("[-+.^:,]","");

        List<String> words = splitWordsIntoList(lowercaseNoSymbolsInput);

        StringBuilder contentOfSummary = getWordSummaryContent(words);
        String footer = computeSummaryFooterNote(words);
        String resultSummary = appendSummarySections(contentOfSummary, footer);

        return resultSummary;
    }

    private String appendSummarySections(StringBuilder contentOfSummary, String footer) {
        return new StringBuilder()
                .append(SUMMARY_HEADER)
                .append(contentOfSummary.toString())
                .append(footer)
                .toString();
    }

    private StringBuilder getWordSummaryContent(List<String> words) {
        Map<String, Integer> wordFrequencies = new TreeMap<>();

        words.forEach(word -> {
            wordFrequencies.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
        });

        Map<String, Integer> sortedWordFrequencies  = sortByValues(wordFrequencies);

        StringBuilder contentOfSummary = new StringBuilder();
        int[] counter = {1};

        sortedWordFrequencies.entrySet().stream().limit(10).forEach((entry) -> {
            contentOfSummary.append(counter[0]++ + ". " + entry.getKey() + "\n");
        });


        return contentOfSummary;
    }

    private static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator =  new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare = map.get(k2).compareTo(map.get(k1));
                if (compare == 0) return 1;
                else return compare;
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }

    private String computeSummaryFooterNote(List<String> words) {
        return "\nThe text has in total " + words.size() + " words\n";
    }

    private List<String> splitWordsIntoList(String testInputText) {
        List<String> words = Arrays.asList(testInputText.split(" "));
        return words;
    }

}
