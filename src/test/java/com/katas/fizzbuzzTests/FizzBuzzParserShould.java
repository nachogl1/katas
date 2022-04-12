package com.katas.fizzbuzzTests;

import com.katas.fizzbuzz.FizzbuzzParserV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
class FizzBuzzParserV1Should {

    private FizzbuzzParserV1 fizzbuzzParser;

    @BeforeEach
    void setUp() {
        fizzbuzzParser = new FizzbuzzParserV1();
    }

    @Test
    public void return_1_if_parsing_1() {

        assertThat(fizzbuzzParser.parse(1)).isEqualTo(1);
    }

    @Test
    public void return_Fizz_if_parsing_3() {


        assertThat(fizzbuzzParser.parse(3)).isEqualTo("Fizz");
    }

    @Test
    public void return_Buzz_if_parsing_5() {


        assertThat(fizzbuzzParser.parse(5)).isEqualTo("Buzz");
    }

    @ParameterizedTest
    @CsvSource({"3", "6", "9", "12", "15"})
    public void return_result_that_contains_Fizz_if_divisible_by_3(int i) {


        String result = fizzbuzzParser.parse(i).toString();

        assertThat(result).contains("Fizz");
    }

    @ParameterizedTest
    @CsvSource({"5", "10", "15"})
    public void return_result_that_contains_Buzz_if_divisible_by_5(int i) {


        String result = fizzbuzzParser.parse(i).toString();

        assertThat(result).contains("Buzz");
    }

    @ParameterizedTest
    @CsvSource({"15", "30", "45"})
    public void return_result_that_contains_FizzBuzz_if_divisible_by_15(int i) {


        String result = fizzbuzzParser.parse(i).toString();

        assertThat(result).contains("FizzBuzz");
    }

}
