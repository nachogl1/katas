package com.katas.ticTacToeGame;

import static com.katas.ticTacToeGame.TicTacToeV2Symbology.*;

public class TicTacToeGameV2 {

    private TicTacToeV2Symbology[][] gameGrid = {{EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}, {EMPTY, EMPTY, EMPTY}};
    private TicTacToeV2Referee referee = new TicTacToeV2Referee();

    public TicTacToeV2Status publishCurrentResult() {
        return this.referee.getCurrentGameStatus();
    }

    public TicTacToeV2Symbology[][] makeMove(int x, int y) {
        referee.checkValidityOfMove(gameGrid,x,y);

        gameGrid[x][y] = this.referee.isPlayerOneTurn() ? PLAYER_ONE : PLAYER_TWO;

        refereeProcessGameUpdates();

        return this.gameGrid;
    }

    private void refereeProcessGameUpdates() {
        this.referee.updateLastTurnWas();
        referee.updateStatus(this.gameGrid);
    }
}
