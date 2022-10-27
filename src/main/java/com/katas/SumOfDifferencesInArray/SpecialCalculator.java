package com.katas.SumOfDifferencesInArray;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

public class SpecialCalculator {
    public static int process(int[] inputArray) {
        int[] orderedArray = orderDescending(inputArray);
        return getSumOfConsecutivePairs(orderedArray);
    }

    private static int getSumOfConsecutivePairs(int[] orderedArray) {
        int result = 0;

        try {
            for (int i = 0; i < orderedArray.length; i++) {
                result = result + (orderedArray[i] - orderedArray[i + 1]);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            //buah
        }

        return result;
    }

    private static int[] orderDescending(int[] inputArray) {
        Integer[] boxedArray = ArrayUtils.toObject(inputArray);

        Arrays.sort(boxedArray, Collections.reverseOrder());

        return ArrayUtils.toPrimitive(boxedArray);
    }
}
