package com.katas.marsRoverState;

public class Rover {
    private RoverState currentDirection;
    private Coordinate currentCoordinate;

    public Rover() {
        currentCoordinate = new Coordinate(0, 0);
        this.currentDirection = new RoverStateNorth();
    }

    public void turnRight() {
        this.currentDirection = this.currentDirection.turnRight();
    }

    public void turnLeft() {
        this.currentDirection = this.currentDirection.turnLeft();
    }

    public void move() {
        this.currentCoordinate.move(currentDirection);
    }

    public String getCurrentState() {
        return appendDirectionToCoordinates();
    }

    private String appendDirectionToCoordinates() {
        String currentDirection = this.currentDirection.returnFormattedStateSymbol();
        String currentCoordinates = this.currentCoordinate.returnFormattedCoordinates();

        String formattedFinalState = currentDirection + currentCoordinates;

        return formattedFinalState;
    }

}
