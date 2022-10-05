package com.katas.smartFridge.core.entities;

public enum FridgeItemState {
    OPENED("opened"), SEALED("sealed");

    private final String state;

    FridgeItemState(String state) {
        this.state = state;
    }
}
