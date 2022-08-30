package com.katas.marsRoverState;

public class RoverStateWest implements RoverState {

    private Coordinate _coordinate;


    public RoverStateWest(Coordinate coordinate) {
        _coordinate = coordinate;
    }

    @Override
    public RoverState turnRight() {
        return new RoverStateNorth(_coordinate);
    }

    @Override
    public RoverState turnLeft() {
        return new RoverStateSouth(_coordinate);
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return _coordinate;
    }

    @Override
    public void move() {
        int currentX = _coordinate.x;
        int currentY = _coordinate.y;

        _coordinate = new Coordinate(currentX - 1, currentY);
    }
}
