package com.katas.AnagramsGenerator;

import java.util.ArrayList;
import java.util.List;

public class AnagramsGeneratorV1 {

    public String rotateString(String word, int numberRotations) {

        if (numberRotations > 0) {
            word = processRightRotation(word, numberRotations);
        }

        if (numberRotations < 0) {
            word = processLeftRotation(word, numberRotations);
        }

        return word;
    }

    private String processLeftRotation(String word, int numberRotations) {
        numberRotations = numberRotations * (-1);

        while (numberRotations > 0) {
            word = word.substring(1) + word.substring(0, 1);
            numberRotations--;
        }
        return word;
    }

    private String processRightRotation(String word, int numberRotations) {
        while (numberRotations > 0) {
            word = word.substring(word.length() - 1) + word.substring(0, word.length() - 1);
            numberRotations--;
        }
        return word;
    }

    public List<String> getAllPossibleRotationsForString(String str) {
        int count = 1;
        List<String> result = new ArrayList<String>();
        result.add(str);

        while (count < str.length()) {
            result.add(rotateString(str, count));
            count++;
        }

        return result;
    }


    public List<String> getAnagramsListFromString(String stringToProcess) throws Exception {
        throw new Exception("Method not finished");
    }
}
