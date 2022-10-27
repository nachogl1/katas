package com.katas.SumOfDifferencesInArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialCalculatorShould {
    @Test
    void sumPairsInDescendingOrder() {
        int[] inputArray = {2, 1, 10, 11};

        int result = SpecialCalculator.process(inputArray);

        assertEquals(10, result);
    }

    @Test
    void retur0If1Element() {
        int[] inputArray = {2};

        int result = SpecialCalculator.process(inputArray);

        assertEquals(0, result);
    }

    @Test
    void return0IfEmpty() {
        int[] inputArray = {};

        int result = SpecialCalculator.process(inputArray);

        assertEquals(0, result);
    }

}
