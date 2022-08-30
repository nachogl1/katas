package com.katas.marsRoverState;

public class Rover {
    private RoverState roverState = new RoverStateNorth(new Coordinate(0, 0));

    public RoverState getRoverState() {
        return roverState;
    }

    public void turnRight() {
        this.roverState = this.roverState.turnRight();
    }

    public void turnLeft() {
        this.roverState = this.roverState.turnLeft();
    }

    public Coordinate getCurrentCoordinate() {
        return this.roverState.getCurrentCoordinate();
    }

    public void move() {
        this.roverState.move();
    }
}
