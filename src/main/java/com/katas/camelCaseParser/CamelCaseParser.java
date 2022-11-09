package com.katas.camelCaseParser;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCaseParser {
    public String parse(String input) {
        StringBuilder result = new StringBuilder();
        String[] elements = input.split("_");
        String intactFirstWord = elements[0];

        result.append(intactFirstWord);
        result.append(Arrays
                .stream(elements)
                .skip(1)
//                .map(e-> {return WordUtils.capitalizeFully(e);})
                .map(e -> {
                    return titleCase(e);
                })
                .collect(Collectors.joining()));


        return result.toString();
    }

    private String titleCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}
