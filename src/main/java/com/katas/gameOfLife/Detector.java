package com.katas.gameOfLife;

public class Detector {

    private Coordinates coordinates;
    private int aliveCount;
    private boolean[][] board;

    public int detectAliveNeighbours(int row, int column, boolean[][] board) {

        init(row, column, board);

        detectAliveNeighborsColumns();
        detectAliveNeighborsRows();
        detectAliveNeighborsDiagonals();

        return this.aliveCount;
    }

    private void init(int row, int column, boolean[][] board) {
        this.coordinates = new Coordinates(row, column);
        this.board = board;
        this.aliveCount = 0;
    }

    private void detectAliveNeighborsColumns() {
        process(this.coordinates.row + 1, this.coordinates.column);
        process(this.coordinates.row - 1, this.coordinates.column);
    }

    private void detectAliveNeighborsRows() {
        process(this.coordinates.row, this.coordinates.column + 1);
        process(this.coordinates.row, this.coordinates.column - 1);
    }

    private void detectAliveNeighborsDiagonals() {
        process(this.coordinates.row + 1, this.coordinates.column + 1);
        process(this.coordinates.row - 1, this.coordinates.column - 1);
        process(this.coordinates.row + 1, this.coordinates.column - 1);
        process(this.coordinates.row - 1, this.coordinates.column + 1);
    }

    private void process(int row, int column) {
        try {
            if (board[row][column]) aliveCount++;
        } catch (Exception e) {
            //keep calm and carry on
        }
    }
}
