package com.katas.marsRoverState;

public class RoverStateEast implements RoverState {

    @Override
    public RoverState turnRight() {
        return new RoverStateSouth();
    }

    @Override
    public RoverState turnLeft() {
        return new RoverStateNorth();
    }

    @Override
    public int processMoveXAxis(int x) {
        return ++x;
    }

    @Override
    public int processMoveYAxis(int y) {
        return y;
    }


    @Override
    public String returnFormattedStateSymbol() {
        return "E:";
    }


}
