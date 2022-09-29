package com.katas.booleanCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooleanCalculatorShould {

    private BooleanCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new BooleanCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "'TRUE',true",
            "'FALSE',false",
            "'NOT TRUE',false",
            "'NOT FALSE',true",
            "'NOT NOT FALSE',false",
            "'TRUE AND TRUE',true",
            "'TRUE AND FALSE',false",
            "'FALSE AND FALSE',false",
            "'TRUE AND TRUE AND FALSE',false",
            "'TRUE OR TRUE',true",
            "'FALSE OR FALSE',false",
            "'TRUE OR FALSE',true",
            "'TRUE OR TRUE OR TRUE AND FALSE',true",
            "'TRUE OR FALSE AND NOT FALSE',true",
            "'NOT TRUE AND TRUE',false",
            "'NOT TRUE AND FALSE',false",
            "'NOT FALSE AND FALSE',false",
            "'NOT FALSE AND TRUE',true",
            "'(TRUE)',true",
            "'((TRUE))',true",
            "'(FALSE)',false",
            "'((FALSE))',false",
            "'(FALSE) OR TRUE',true",
            "'(FALSE AND FALSE)',false",
            "'(TRUE AND TRUE)',true",
            "'TRUE AND (TRUE)',true",
            "'TRUE AND NOT (NOT TRUE)',true",
            "'(NOT TRUE AND (((NOT TRUE))))',false",
    })
    void return_expected_value_for_input(String input, boolean expected) {
        assertEquals(expected, calculator.process(input));
    }
}
