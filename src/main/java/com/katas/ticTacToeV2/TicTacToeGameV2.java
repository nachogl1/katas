package com.katas.ticTacToeV2;

import static com.katas.ticTacToeV2.TicTacToeV2Symbology.EMPTY;

public class TicTacToeGameV2 {

    private TicTacToeV2Symbology[][] gameGrid = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};
    private TicTacToeV2Referee referee = new TicTacToeV2Referee();

    public TicTacToeV2Status publishCurrentResult() {
        return this.referee.getCurrentGameStatus();
    }

    public TicTacToeV2Symbology[][] makeMove(int x, int y) {
        referee.checkValidityOfMove(gameGrid, x, y);

        gameGrid[x][y] = this.referee.getCurrentPlayer();

        refereeProcessGameUpdates();

        return this.gameGrid;
    }

    private void refereeProcessGameUpdates() {
        referee.updateStatus(this.gameGrid);
        this.referee.giveTurnToNextPlayer();
    }
}
