package com.katas.ticTacToeV2;

import java.util.Arrays;

import static com.katas.ticTacToeV2.TicTacToeV2Status.*;
import static com.katas.ticTacToeV2.TicTacToeV2Symbology.EMPTY;
import static com.katas.ticTacToeV2.TicTacToeV2Symbology.PLAYER_ONE;

public class TicTacToeRuleTable {

    private static final int GRID_SIDE = 3;

    public TicTacToeV2Status checkRules(TicTacToeV2Symbology[][] gameGrid, TicTacToeV2Symbology lastTurnWas) {

        TicTacToeV2Status result = ONGOING;

        if (isThereAWinner(gameGrid)) {
            result = lastTurnWas == PLAYER_ONE ? PLAYER_ONE_WIN : PLAYER_TWO_WIN;
        }

        if (isDrawn(gameGrid)) result = DRAWN;

            return result;

    }

    private boolean isDrawn(TicTacToeV2Symbology[][] gameGrid) {
        return Arrays.stream(gameGrid).allMatch(row -> Arrays.stream(row).allMatch(cell -> cell != EMPTY));
    }

    private boolean isThereAWinner(TicTacToeV2Symbology[][] gameGrid) {
        return this.isRowCompleted(gameGrid) || this.isColumnCompleted(gameGrid) || this.isDiagonalCompleted(gameGrid);

    }

    private boolean isDiagonalCompleted(TicTacToeV2Symbology[][] gameGrid) {
        return gameGrid[0][0] != EMPTY && gameGrid[0][0] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][2] ||
                gameGrid[0][2] != EMPTY && gameGrid[0][2] == gameGrid[1][1] && gameGrid[1][1] == gameGrid[2][0];
    }

    private boolean isColumnCompleted(TicTacToeV2Symbology[][] gameGrid) {

        boolean isThereWinner = false;

        for (int y = 0; y < GRID_SIDE && !isThereWinner; y++) {
            if (gameGrid[0][y] != EMPTY && gameGrid[0][y] == gameGrid[1][y] && gameGrid[1][y] == gameGrid[2][y])
                isThereWinner = true;
        }

        return isThereWinner;
    }

    private boolean isRowCompleted(TicTacToeV2Symbology[][] gameGrid) {

        boolean isThereWinner = false;

        for (int x = 0; x < GRID_SIDE && !isThereWinner; x++) {
            if (gameGrid[x][0] != EMPTY && gameGrid[x][0] == gameGrid[x][1] && gameGrid[x][1] == gameGrid[x][2])
                isThereWinner = true;
        }

        return isThereWinner;
    }
}
