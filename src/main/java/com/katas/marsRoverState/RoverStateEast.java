package com.katas.marsRoverState;

public class RoverStateEast implements RoverState {

    private Coordinate _coordinate;


    public RoverStateEast(Coordinate coordinate) {
        _coordinate = coordinate;
    }

    @Override
    public RoverState turnRight() {
        return new RoverStateSouth(_coordinate);
    }

    @Override
    public RoverState turnLeft() {
        return new RoverStateNorth(_coordinate);
    }

    @Override
    public Coordinate getCurrentCoordinate() {
        return _coordinate;
    }

    @Override
    public void move() {
        int currentX = _coordinate.x;
        int currentY = _coordinate.y;

        this._coordinate = new Coordinate(currentX + 1, currentY);
    }


}
