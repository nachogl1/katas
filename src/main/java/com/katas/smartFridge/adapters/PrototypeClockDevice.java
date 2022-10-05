package com.katas.smartFridge.adapters;

import com.katas.smartFridge.core.ports.IClock;

import java.time.LocalDateTime;

public class PrototypeClockDevice implements IClock {

    public LocalDateTime getCurrentMoment() {
        return LocalDateTime.now();
    }
}
