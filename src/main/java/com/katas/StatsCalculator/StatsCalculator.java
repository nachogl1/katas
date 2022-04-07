package com.katas.StatsCalculator;

import java.util.Arrays;

public class StatsCalculator {

	public int getLengthOf(int[] arrayOfNumbers) {
		return arrayOfNumbers.length;
	}

	public int getLowestOf(int[] arrayOfNumbers) {
		return Arrays.stream(arrayOfNumbers).min().orElseThrow();
	}

	public int getHighestOf(int[] arrayOfNumbers) {
		return Arrays.stream(arrayOfNumbers).max().orElseThrow();
	}

	public double getAverageOf(int[] arrayOfNumbers) {
		return Arrays.stream(arrayOfNumbers).average().orElseThrow();
	}

}
