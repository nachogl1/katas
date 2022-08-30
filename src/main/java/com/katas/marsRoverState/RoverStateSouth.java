package com.katas.marsRoverState;

public class RoverStateSouth implements RoverState {

    private Coordinate _coordinate;


    public RoverStateSouth(Coordinate coordinate) {
        _coordinate = coordinate;
    }

    @Override
    public RoverState turnRight() {
        return new RoverStateWest(_coordinate);
    }

    @Override
    public RoverState turnLeft() {
        return new RoverStateEast(_coordinate);
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return _coordinate;
    }

    @Override
    public void move() {
        int currentX = _coordinate.x;
        int currentY = _coordinate.y;

        _coordinate = new Coordinate(currentX, currentY - 1);
    }
}
