package com.katas.FibonacciGenerator;

public class FibonacciGeneratorV1 {

	public int from(int from) {

		if (from == 1) {
			return 0;
		}
		if (from == 2) {
			return 1;
		}
		int buffer = 0;
		int lastLast = 0;
		int last = 1;

		for (int i = 2; i < from; i++) {
			buffer = last + lastLast;
			lastLast = last;
			last = buffer;
		}

		return buffer;
	}

}
