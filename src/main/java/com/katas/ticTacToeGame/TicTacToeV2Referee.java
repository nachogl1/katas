package com.katas.ticTacToeGame;

import static com.katas.ticTacToeGame.TicTacToeV2Symbology.*;

public class TicTacToeV2Referee {

    private TicTacToeV2Symbology lastTurnWas;
    private TicTacToeV2Status currentGameStatus = TicTacToeV2Status.NOT_STARTED;
    private TicTacToeRuleTable ruleTable = new TicTacToeRuleTable();

    public TicTacToeV2Status getCurrentGameStatus() {
        return currentGameStatus;
    }

    public boolean isPlayerOneTurn() {
        return isLastTurnPlayerTwoOrNull(this.lastTurnWas);
    }

    public void updateLastTurnWas() {
        this.lastTurnWas = isLastTurnPlayerTwoOrNull(this.lastTurnWas) ? PLAYER_ONE : PLAYER_TWO;
    }

    public void updateStatus(TicTacToeV2Symbology[][] gameGrid) {
        this.currentGameStatus = this.ruleTable.checkRules(gameGrid, this.lastTurnWas);
    }

    private boolean isLastTurnPlayerTwoOrNull(TicTacToeV2Symbology lastTurnWas) {
        return this.lastTurnWas == PLAYER_TWO || this.lastTurnWas == null;
    }

    public void checkValidityOfMove(TicTacToeV2Symbology[][] gameGrid, int x, int y) {
        if (gameGrid[x][y] != EMPTY) throw new SpaceAlreadyUsedException();
    }
}
