package com.katas.bowlingTests;

import static java.lang.Integer.parseInt;

public class BowlingCalculator {

    public static final String MISS_SYMBOL = "-";
    public static final String FRAME_SEPARATOR = "\\|";
    public static final int FRAMES_PER_GAME = 10;
    public static final int PINS_PER_FRAME = 10;

    public int calculateScore(String game) {
        int score = 0;
        String[] rolls = getRolls(game);
        int currentRoll = 0;

        for (int frame = 0; frame < FRAMES_PER_GAME; frame++) {
            String firstRoll = rolls[currentRoll];
            String secondRoll = rolls[currentRoll + 1];
            
            if (isSpare(secondRoll)) {
                score += PINS_PER_FRAME + calculateRollScore(rolls[currentRoll + 2]);
                currentRoll += 2;
            } else {
                score += calculateRollScore(firstRoll) + calculateRollScore(secondRoll);
                currentRoll += 2;
            }
        }

        return score;
    }

    private boolean isSpare(String secondRoll) {
        return secondRoll.equals("/");
    }

    private String[] getRolls(String game) {
        String framelessGame = game.replaceAll(FRAME_SEPARATOR, "");
        return framelessGame.split("");
    }

    private int calculateRollScore(String roll) {
        if (roll.equals(MISS_SYMBOL)) return 0;

        return parseInt(roll);
    }


}
