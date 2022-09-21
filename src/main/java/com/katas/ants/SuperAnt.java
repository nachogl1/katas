package com.katas.ants;

public class SuperAnt {

    private AntCoordinate antCoordinate;
    private AntDirection currentDirection = AntDirection.NORTH;

    public SuperAnt(int x, int y) {
        antCoordinate = new AntCoordinate(x, y);
    }

    public void moveRight() {
        this.currentDirection = currentDirection.turnRight();
        moveToCoordinate();
    }

    public void moveLeft() {
        this.currentDirection = currentDirection.turnLeft();
        moveToCoordinate();
    }

    public int getX() {
        return this.antCoordinate.x();
    }

    public int getY() {
        return this.antCoordinate.y();

    }

    private void moveToCoordinate() {
        this.antCoordinate = currentDirection.move(this.antCoordinate);
    }
}
