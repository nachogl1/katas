package com.katas.StopgninnipSMysdroW;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialParserShould {

    @ParameterizedTest
    @CsvSource({"Hey fellow warriors,Hey wollef sroirraw", "This is a test ,This is a test", "This is another test,This is rehtona test"})
    void reverseAnyWordWith5OrMoreLetters(String input, String expectedOutput) {
        String result = SpecialParser.parse(input);
        assertEquals(expectedOutput, result);
    }
}
