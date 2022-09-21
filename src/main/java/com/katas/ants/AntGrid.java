package com.katas.ants;

import java.util.Arrays;

public class AntGrid {

    public static final boolean WHITE_SQUARE = false;
    public static final boolean BLACK_SQUARE = true;
    private boolean[][] grid;
    private SuperAnt ant;

    public AntGrid(int size) {
        checkGridSizeIsOdd(size);
        this.grid = createGridOfWhiteSpaces(size);
        ant = new SuperAnt(1, 1);
    }

    public AntGrid iterate() {

        if (isAntOnWhiteSquare()) {
            transformThisSquareTo(this.ant.getX(), this.ant.getY(), BLACK_SQUARE);
            this.ant.moveRight();
        } else {
            transformThisSquareTo(this.ant.getX(), this.ant.getY(), WHITE_SQUARE);
            this.ant.moveLeft();
        }

        return this;
    }

    public void forEachCell(AntGridFn fn) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                fn.call(grid, i, j);
            }
        }
    }

    public int size() {
        return grid.length * grid.length;
    }

    private void transformThisSquareTo(int x, int y, boolean targetColor) {
        this.grid[x][y] = targetColor;
    }

    private boolean isAntOnWhiteSquare() {
        return this.grid[this.ant.getX()][this.ant.getY()] == WHITE_SQUARE;
    }

    private void checkGridSizeIsOdd(int size) {
        if (size % 2 == 0) {
            throw new InvalidGridSizeException();
        }
    }

    private boolean[][] createGridOfWhiteSpaces(int size) {
        boolean[][] grid = new boolean[size][size];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(grid[i], WHITE_SQUARE);
        }

        return grid;
    }
}
