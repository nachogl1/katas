package com.katas.bowlingTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingCalculatorShould {

    private BowlingCalculator bowlingCalculator;

    @BeforeEach
    void setUp() {
        bowlingCalculator = new BowlingCalculator();
    }

    @Test
    void calculate_score_for_gutter_game() {
        int result = bowlingCalculator.calculateScore("--|--|--|--|--|--|--|--|--|--||");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculate_score_for_1_pin_per_roll() {
        int result = bowlingCalculator.calculateScore("11|11|11|11|11|11|11|11|11|11||");
        assertThat(result).isEqualTo(20);
    }

    @Test
    void calculate_score_for_2_pins_per_roll() {
        int result = bowlingCalculator.calculateScore("22|22|22|22|22|22|22|22|22|22||");
        assertThat(result).isEqualTo(40);
    }

    @Test
    void calculate_score_for_spare() {
        int result = bowlingCalculator.calculateScore("2/|22|22|22|22|22|22|22|22|22||");
        assertThat(result).isEqualTo(48);

    }

}
