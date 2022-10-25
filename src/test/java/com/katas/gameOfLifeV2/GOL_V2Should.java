package com.katas.gameOfLifeV2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GOL_V2Should {


    @Test
    void receiveCustomisedGridBeforeStarting() {
        boolean[][] expectedGrid = {
                {false, false, false, false, false}
                , {false, false, false, false, false}
                , {false, false, true, true, false}
                , {false, false, true, false, false}
                , {false, false, false, false, false}
                , {false, false, false, false, false}
        };
        GOL_V2 game = new GOL_V2(expectedGrid);

        boolean[][] resultGrid = game.getGrid();


        assertEquals(expectedGrid, resultGrid);

    }

    @Test
    void killMiddleCellBecauseItHasNoLivingNeighbors() {
        boolean[][] inputGrid = {
                {false, false, false}
                , {false, true, false}
                , {false, false, false}
        };

        GOL_V2 game = new GOL_V2(inputGrid);

        game.nextGen();
        boolean[][] resultGrid = game.getGrid();


        assertFalse(resultGrid[1][1]);

    }

    @Test
    void killMiddleCellBecauseOnlyOneNeighbor() {
        boolean[][] inputGrid = {
                {false, false, false}
                , {false, true, false}
                , {false, false, true}
        };


        GOL_V2 game = new GOL_V2(inputGrid);

        game.nextGen();
        boolean[][] resultGrid = game.getGrid();


        assertFalse(resultGrid[1][1]);

    }

    @Test
    void aliveMiddleCellDieBecauseOverPopulation() {
        boolean[][] inputGrid = {
                {true, false, true}
                , {false, true, true}
                , {false, false, true}
        };


        GOL_V2 game = new GOL_V2(inputGrid);

        game.nextGen();
        boolean[][] resultGrid = game.getGrid();


        assertFalse(resultGrid[1][1]);

    }

    @Test
    void aliveMiddleCellLiveBecause2Neighbors() {
        boolean[][] inputGrid = {
                {false, false, false}
                , {false, true, true}
                , {false, false, true}
        };


        GOL_V2 game = new GOL_V2(inputGrid);

        game.nextGen();
        boolean[][] resultGrid = game.getGrid();


        assertTrue(resultGrid[1][1]);

    }

    @Test
    void aliveMiddleCellLiveBecause3Neighbors() {
        boolean[][] inputGrid = {
                {true, false, false}
                , {false, true, true}
                , {false, false, true}
        };


        GOL_V2 game = new GOL_V2(inputGrid);

        game.nextGen();
        boolean[][] resultGrid = game.getGrid();


        assertTrue(resultGrid[1][1]);

    }

    @Test
    void deadMiddleCellLiveBecause3Neighbors() {
        boolean[][] inputGrid = {
                {true, false, false}
                , {false, false, true}
                , {false, false, true}
        };


        GOL_V2 game = new GOL_V2(inputGrid);

        game.nextGen();
        boolean[][] resultGrid = game.getGrid();


        assertTrue(resultGrid[1][1]);

    }

    @Test
    void acceptance() {
        boolean[][] expectedStartingBoard = new boolean[][]{
                {false, false, true, false, false},
                {false, true, true, true, false},
                {false, false, true, false, false}
        };
        boolean[][] expected3GenBoard = new boolean[][]{
                {false, false, false, false, false},
                {true, true, false, true, true},
                {false, false, false, false, false}
        };

        GOL_V2 game = new GOL_V2(expectedStartingBoard);

        game.nextGen();
        game.nextGen();
        game.nextGen();
        boolean[][] resultGrid = game.getGrid();

        assertArrayEquals(expected3GenBoard, resultGrid);
    }


}
