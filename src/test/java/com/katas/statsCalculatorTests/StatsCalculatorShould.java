package com.katas.statsCalculatorTests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.katas.StatsCalculator.StatsCalculator;

@RunWith(SpringRunner.class)
public class StatsCalculatorShould {

	@Test
	public void return_1_as_length_of_1_element_array() {
		int[] arrayOfNumbers = { 1 };
		StatsCalculator statsCalculator = new StatsCalculator();

		int result = statsCalculator.getLengthOf(arrayOfNumbers);

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void return_4_as_length_of_4_element_array() {
		int[] arrayOfNumbers = { 1, 2, 3, 4 };
		StatsCalculator statsCalculator = new StatsCalculator();

		int result = statsCalculator.getLengthOf(arrayOfNumbers);

		assertThat(result).isEqualTo(4);
	}

	@Test
	public void return_10_as_length_of_10_element_array() {
		int[] arrayOfNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		StatsCalculator statsCalculator = new StatsCalculator();

		int result = statsCalculator.getLengthOf(arrayOfNumbers);

		assertThat(result).isEqualTo(10);
	}

	@Test
	public void return_2_as_lowest_in_8_and_2() {
		int[] arrayOfNumbers = { 2, 8 };
		StatsCalculator statsCalculator = new StatsCalculator();

		int result = statsCalculator.getLowestOf(arrayOfNumbers);

		assertThat(result).isEqualTo(2);
	}

	@Test
	public void return_1_as_lowest_in_the_given_array() {
		int[] arrayOfNumbers = { 2, 8, 1, 90 };
		StatsCalculator statsCalculator = new StatsCalculator();

		int result = statsCalculator.getLowestOf(arrayOfNumbers);

		assertThat(result).isEqualTo(1);
	}

	@Test
	public void return_minus_2_as_lowest_in_the_given_array() {
		int[] arrayOfNumbers = { 6, 9, 15, -2, 92, 11 };
		StatsCalculator statsCalculator = new StatsCalculator();

		int result = statsCalculator.getLowestOf(arrayOfNumbers);

		assertThat(result).isEqualTo(-2);
	}

	@Test
	public void return_100_as_highest_in_the_given_array() {
		int[] arrayOfNumbers = { 2, 8, 1, 90, 100 };
		StatsCalculator statsCalculator = new StatsCalculator();

		int result = statsCalculator.getHighestOf(arrayOfNumbers);

		assertThat(result).isEqualTo(100);
	}

	@Test
	public void return_92_as_highest_in_the_given_array() {
		int[] arrayOfNumbers = { 6, 9, 15, -2, 92, 11 };
		StatsCalculator statsCalculator = new StatsCalculator();

		int result = statsCalculator.getHighestOf(arrayOfNumbers);

		assertThat(result).isEqualTo(92);
	}

	@Test
	public void return_2_as_average_of_given_array() {
		int[] arrayOfNumbers = { 1, 2, 3 };
		StatsCalculator statsCalculator = new StatsCalculator();

		double result = statsCalculator.getAverageOf(arrayOfNumbers);

		assertThat(result).isEqualTo(2);
	}

	@Test
	public void return_stated_average_as_average_of_given_array() {
		int[] arrayOfNumbers = { 6, 9, 15, -2, 92, 11 };
		StatsCalculator statsCalculator = new StatsCalculator();

		double result = statsCalculator.getAverageOf(arrayOfNumbers);

		assertThat(result).isEqualTo(21.833333333333332);
	}

}