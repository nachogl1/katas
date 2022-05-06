package com.katas.ticTacToeV2;

import static com.katas.ticTacToeV2.TicTacToeV2Symbology.EMPTY;

public class TicTacToeGameV2 {

    private final TicTacToeV2Symbology[][] gameGrid = new TicTacToeV2Symbology[][]{{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};
    private final TicTacToeV2Referee referee = new TicTacToeV2Referee();

    public TicTacToeV2Status publishCurrentResult() {
        return this.referee.getCurrentGameStatus();
    }

    public TicTacToeV2Symbology[][] makeMove(int x, int y) {
        this.referee.checkValidityOfMove(gameGrid, x, y);

        this.gameGrid[x][y] = this.referee.getCurrentPlayer();

        this.refereeProcessGameUpdates();

        return this.gameGrid;
    }

    private void refereeProcessGameUpdates() {
        this.referee.updateStatus(this.gameGrid);
        this.referee.giveTurnToNextPlayer();
    }
}
