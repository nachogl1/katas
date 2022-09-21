package com.katas.ants;

public class AntGame {

    private AntGrid grid;

    public AntGame(int size, int iterationNumber) {
        this.grid = new AntGrid(size);
    }

    public void iterate() {
        this.grid.iterate();
    }

    public AntGrid getGrid() {
        return grid;
    }
}
