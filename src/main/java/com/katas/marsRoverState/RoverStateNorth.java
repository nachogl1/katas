package com.katas.marsRoverState;

public class RoverStateNorth implements RoverState {

    @Override
    public RoverState turnRight() {
        return new RoverStateEast();
    }

    @Override
    public RoverState turnLeft() {
        return new RoverStateWest();
    }

    @Override
    public int processMoveXAxis(int x) {
        return x;
    }

    @Override
    public int processMoveYAxis(int y) {
        return ++y;
    }

    @Override
    public String returnFormattedStateSymbol() {
        return "N:";
    }


}
