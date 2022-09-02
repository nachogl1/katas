package com.katas.marsRoverState;

public class RoverStateSouth implements RoverState {


    @Override
    public RoverState turnRight() {
        return new RoverStateWest();
    }

    @Override
    public RoverState turnLeft() {
        return new RoverStateEast();
    }

    @Override
    public int processMoveXAxis(int x) {
        return x;
    }

    @Override
    public int processMoveYAxis(int y) {
        return --y;
    }

    @Override
    public String returnFormattedStateSymbol() {
        return "S:";
    }
}
