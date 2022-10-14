package com.katas.drivingLicense;

import com.katas.drivingLicense.chainOfResponsability.DrivingLicenceFirstStepHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrivingLicenceFirstStepHandlerShould {

    private DrivingLicenceFirstStepHandler handler;

    @BeforeEach
    void setUp() {
        handler = new DrivingLicenceFirstStepHandler();
    }

    @Test
    void return5FirstLettersUppercaseIfSurnameIs5CharsLong() {
        CoolDriver driver = getTestDriverWithSCustomSurname("Smith");

        String result = handler.handle(driver);

        assertEquals("SMITH", result);

    }

    @Test
    void return5FirstLettersUppercaseIfSurnameIsMoreThan5CharsLong() {
        CoolDriver driver =getTestDriverWithSCustomSurname("Fernandez");

        String result = handler.handle(driver);

        assertEquals("FERNA", result);

    }

    @Test
    void returnSurnameWithTrailing9sIfShorterThan5Chars() {
        CoolDriver driver = getTestDriverWithSCustomSurname("Li");

        String result = handler.handle(driver);

        assertEquals("LI999", result);

    }


    private CoolDriver getTestDriverWithSCustomSurname(String surnameUnderTest) {
        return CoolDriver.CoolDriverBuilder.newInstance()
                .setFirstName("Josh")
                .setMiddleName("Garcia")
                .setSurname(surnameUnderTest)
                .setLocalDateFromString("14-Jan-2020")
                .setGenderFromString("M")
                .build();
    }


}
