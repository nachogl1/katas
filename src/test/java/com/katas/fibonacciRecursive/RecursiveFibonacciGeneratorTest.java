package com.katas.fibonacciRecursive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursiveFibonacciGeneratorTest {

    RecursiveFibonacciGenerator recursiveFibonacciGenerator;

    @BeforeEach
    void setUp() {
        recursiveFibonacciGenerator = new RecursiveFibonacciGenerator();

    }

    @Test
    void return_0_for_first_element() {

        int result = recursiveFibonacciGenerator.generateFromElement(0);

        assertThat(result).isEqualTo(0);
    }


    @Test
    void return_1_for_2_element() {
        int result = recursiveFibonacciGenerator.generateFromElement(1);

        assertThat(result).isEqualTo(1);

    }

    @Test
    void return_1_for_3_element() {
        int result = recursiveFibonacciGenerator.generateFromElement(2);

        assertThat(result).isEqualTo(1);

    }

    @Test
    void return_2_for_4_element() {
        int result = recursiveFibonacciGenerator.generateFromElement(3);

        assertThat(result).isEqualTo(2);
    }
    @Test
    void return_8_for_7_element() {
        int result = recursiveFibonacciGenerator.generateFromElement(6);

        assertThat(result).isEqualTo(8);
    }
}
