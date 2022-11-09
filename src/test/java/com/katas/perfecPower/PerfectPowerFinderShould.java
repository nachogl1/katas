package com.katas.perfecPower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectPowerFinderShould {

    @Test
    void given9_WhenInput_ThenReturn3And3() {
        PerfectPowerFinder finder = new PerfectPowerFinder();
        int[] result = finder.returnElementsOfPerfectPower(9);
        assertArrayEquals(new int[]{3, 3}, result);
    }

    @Test
    void given81_WhenInput_ThenReturn9And9() {
        PerfectPowerFinder finder = new PerfectPowerFinder();
        int[] result = finder.returnElementsOfPerfectPower(81);
        assertArrayEquals(new int[]{9, 9}, result);
    }


    @Test
    void given4_WhenInput_ThenReturn2And2() {
        PerfectPowerFinder finder = new PerfectPowerFinder();
        int[] result = finder.returnElementsOfPerfectPower(4);
        assertArrayEquals(new int[]{2, 2}, result);
    }


    @Test
    void given3_WhenInput_ThenReturnNull() {
        PerfectPowerFinder finder = new PerfectPowerFinder();
        int[] result = finder.returnElementsOfPerfectPower(3);
        assertEquals(null, result);
    }

}
