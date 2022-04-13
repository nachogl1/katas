package com.katas.shorcutGolfTests;

import com.katas.shortcutGolft.StatsCalculatorSG;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StatsCalculatorSGShould {

    private StatsCalculatorSG statsCalculatorSG;
    private int[] samples;

    @BeforeEach
    void setUp() {
        statsCalculatorSG = new StatsCalculatorSG();
        samples = new int[]{1, 2, 3, 4, 5, -4,-100,170,27,32};
    }

    @Test
    void return_length_of_list() {
        String result = statsCalculatorSG.getLengthOf(samples);
        assertThat(result).isEqualTo("10");
    }

    @Test
    void return_highest_number_in_samples() {
        String result = statsCalculatorSG.returnMaxOf(samples);
        assertThat(result).isEqualTo("170");
    }

    @Test
    void return_empty_when_looking_max_in_empty_list() {
        String result = statsCalculatorSG.returnMaxOf(new int[]{});
        assertThat(result).isEqualTo("Empty");
    }

    @Test
    void return_empty_when_looking_mim_in_empty_list() {
        String result = statsCalculatorSG.returnMinOf(new int[]{});
        assertThat(result).isEqualTo("Empty");
    }

    @Test
    void return_lowest_number_in_samples() {
        String result = statsCalculatorSG.returnMinOf(samples);
        assertThat(result).isEqualTo("-100");
    }

    @Test
    void return_3_as_average_in_samples() {
        String result = statsCalculatorSG.averageOf(samples);
        assertThat(result).isEqualTo("14");
    }

    @Test
    void print_stats() {
        String result = statsCalculatorSG.generateStats(samples);
        String expected = ""
                + "Max: " + 170
                + "/n"
                + "Min: " + -100
                + "/n"
                + "Length: " + 10
                + "/n"
                + "Average : " + 14;
        assertThat(result).isEqualTo(expected);
    }
}
