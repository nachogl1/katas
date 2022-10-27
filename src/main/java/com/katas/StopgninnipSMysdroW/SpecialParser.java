package com.katas.StopgninnipSMysdroW;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SpecialParser {
    public static String parse(String input) {
        String[] elements = input.split(" ");

        return Arrays.stream(elements).map(e -> {
            if (e.length() >= 5) return StringUtils.reverse(e);
            return e;
        }).collect(Collectors.joining(" "));
    }
}
