package com.katas.bowling;

import static com.katas.bowling.BowlingGameSymbol.*;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class BowlingCalculator {

    public static final int FRAMES_PER_GAME = 10;
    public static final int PINS_PER_FRAME = 10;

    public int calculateScore(String game) {
        int score = 0;
        String[] rolls = getRolls(game);
        int currentRoll = 0;

        for (int frame = 0; frame < FRAMES_PER_GAME; frame++) {
            String firstRoll = rolls[currentRoll];
            String nextRoll = rolls[currentRoll + 1];

            if (isSpare(nextRoll)) {
                score += PINS_PER_FRAME + calculateRollScore(rolls[currentRoll + 2]);
                currentRoll += 2;
            } else if (isStrike(firstRoll)) {
                score += PINS_PER_FRAME + calculateRollScore(nextRoll) + calculateRollScore(rolls[currentRoll + 2]);
                currentRoll += 1;
            } else {
                score += calculateRollScore(firstRoll) + calculateRollScore(nextRoll);
                currentRoll += 2;
            }
        }

        return score;
    }



    private boolean isStrike(String roll) {
        return roll.equals(STRIKE.getSymbol());
    }

    private boolean isSpare(String roll) {
        return roll.equals(SPARE.getSymbol());
    }

    private String[] getRolls(String game) {
        String frameSeparatorRegex = format("\\%s", FRAME.getSymbol());
        String framelessGame = game.replaceAll(frameSeparatorRegex, "");
        return framelessGame.split("");
    }

    private int calculateRollScore(String roll) {
        if (isMissed(roll)) return 0;

        if (isStrike(roll)) return PINS_PER_FRAME;

        return parseInt(roll);
    }

    private boolean isMissed(String roll) {
        return roll.equals(MISS.getSymbol());
    }

}
