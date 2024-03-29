package com.katas.gameOfLifeV2;

public class GOL_V2 {

    private boolean[][] grid;

    public GOL_V2(boolean[][] grid) {
        this.grid = grid;
    }

    public boolean[][] getGrid() {
        return this.grid;
    }

    public void nextGen() {

        boolean[][] resultGrid = cloneBaseGrid();

        for (int x = 0; x < resultGrid.length; x++) {
            for (int y = 0; y < resultGrid[x].length; y++) {
                resultGrid[x][y] = isAliveForNextGen(x, y);
            }
        }

        this.grid = resultGrid;
    }

    private boolean[][] cloneBaseGrid() {
        boolean[][] resultGrid = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++)
            resultGrid[i] = grid[i].clone();

        return resultGrid;
    }

    private boolean isAliveForNextGen(int x, int y) {
        int totalNeighbors = calculateLiveNeighbors(x, y);

        return (grid[x][y] && (totalNeighbors == 3 || totalNeighbors == 2))
                || (!grid[x][y] && (totalNeighbors == 3));

    }

    private int calculateLiveNeighbors(int x, int y) {
        return returnOneIfAlive(x - 1, y - 1)
                + returnOneIfAlive(x - 1, y)
                + returnOneIfAlive(x - 1, y + 1)
                + returnOneIfAlive(x, y - 1)
                + returnOneIfAlive(x, y + 1)
                + returnOneIfAlive(x + 1, y - 1)
                + returnOneIfAlive(x + 1, y)
                + returnOneIfAlive(x + 1, y + 1);
    }

    private int returnOneIfAlive(int x, int y) {
        boolean result = false;
        try {
            result = this.grid[x][y];
        } catch (Exception e) {
            //Me being cheeky
        }
        return result ? 1 : 0;
    }
}
