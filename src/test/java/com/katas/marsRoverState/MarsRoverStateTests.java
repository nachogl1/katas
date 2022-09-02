package com.katas.marsRoverState;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverStateTests {

    private Rover rover;

    @BeforeEach
    void setUp() {
        rover = new Rover();
    }

    @Test
    void whenCreatingMarsRover_RoverFacesNorth() {
        String finalState = rover.getCurrentState();

        assertEquals("N:0:0", finalState);
    }

    @Test
    void whenRoverStartsNorth_WhenRoverTurnRight_RoverFacesEast() {
        rover.turnRight();
        String finalState = rover.getCurrentState();

        assertEquals("E:0:0", finalState);
    }

    @Test
    void whenRoverStartsNorth_WhenRoverTurnTwoTimesRight_RoverFacesSouth() {
        rover.turnRight();
        rover.turnRight();
        String finalState = rover.getCurrentState();

        assertEquals("S:0:0", finalState);
    }

    @Test
    void whenRoverStartsNorth_WhenRoverTurnThreeTimesRight_RoverFacesWest() {

        rover.turnRight();
        rover.turnRight();
        rover.turnRight();
        String finalState = rover.getCurrentState();

        assertEquals("W:0:0", finalState);
    }


    @Test
    void givenRoverStarts0_0_WhenRoverMovesOneStepNorth_RoverIsIn0_1() {

        rover.move();

        String finalState = rover.getCurrentState();

        assertEquals("N:0:1", finalState);
    }

    @Test
    void givenRoverStarts0_0_WhenRoverMovesTwoStepNorth_RoverIsIn0_2() {

        rover.move();
        rover.move();

        String finalState = rover.getCurrentState();

        assertEquals("N:0:2", finalState);
    }

    @Test
    void givenRoverStarts0_0_WhenRoverMovesThreeStepNorth_RoverIsIn0_3() {

        rover.move();
        rover.move();
        rover.move();

        String finalState = rover.getCurrentState();

        assertEquals("N:0:3", finalState);
    }

    @Test
    void givenRoverStarts0_0_WhenRoverMovesOneStepEast_RoverIsIn1_0() {

        rover.turnRight();
        rover.move();

        String finalState = rover.getCurrentState();

        assertEquals("E:1:0", finalState);
    }

    @Test
    void givenPresetScenario_WhenRoverMoves_RoverReturnCorrectState() {

        rover.turnRight();
        rover.move();
        rover.move();
        rover.move();
        rover.turnLeft();
        rover.move();

        String finalState = rover.getCurrentState();

        assertEquals("N:3:1", finalState);

    }

}
