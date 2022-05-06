package com.katas.stringCalculatorTests;

import com.katas.stringCalculator.NotNegativeNumbersAllowedException;
import com.katas.stringCalculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void return0IfNoNumberPassed() {
        int result = calculator.sum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void returnNumberIfOnlyOneArgument() {
        int result = calculator.sum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void returnSumOfTwoNumbers() {
        int result = calculator.sum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void returnSumOfMultipleNumbers() {
        int result = calculator.sum("1,,,1,1,1,1,1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnSumOfNumberWithCommaAndNewlineAsSeparators() {
        int result = calculator.sum("1,1,1\n1,1\n1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnSumOfNumberWithNonAlphanumericCustomSeparator() {
        int result = calculator.sum("//@\n10,1@1\n1,1\n1");
        assertThat(result).isEqualTo(15);
    }

    @Test
    void returnSumOfNumberWithAnotherNonAlphanumericCustomSeparator() {
        int result = calculator.sum("//\"\n1,1,1\n1\"1\n1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnSumOfNumberWithAlphanumericCustomSeparator() {
        int result = calculator.sum("//miau1\n1,1miau11\n1,1\n1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnCorrectSumByRemovingNumbersBiggerThan1000() {
        int result = calculator.sum("//miau\n1001,1miau1\n1,1\n1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnSumOfNumberWithLongNonAlphanumericCustomSeparator() {
        int result = calculator.sum("//[\'\'\'\'\'\']\n1001,1,1\n1,1\'\'\'\'\'\'1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnSumOfNumberWithLongAlphanumericCustomSeparator() {
        int result = calculator.sum("//[miaumiaumiaumiau]\n1001,1miaumiaumiaumiau1\n1,1miaumiaumiaumiau1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnSumOfNumberWithSingleNonAlphanumericAndSingleAlphanumericCustomSeparator() {
        int result = calculator.sum("//[\'][miau]\n1001,1,1\'1,1miau1,1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnSumOfNumberWithMultipleNonAlphanumericAndMultipleAlphanumericCustomSeparator() {
        int result = calculator.sum("//[\'\'][miaumiaumiaumiau]\n1001,1,1\'\'\'\'1,1miaumiaumiaumiau1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnNonNegativeNumbersExceptionIfNegativeNumberDetected() {
        assertThrows(NotNegativeNumbersAllowedException.class, () ->
        {
            int result = calculator.sum("//[\'\'][miaumiau]\n1001,1,1\'\'-11,1miaumiau1");
        });
    }

}
