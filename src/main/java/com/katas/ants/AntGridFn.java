package com.katas.ants;

@FunctionalInterface
public interface AntGridFn {
    void call (boolean[][] grid, int x, int y);
}
