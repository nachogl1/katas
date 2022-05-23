package com.katas.gameOfLife;

public class GameOfLife {
    private Board board;

    public GameOfLife() {
        this.board = new Board();
    }

    public boolean[][] nextGen() {
        return board.makeNextGenBoard();
    }
}
