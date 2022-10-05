package com.katas.smartFridge;

import com.katas.smartFridge.adapters.PrototypeClockDevice;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrototypeClockDeviceShould {
    @Test
    void setTimeCorrectlyOnCreation() {

        PrototypeClockDevice clock = new PrototypeClockDevice();

        assertEquals(LocalDateTime.now().toLocalDate(), clock.getCurrentMoment().toLocalDate());
    }
}
