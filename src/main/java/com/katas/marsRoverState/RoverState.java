package com.katas.marsRoverState;

public interface RoverState {

    RoverState turnRight();

    RoverState turnLeft();

    Coordinate getCurrentCoordinate();

    void move();

}
