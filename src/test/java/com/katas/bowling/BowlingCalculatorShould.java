package com.katas.bowling;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BowlingCalculatorShould {

    @Test
    void calculate_score_for_gutter_game() {
        BowlingCalculator bowlingCalculator = new BowlingCalculator();
        int result = bowlingCalculator.calculateScore("--|--|--|--|--|--|--|--|--|--||");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculate_score_for_1_pin_per_roll() {
        BowlingCalculator bowlingCalculator = new BowlingCalculator();
        int result = bowlingCalculator.calculateScore("11|11|11|11|11|11|11|11|11|11||");
        assertThat(result).isEqualTo(20);

    }


}
