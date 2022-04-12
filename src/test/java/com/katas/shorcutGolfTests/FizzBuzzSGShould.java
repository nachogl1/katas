package com.katas.shorcutGolfTests;

import com.katas.fizzbuzz.FizzBuzzSG;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzSGShould {

    private FizzBuzzSG fizzbuzzSG;

    @BeforeEach
    void setUp() {
        fizzbuzzSG = new FizzBuzzSG();
    }

    @Test
    void return_1_when_1_was_passed() {

        String result = fizzbuzzSG.generate(1);

        assertThat(result).isEqualTo("1");
    }

    @Test
    void return_fizz_when_3_is_passed() {
        String result = fizzbuzzSG.generate(3);
        String expected = "Fizz";

        assertThat(result).isEqualTo(expected);
    }

    @Test
    void return_Buzz_when_5_is_passed() {
        String result = fizzbuzzSG.generate(5);
        String expectedResult = "Buzz";

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({"3", "6", "9", "12", "21"})
    void return_Fizz_when_divisible_by_3(int source) {
        String result = fizzbuzzSG.generate(source);

        assertThat(result).isEqualTo("Fizz");
    }

    @ParameterizedTest
    @CsvSource({"5", "10", "20"})
    void return_Buzz_when_divisible_by_5(int source) {

        String result = fizzbuzzSG.generate(source);

        assertThat(result).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @CsvSource({"15", "30", "45"})
    void return_FizzBuzz_when_divisible_by_15(int source) {
        String result = fizzbuzzSG.generate(source);
        String expected = "FizzBuzz";
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1", "2", "4", "41"})
    void return_the_number_if_not_divisible_by_3_nor_5(int source) {
        String result = fizzbuzzSG.generate(source);
        assertThat(result).isEqualTo(String.valueOf(source));
    }
}
