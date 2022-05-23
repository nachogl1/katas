package com.katas.gameOfLife;

import java.util.Random;

public class Cell {
    private boolean isDead;

    public Cell() {
        this.isDead = randomiseIdDead();
    }

    private boolean randomiseIdDead() {
        return new Random().nextBoolean();
    }

}
