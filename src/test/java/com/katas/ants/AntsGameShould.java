package com.katas.ants;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.katas.ants.AntGrid.BLACK_SQUARE;
import static com.katas.ants.AntGrid.WHITE_SQUARE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AntsGameShould {


    private AntGame game;
    private List<SimpleEntry<Integer, Integer>> blacklistedPoints;

    @BeforeEach
    void setUp() {
        game = new AntGame(3, 0);
        blacklistedPoints = new ArrayList<>();
    }

    @ParameterizedTest
    @CsvSource({"3,9", "5,25", "7,49", "9,81", "11,121"})
    void givenThreeIsPassedAsGridSize_WhenGameStarts_ThenGameGridSizeIsNine(int gridWidth, int area) {
        game = new AntGame(gridWidth, 0);

        AntGrid grid = game.getGrid();

        assertEquals(area, grid.size());
    }

    @ParameterizedTest
    @CsvSource({"4", "6", "10"})
    void givenEvenNumberPassed_WhenCreatingGrid_ThenInvalidGridSizeExceptionIsThrown(int gridWidth) {
        assertThrows(InvalidGridSizeException.class, () -> {
            new AntGame(gridWidth, 0);
        });
    }

    @Test
    void givenAntFacingNorth_WhenIteration0Happens_ThenAntHasBeenOn1_1() {
        blacklistedPoints.add(new SimpleEntry<>(1, 1));

        game.iterate();
        AntGrid grid = game.getGrid();

        assertAllWhitePointsInGridButBlacklistedPoints(grid, blacklistedPoints);
    }

    @Test
    void givenAntFacingNorth_WhenIteration1Happens_ThenAntHasBeenOn1_1And2_1() {
        blacklistedPoints.add(new SimpleEntry<>(1, 1));
        blacklistedPoints.add(new SimpleEntry<>(2, 1));

        iterateGameFor(2);
        AntGrid grid = game.getGrid();

        assertAllWhitePointsInGridButBlacklistedPoints(grid, blacklistedPoints);
    }

    @Test
    void givenAntFacingNorth_WhenIteration5Happens_ThenAntHasMovedCorrectly() {
        blacklistedPoints.add(new SimpleEntry<>(2, 1));
        blacklistedPoints.add(new SimpleEntry<>(2, 0));
        blacklistedPoints.add(new SimpleEntry<>(1, 0));

        iterateGameFor(5);
        AntGrid grid = game.getGrid();

        assertAllWhitePointsInGridButBlacklistedPoints(grid, blacklistedPoints);
    }

    @Test
    void givenAntFacingNorth_WhenIteration7Happens_ThenAntHasMovedCorrectly() {
        blacklistedPoints.add(new SimpleEntry<>(2, 1));
        blacklistedPoints.add(new SimpleEntry<>(2, 0));
        blacklistedPoints.add(new SimpleEntry<>(1, 0));
        blacklistedPoints.add(new SimpleEntry<>(0, 1));
        blacklistedPoints.add(new SimpleEntry<>(0, 2));

        iterateGameFor(7);
        AntGrid grid = game.getGrid();

        assertAllWhitePointsInGridButBlacklistedPoints(grid, blacklistedPoints);
    }

    private void iterateGameFor(int iterations) {
        IntStream.range(1, iterations + 1).forEach((v) -> game.iterate());
    }

    private void assertAllWhitePointsInGridButBlacklistedPoints(AntGrid antGrid, List<SimpleEntry<Integer, Integer>> blacklistedPoints) {
        AntGridFn function = (boolean[][] grid, int i, int j) -> {
            boolean expectedColor = isPointBlacklisted(blacklistedPoints, i, j) ? BLACK_SQUARE : WHITE_SQUARE;
            assertEquals(expectedColor, grid[i][j]);
        };

        antGrid.forEachCell(function);
    }

    private boolean isPointBlacklisted(List<SimpleEntry<Integer, Integer>> blacklistedPoints, int i, int j) {
        for (SimpleEntry<Integer, Integer> blacklistedPoint : blacklistedPoints) {
            if (blacklistedPoint.getKey() == i && blacklistedPoint.getValue() == j)
                return true;
        }
        return false;
    }

}
