package com.katas.smartFridge.core.ports;

import java.time.LocalDateTime;

public interface IClock {
    LocalDateTime getCurrentMoment();
}
