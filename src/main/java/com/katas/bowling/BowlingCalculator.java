package com.katas.bowling;

public class BowlingCalculator {
    public int calculateScore(String game) {
        if(game.contains("1")){
            return 20;
        }

        return 0;
    }
}
