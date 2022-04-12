package com.katas.shorcutGolfTests;

import com.katas.LeapYearChecker.LeapYearSGChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapYearSGCheckerShould {

    private LeapYearSGChecker leapYeagSG;

    @BeforeEach
    void setUp() {
        leapYeagSG = new LeapYearSGChecker();
    }

    @Test
    void return_true_for_1996() {
        boolean result = leapYeagSG.isLeapYear(1996);

        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"4", "8", "12", "1996", "1600"})
    void return_true_if_year_divisible_by_4(int source) {
        //In a normal scenario I would have my list of years for samples created by me, I took this list from other kata
        boolean result = leapYeagSG.isLeapYear(source);
        assertThat(result).isEqualTo(true);
    }


    @ParameterizedTest
    @CsvSource({"400", "1600", "1200", "800", "2400"})
    void return_true_if_year_divisible_by_400(int source) {
        //In a normal scenario I would have my list of years for samples created by me, I took this list from other kata
        boolean result = leapYeagSG.isLeapYear(source);
        assertThat(result).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"1997", "1995", "2001", "3001"})
    void return_false_if_year_not_divisible_by_4(int source) {
        //In a normal scenario I would have my list of years for samples created by me, I took this list from other kata
        boolean result = leapYeagSG.isLeapYear(source);
        assertThat(result).isEqualTo(false);
    }


    @ParameterizedTest
    @CsvSource({ "1800", "100" })
    void return_false_if_year_divisible_by_4_and_100_but_not_400(int source) {
        boolean result = leapYeagSG.isLeapYear(source);
        assertThat(result).isEqualTo(false);
    }
}
