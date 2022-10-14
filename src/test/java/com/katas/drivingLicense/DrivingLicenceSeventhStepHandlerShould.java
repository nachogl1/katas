package com.katas.drivingLicense;

import com.katas.drivingLicense.chainOfResponsability.DrivingLicenceSeventhStepHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrivingLicenceSeventhStepHandlerShould {
    private DrivingLicenceSeventhStepHandler handler;

    @BeforeEach
    void setUp() {
        handler = new DrivingLicenceSeventhStepHandler();
    }

    @Test
    void return9AA() {
        CoolDriver driver = getTestDriver();

        String result = handler.handle(driver);

        assertEquals("9AA", result);

    }


    private CoolDriver getTestDriver() {
        return CoolDriver.CoolDriverBuilder.newInstance()
                .setFirstName("Josh")
                .setMiddleName("Garcia")
                .setSurname("Fernandez")
                .setLocalDateFromString("14-Jan-2020")
                .setGenderFromString("M")
                .build();
    }
}
