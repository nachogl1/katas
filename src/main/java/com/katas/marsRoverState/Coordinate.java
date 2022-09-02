package com.katas.marsRoverState;

public class Coordinate {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String returnFormattedCoordinates() {
        final StringBuilder coordinates = new StringBuilder()
                .append(x)
                .append(":")
                .append(y);
        return coordinates.toString();
    }

    public void move(RoverState roverState) {
        this.x = roverState.processMoveXAxis(x);
        this.y = roverState.processMoveYAxis(y);
    }
}