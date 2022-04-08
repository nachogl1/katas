package com.katas.AnagramsGenerator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AnagramsGeneratorV1 {

    public String rotateString(String word, int numberRotations) {
        return StringUtils.rotate(word, numberRotations);
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
