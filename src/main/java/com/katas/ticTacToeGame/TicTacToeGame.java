package com.katas.ticTacToeGame;

public class TicTacToeGame {

    public static final int MAX_MOVES = 9;
    private int counter = 0;
    private String winner = "NONE"; //enum
    private GameTable gameTable;

    public TicTacToeGame() {
        this.gameTable = new GameTable();
    }

    public boolean isFinished() {
        return counter == MAX_MOVES;
    }

    public void moveUserToPosition(String user, int cell) throws Exception {
        if (isFinished()) throw new Exception("Game was finished");

        this.gameTable.moveUserToPosition(user, cell);
        counter++;

        checkRules();
    }

    private void checkRules() {
        if (gameTable.checkIfXHasColumn()) {
            this.counter = 9;
            this.winner = "X";
        }


    }


    public String getWinner() {
        return winner;
    }
}
