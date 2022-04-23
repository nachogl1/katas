package com.katas.ticTacToeGame;

import java.util.HashMap;
import java.util.Map;

public class TTTGame {

    public static final int TOTAL_CELLS = 9;
    private Map<Integer, String> gameTable = new HashMap<>();
    private boolean isDone = false;
    private String winner = "NONE";

    public String getWinner() {
        return this.winner;
    }

    public boolean isGameDone() {
        return this.isDone;
    }

    public void makeMoveFor(String player, int cell) {
        if (gameTable.containsKey(cell)) {
            throw new IllegalStateException("Cell taken");
        }

        gameTable.put(cell, player);
    }

    public void checkRules() {

        if (isMaxMoves()) {
            isDone = true;
            return;
        }

        if (isFirstDiagonal()) {
            assignWinnerPlayerInCell(1);
            return;
        }

        if (isSecondDiagonal()) {
            assignWinnerPlayerInCell(3);
            return;
        }

        int firstCellOfRow = 1;
        for (int i = 1; i < 4; i++) {

            if (isColumn(i)) {
                assignWinnerPlayerInCell(i);
                return;
            }
            if (isRow(firstCellOfRow)) {
                assignWinnerPlayerInCell(firstCellOfRow);
                return;
            }
            firstCellOfRow += 3;
        }

        return;
    }

    private void assignWinnerPlayerInCell(int key) {
        this.winner = gameTable.get(key);
        this.isDone = true;
        return;
    }

    private boolean isMaxMoves() {
        return gameTable.size() == TOTAL_CELLS;
    }

    private boolean isFirstDiagonal() {
        return gameTable.containsKey(1) && isSamePlayerForCells(1, 5) && isSamePlayerForCells(5, 9);
    }

    private boolean isRow(int firstCellOfRow) {
        return gameTable.containsKey(firstCellOfRow) && isSamePlayerForCells(firstCellOfRow, firstCellOfRow + 1) && isSamePlayerForCells(firstCellOfRow + 1, firstCellOfRow + 2);
    }

    private boolean isColumn(int i) {
        return gameTable.containsKey(i) && isSamePlayerForCells(i, i + 3) && isSamePlayerForCells(i + 3, i + 6);
    }

    private boolean isSecondDiagonal() {
        return gameTable.containsKey(3) && isSamePlayerForCells(3, 5) &&isSamePlayerForCells(5,7);
    }

    private boolean isSamePlayerForCells(int firstCell, int secondCell) {
        return gameTable.getOrDefault(firstCell, "NONE") == gameTable.getOrDefault(secondCell, "NONE");
    }

}
