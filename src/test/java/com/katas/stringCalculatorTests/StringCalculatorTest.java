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
    void returnNumebrIfOneNumberPassed() {
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
        int result = calculator.sum("1,1,1,1,1,1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnSumOfNumberWithCommaAndNewlineAsSeparators() {
        int result = calculator.sum("1,1,1\n1,1\n1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnSumOfNumberWithNonAlphanumericCustomSeparatorAsSeparators() {
        int result = calculator.sum("//@\n10,1@1\n1,1\n1");
        assertThat(result).isEqualTo(15);
    }

    @Test
    void returnSumOfNumberWithNonAlphanumericCustomSeparator2AsSeparators() {
        int result = calculator.sum("//\"\n1,1,1\n1\"1\n1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnSumOfNumberWithAlphanumericCustomSeparatorAsSeparators() {
        int result = calculator.sum("//miau\n1,1miau1\n1,1\n1");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void returnCorectSumByRemovingNumbersBiggerThan1000() {
        int result = calculator.sum("//miau\n1001,1miau1\n1,1\n1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnSumOfNumberWithLongNonAlphanumericCustomSeparator2AsSeparators() {
        int result = calculator.sum("//[\'\']\n1001,1,1\n1,1\'\'1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnSumOfNumberWithLongAlphanumericCustomSeparator2AsSeparators() {
        int result = calculator.sum("//[miaumiau]\n1001,1miaumiau1\n1,1miaumiau1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnSumOfNumberWithSingleNonAlphanumericAndSingleAlphanumericCustomSeparator2AsSeparators() {
        int result = calculator.sum("//[\'][miau]\n1001,1,1\'1,1miau1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnSumOfNumberWithMultipleNonAlphanumericAndMultipleAlphanumericCustomSeparator2AsSeparators() {
        int result = calculator.sum("//[\'\'][miaumiau]\n1001,1,1\'\'1,1miaumiau1");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void returnNonNegativeNumbersExceptionIfNegativeNumberDetected() {
        assertThrows(NotNegativeNumbersAllowedException.class, () ->
        {
            int result = calculator.sum("//miau\n1,1miau-1\n1,1\n1");
        });
    }


}
