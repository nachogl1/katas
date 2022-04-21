package com.katas.ticTacToeGame;

public class GameTable {
    private String[] cells = new String[9];


    public void moveUserToPosition(String user, int cell) throws Exception {
        if (cells[cell - 1] != null) {
            throw new Exception("Cells is occupied already, case not covered");
        }

        cells[cell - 1] = user;
    }

    public boolean checkIfXHasColumn() {
        if (cells[1-1] == "X" && cells[4-1] == "X" && cells[7-1] == "X") {
            return true;
        }
        return false;
    }
}
