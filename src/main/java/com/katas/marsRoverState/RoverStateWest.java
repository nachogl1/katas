package com.katas.marsRoverState;

public class RoverStateWest implements RoverState {


    @Override
    public RoverState turnRight() {
        return new RoverStateNorth();
    }

    @Override
    public RoverState turnLeft() {
        return new RoverStateSouth();
    }

    @Override
    public int processMoveXAxis(int x) {
        return --x;
    }

    @Override
    public int processMoveYAxis(int y) {
        return y;
    }

    @Override
    public String returnFormattedStateSymbol() {
        return "W:";
    }
}
