package com.katas.gameOfLifeTests;

import com.katas.gameOfLife.GameOfLife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class GameOfLifeTest {

    GameOfLife game;
    boolean[][] expectedStartingBoard;
    boolean[][] expected1GenBoard;
    boolean[][] expected2GenBoard;
    boolean[][] expected3GenBoard;

    @BeforeEach
    public void setUp() {
        expectedStartingBoard = new boolean[][]{
                {false, false, true, false, false},
                {false, true, true, true, false},
                {false, false, true, false, false}
        };

        expected1GenBoard = new boolean[][]{
                {false, true, true, true, false},
                {false, true, false, true, false},
                {false, true, true, true, false}
        };

        expected2GenBoard = new boolean[][]{
                {false, true, false, true, false},
                {true, false, false, false, true},
                {false, true, false, true, false}
        };

        expected3GenBoard = new boolean[][]{
                {false, false, false, false, false},
                {true, true, false, true, true},
                {false, false, false, false, false}
        };
        game = new GameOfLife();
    }

    @Test
    void returnCorrect1stGenBoard() {
        assertArrayEquals(expected1GenBoard, game.nextGen());
    }

    @Test
    void returnCorrect2ndGenBoard() {
        game.nextGen();
        assertArrayEquals(expected2GenBoard, game.nextGen());
    }

    @Test
    void returnCorrect3ndGenBoard() {
        game.nextGen();
        game.nextGen();
        assertArrayEquals(expected3GenBoard, game.nextGen());
    }

}
