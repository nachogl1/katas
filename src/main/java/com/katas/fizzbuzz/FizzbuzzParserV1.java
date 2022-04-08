package com.katas.fizzbuzz;

public class FizzbuzzParserV1 {

	public Object parse(int i) {
		if (i % 15 == 0) {
			return "FizzBuzz";
		}
		if (i % 3 == 0) {
			return "Fizz";
		}
		if (i % 5 == 0) {
			return "Buzz";
		}
		return 1;
	}

}
