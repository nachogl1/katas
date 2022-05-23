package com.katas.gameOfLife;

public class Board {

    private boolean[][] initialBoard = new boolean[][]{
            {false, false, true, false, false},
            {false, true, true, true, false},
            {false, false, true, false, false}
    };
    private boolean[][] nextGenBoard;
    private Detector detector = new Detector();

    public Board() {
        nextGenBoard = new boolean[this.initialBoard.length][this.initialBoard[0].length];
    }

    public boolean[][] makeNextGenBoard() {
        processRows();
        assignBoards();

        return this.initialBoard;
    }

    private void processRows() {
        for (int row = 0; row < this.initialBoard.length; row++) {
            processColumns(row);
        }
    }

    private void processColumns(int row) {
        for (int column = 0; column < this.initialBoard[0].length; column++) {
            nextGenBoard[row][column] = isCellAliveForNextGen(row, column);
        }
    }

    private void assignBoards() {
        this.initialBoard = this.nextGenBoard;
        this.nextGenBoard = new boolean[this.initialBoard.length][this.initialBoard[0].length];
    }

    private boolean isCellAliveForNextGen(int row, int column) {
        return isAliveCountEqualTo(row, column, 2) || isAliveCountEqualTo(row, column, 3);
    }

    private boolean isAliveCountEqualTo(int row, int column, int value) {
        return detector.detectAliveNeighbours(row, column, this.initialBoard) == value;
    }
}
