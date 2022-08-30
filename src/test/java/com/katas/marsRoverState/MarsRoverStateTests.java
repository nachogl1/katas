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
        RoverState currentDirection = rover.getRoverState();

        assertEquals(RoverStateNorth.class, currentDirection.getClass());
    }

    @Test
    void whenRoverStartsNorth_WhenRoverTurnRight_RoverFacesEast() {
        rover.turnRight();
        RoverState currentDirection = rover.getRoverState();

        assertEquals(RoverStateEast.class, currentDirection.getClass());
    }

    @Test
    void whenRoverStartsNorth_WhenRoverTurnTwoTimesRight_RoverFacesSouth() {
        rover.turnRight();
        rover.turnRight();
        RoverState currentDirection = rover.getRoverState();

        assertEquals(RoverStateSouth.class, currentDirection.getClass());
    }

    @Test
    void whenRoverStartsNorth_WhenRoverTurnThreeTimesRight_RoverFacesWest() {

        rover.turnRight();
        rover.turnRight();
        rover.turnRight();
        RoverState currentDirection = rover.getRoverState();

        assertEquals(RoverStateWest.class, currentDirection.getClass());
    }

    @Test
    void whenCreatingMarsRover_RoverStartsAt0_0() {

        Coordinate currentCoordinate = rover.getCurrentCoordinate();

        assertEquals(0, currentCoordinate.x);
        assertEquals(0, currentCoordinate.y);
    }

    @Test
    void givenRoverStarts0_0_WhenRoverMovesOneStepNorth_RoverIsIn0_1() {

        rover.move();

        Coordinate currentCoordinate = rover.getCurrentCoordinate();

        assertEquals(0, currentCoordinate.x);
        assertEquals(1, currentCoordinate.y);
    }

    @Test
    void givenRoverStarts0_0_WhenRoverMovesTwoStepNorth_RoverIsIn0_2() {

        rover.move();
        rover.move();

        Coordinate currentCoordinate = rover.getCurrentCoordinate();

        assertEquals(0, currentCoordinate.x);
        assertEquals(2, currentCoordinate.y);
    }

    @Test
    void givenRoverStarts0_0_WhenRoverMovesThreeStepNorth_RoverIsIn0_3() {

        rover.move();
        rover.move();
        rover.move();

        Coordinate currentCoordinate = rover.getCurrentCoordinate();

        assertEquals(0, currentCoordinate.x);
        assertEquals(3, currentCoordinate.y);
    }

    @Test
    void givenRoverStarts0_0_WhenRoverMovesOneStepEast_RoverIsIn1_0() {

        rover.turnRight();
        rover.move();

        Coordinate currentCoordinate = rover.getCurrentCoordinate();

        assertEquals(1, currentCoordinate.x);
        assertEquals(0, currentCoordinate.y);
    }

    @Test
    void givenPresetScenario_WhenRoverMoves_RoverReturnCorrectState() {

        rover.turnRight();
        rover.move();
        rover.move();
        rover.move();
        rover.turnLeft();
        rover.move();

        Coordinate currentCoordinate = rover.getCurrentCoordinate();
        RoverState currentState = rover.getRoverState();

        assertEquals(3, currentCoordinate.x);
        assertEquals(1, currentCoordinate.y);
        assertEquals(RoverStateNorth.class, currentState.getClass());

    }

}
