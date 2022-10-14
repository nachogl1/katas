package com.katas.drivingLicense;

import com.katas.drivingLicense.chainOfResponsability.DrivingLicenceSixthStepHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrivingLicenceSixthStepHandlerShould {

    private DrivingLicenceSixthStepHandler handler;

    @BeforeEach
    void setUp() {
        handler = new DrivingLicenceSixthStepHandler();
    }

    @Test
    void returnFirst2CharsOfFirstnameAndMiddlename() {
        CoolDriver driver = getTestDriverWithSCustomFirstNameAndMiddleName("Jose","Smith");

        String result = handler.handle(driver);

        assertEquals("JS", result);

    }

    @Test
    void returnFirst2CharsOfFirstnameAndTwo9sIfNotMiddlename() {
        CoolDriver driver = getTestDriverWithSCustomFirstNameAndMiddleName("Jose","");

        String result = handler.handle(driver);

        assertEquals("J9", result);

    }



    private CoolDriver getTestDriverWithSCustomFirstNameAndMiddleName(String firstnameUnderTest,String middlenameUnderTest) {
        return CoolDriver.CoolDriverBuilder.newInstance()
                .setFirstName("Josh")
                .setMiddleName(middlenameUnderTest)
                .setSurname(firstnameUnderTest)
                .setLocalDateFromString("14-Jan-2020")
                .setGenderFromString("M")
                .build();
    }

}
