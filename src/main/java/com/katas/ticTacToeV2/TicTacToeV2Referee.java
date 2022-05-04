package com.katas.ticTacToeV2;

import static com.katas.ticTacToeV2.TicTacToeV2Symbology.EMPTY;

public class TicTacToeV2Referee {

    //    private TicTacToeV2Symbology lastTurnWas;
    private TicTacToeV2Status currentGameStatus = TicTacToeV2Status.NOT_STARTED;
    private TicTacToeRuleTable ruleTable = new TicTacToeRuleTable();
    private TicTacToeV2Symbology currentPlayer = TicTacToeV2Symbology.PLAYER_ONE;


    public TicTacToeV2Status getCurrentGameStatus() {
        return currentGameStatus;
    }

    public TicTacToeV2Symbology getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void giveTurnToNextPlayer() {
        this.currentPlayer = this.currentPlayer.getNextPlayer();
    }

    public void updateStatus(TicTacToeV2Symbology[][] gameGrid) {
        this.currentGameStatus = this.ruleTable.checkRules(gameGrid, this.currentPlayer);
    }

    public void checkValidityOfMove(TicTacToeV2Symbology[][] gameGrid, int x, int y) {
        if (gameGrid[x][y] != EMPTY) throw new SpaceAlreadyUsedException();
    }
}
