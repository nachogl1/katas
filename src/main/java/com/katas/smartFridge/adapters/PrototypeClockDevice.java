package com.katas.smartFridge.adapters;

import com.katas.smartFridge.core.ports.IClock;

import java.time.LocalDateTime;

public class PrototypeClockDevice implements IClock {

    private LocalDateTime currentMoment;

    public PrototypeClockDevice() {
        this.currentMoment = LocalDateTime.now();
    }

    public void simulateDayOver() {
        throw new UnsupportedOperationException();
    }

    public LocalDateTime getCurrentMoment() {
        return currentMoment;
    }
}
