package com.katas.LeapYearChecker;

public class LeapYearCheckerV1 {

	public boolean verify(int year) throws Exception {
		if (year % 4 == 0 && year % 100 == 0 && year % 400 != 0) {
			return false;
		}

		if (year % 400 == 0) {
			return true;
		}

		if (year % 4 == 0) {
			return true;
		}

		if (year % 4 != 0) {
			return false;
		}

		throw new Exception("Case not implemented");

	}

}
