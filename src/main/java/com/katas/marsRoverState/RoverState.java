package com.katas.marsRoverState;

public interface RoverState {

    RoverState turnRight();

    RoverState turnLeft();

    int processMoveXAxis(int x);

    int processMoveYAxis(int y);

    String returnFormattedStateSymbol();
}

