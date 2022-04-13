package com.katas.shortcutGolft;

public class FizzBuzzSG {
    public String generate(int from) {
        if (from % 15 == 0) {
            return "FizzBuzz";
        }
        if (from % 3 == 0) {
            return "Fizz";
        }
        if (from % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(from);
    }
}
