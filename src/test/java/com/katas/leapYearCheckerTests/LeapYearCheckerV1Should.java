package com.katas.leapYearCheckerTests;

import com.katas.LeapYearChecker.LeapYearCheckerV1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
 class LeapYearCheckerV1Should {

	private LeapYearCheckerV1 leapYearChecker;

	@BeforeEach
	void setUp() {
		leapYearChecker = new LeapYearCheckerV1();
	}

	@Test
	public void return_true_if_1996_is_checked() throws Exception {

		boolean result = leapYearChecker.verify(1996);

		assertThat(result).isEqualTo(true);
	}

	@Test
	public void return_false_if_1997_is_checked() throws Exception {

		boolean result = leapYearChecker.verify(1997);

		assertThat(result).isEqualTo(false);
	}

	@Test
	public void return_true_if_1600_is_checked() throws Exception {

		boolean result = leapYearChecker.verify(1600);

		assertThat(result).isEqualTo(true);
	}

	@Test
	public void return_false_if_1800_is_checked() throws Exception {

		boolean result = leapYearChecker.verify(1800);

		assertThat(result).isEqualTo(false);
	}

	@ParameterizedTest
	@CsvSource({ "1997", "1995", "2001", "3001" })
	public void return_false_if_year_not_divisible_by_four(int year) throws Exception {

		boolean result = leapYearChecker.verify(year);

		assertThat(result).isEqualTo(false);
	}

	@ParameterizedTest
	@CsvSource({ "4", "8", "12", "1996", "1600" })
	public void return_true_if_year_divisible_by_four(int year) throws Exception {

		boolean result = leapYearChecker.verify(year);

		assertThat(result).isEqualTo(true);
	}

	@ParameterizedTest
	@CsvSource({ "400", "1600", "1200", "800", "2400" })
	public void return_true_if_year_divisible_by_400(int year) throws Exception {

		boolean result = leapYearChecker.verify(year);

		assertThat(result).isEqualTo(true);
	}

	@ParameterizedTest
	@CsvSource({ "1800", "100" })
	public void return_false_if_year_divisible_by_4_and_100_but_not_400(int year) throws Exception {

		boolean result = leapYearChecker.verify(year);

		assertThat(result).isEqualTo(false);
	}

}
