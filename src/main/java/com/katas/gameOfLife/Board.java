package com.katas.gameOfLife;

public class Board {

    private boolean[][] currentBoard = new boolean[][]{
            {false, false, true, false, false},
            {false, true, true, true, false},
            {false, false, true, false, false}
    };
    private boolean[][] nextGenBoard;
    private Detector detector = new Detector();

    public Board() {
        nextGenBoard = new boolean[this.currentBoard.length][this.currentBoard[0].length];
    }

    public boolean[][] makeNextGenBoard() {
        processRows();
        assignBoards();

        return this.currentBoard;
    }

    private void processRows() {
        for (int row = 0; row < this.currentBoard.length; row++) {
            processColumns(row);
        }
    }

    private void processColumns(int row) {
        for (int column = 0; column < this.currentBoard[0].length; column++) {
            nextGenBoard[row][column] = isCellAliveForNextGen(row, column);
        }
    }

    private void assignBoards() {
        this.currentBoard = this.nextGenBoard;
        this.nextGenBoard = new boolean[this.currentBoard.length][this.currentBoard[0].length];
    }

    private boolean isCellAliveForNextGen(int row, int column) {
        return isAliveWith2or3Neighbors(row, column) || isDeadWith3Neighbors(row, column);
    }

    private boolean isDeadWith3Neighbors(int row, int column) {
        return !isCellUnderStudyAlive(row, column) && isAliveCountEqualTo(row, column, 3);
    }

    private boolean isAliveWith2or3Neighbors(int row, int column) {
        return isCellUnderStudyAlive(row, column) && hasTwoOrThreeNeighbors(row, column);
    }

    private boolean isCellUnderStudyAlive(int row, int column) {
        return this.currentBoard[row][column];
    }

    private boolean hasTwoOrThreeNeighbors(int row, int column) {
        return (isAliveCountEqualTo(row, column, 3)) || isAliveCountEqualTo(row, column, 2);
    }

    private boolean isAliveCountEqualTo(int row, int column, int value) {
        return detector.detectAliveNeighbours(row, column, this.currentBoard) == value;
    }
}
