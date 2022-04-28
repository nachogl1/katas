package com.katas.stringCalculatorTests;

import com.katas.stringCalculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();

    }

    @Test
    void return_0_if_empty_strring_passed() {
        String rawData = "";
        stringCalculator.initCalculator(rawData);
        int result = stringCalculator.add();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void return_sum_of_two_numbers() {
        String rawData = "1,1";
        stringCalculator.initCalculator(rawData);
        int result = stringCalculator.add();
        assertThat(result).isEqualTo(2);
    }

    @Test
    void return_argument_if_only_one_argument() {
        String rawData = "1";
        stringCalculator.initCalculator(rawData);
        int result = stringCalculator.add();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void return_sum_of_variable_range_of_numbers() {
        String rawData = "1,2,3,4,5,6";
        stringCalculator.initCalculator(rawData);

        int result = stringCalculator.add();
        assertThat(result).isEqualTo(21);
    }

    @Test
    void return_sum_of_variable_range_of_numbers_with_different_separators() {
        String rawData = "1,2\n3,4,5\n6";
        stringCalculator.initCalculator(rawData);

        int result = stringCalculator.add();
        assertThat(result).isEqualTo(21);
    }

    @Test
    void return_sum_of_variable_range_of_numbers_with_non_alphanumeric_custom_separator() {
        String rawData = "//...\n1...2";
        stringCalculator.initCalculator(rawData);

        int result = stringCalculator.add();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void return_sum_of_variable_range_of_numbers_with_alphanumeric_custom_separator() {
        String rawData = "//mmm\n1mmm2";
        stringCalculator.initCalculator(rawData);

        int result = stringCalculator.add();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void return_exception_when_negative_number_detected() {
        String rawData = "1,-2,-3";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.initCalculator(rawData);
        });
    }

    @Test
    void ignore_numbers_bigger_than_1000() {
        String rawData = "//miau\n1001miau20";
        stringCalculator.initCalculator(rawData);

        int result = stringCalculator.add();
        assertThat(result).isEqualTo(20);
    }

    @Test
    void return_sum_of_variable_range_of_numbers_with_non_alphanumeric_custom_multiple_separator() {
        String rawData = "//[...]\n1...3";
        stringCalculator.initCalculator(rawData);

        int result = stringCalculator.add();
        assertThat(result).isEqualTo(4);
    }

    @Test
    void return_sum_of_variable_range_of_numbers_with_alphanumeric_custom_multiple_separator() {
        String rawData = "//[mmm]\n1mmm3";
        stringCalculator.initCalculator(rawData);

        int result = stringCalculator.add();
        assertThat(result).isEqualTo(4);
    }
}
