package com.katas.textProcessor;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.katas.textProcessor.MapUtils.sortEntryByDescendingValue;

public class ProcessorSummary {
    public static final String SUMMARY_HEADER = "Those are the top 10 words used:\n\n";
    private List<String> words;

    public ProcessorSummary(List<String> words) {
        this.words = words;
    }

    public String getSummary() {
        StringBuilder contentOfSummary = getWordSummaryContent();
        String footer = computeSummaryFooterNote();
        return returnFormattedSummary(contentOfSummary, footer);
    }

    private StringBuilder getWordSummaryContent() {
        Map<String, Integer> wordFrequencies = computeWordFrequencyMap();
        Map<String, Integer> sortedWordFrequencies = sortEntryByDescendingValue(wordFrequencies);
        StringBuilder contentOfSummary = buildContentSummaryFromSortedMap(sortedWordFrequencies);

        return contentOfSummary;
    }

    private Map<String, Integer> computeWordFrequencyMap() {
        Map<String, Integer> wordFrequencies = new TreeMap<>();

        this.words.forEach(word -> {
            wordFrequencies.compute(word, (k, v) -> (v == null) ? 1 : v + 1);
        });
        return wordFrequencies;
    }

    private StringBuilder buildContentSummaryFromSortedMap(Map<String, Integer> sortedWordFrequencies) {
        StringBuilder contentOfSummary = new StringBuilder();
        int[] counter = {1};

        sortedWordFrequencies.entrySet().stream().limit(10).forEach((entry) -> {
            contentOfSummary.append(counter[0]++ + ". " + entry.getKey() + "\n");
        });
        return contentOfSummary;
    }


    private String computeSummaryFooterNote() {
        return "\nThe text has in total " + this.words.size() + " words\n";
    }

    private String returnFormattedSummary(StringBuilder contentOfSummary, String footer) {
        return new StringBuilder().append(SUMMARY_HEADER).append(contentOfSummary.toString()).append(footer).toString();
    }
}
