package com.katas.fibonacciGeneratorTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.katas.FibonacciGenerator.FibonacciGenerator;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class FibonacciShould {

	@Test
	public void return_0_for_first_element() {
		FibonacciGenerator fiboGenerator = new FibonacciGenerator();

		int result = fiboGenerator.from(1);

		assertThat(result).isEqualTo(0);
	}

	@Test
	public void return_1_for_second_element() {
		FibonacciGenerator fiboGenerator = new FibonacciGenerator();

		int result = fiboGenerator.from(2);

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void return_1_for_third_element() {
		FibonacciGenerator fiboGenerator = new FibonacciGenerator();

		int result = fiboGenerator.from(3);

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void return_2_for_4th_element() {
		FibonacciGenerator fiboGenerator = new FibonacciGenerator();

		int result = fiboGenerator.from(4);

		assertThat(result).isEqualTo(2);
	}

	@Test
	public void return_3_for_5th_element() {
		FibonacciGenerator fiboGenerator = new FibonacciGenerator();

		int result = fiboGenerator.from(5);

		assertThat(result).isEqualTo(3);
	}

	@ParameterizedTest
	@CsvSource({ "0,1", "1,2", "1,3", "2,4", "3,5", "5,6", "8,7", "13,8", "21,9", "34,10" })
	public void return_correct_result_for_given_element(int expectedResult, int from) {
		FibonacciGenerator fiboGenerator = new FibonacciGenerator();

		int result = fiboGenerator.from(from);

		assertThat(result).isEqualTo(expectedResult);
	}

}
