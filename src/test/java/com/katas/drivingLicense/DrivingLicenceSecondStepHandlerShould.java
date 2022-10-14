package com.katas.drivingLicense;

import com.katas.drivingLicense.chainOfResponsability.DrivingLicenceSecondStepHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrivingLicenceSecondStepHandlerShould {
    private DrivingLicenceSecondStepHandler handler;

    @BeforeEach
    void setUp() {
        handler = new DrivingLicenceSecondStepHandler();
    }

    @ParameterizedTest
    @CsvSource({"12-Jan-2020,2", "12-Jan-2030,3"})
    void returnTheDecadeOfTheBirthday(String date, String expectedDecade) {
        CoolDriver driver = getTestDriverWithSCustomBirthday(date);

        String result = handler.handle(driver);

        assertEquals(expectedDecade, result);

    }

    private CoolDriver getTestDriverWithSCustomBirthday(String dateUnderTest) {
        return CoolDriver.CoolDriverBuilder.newInstance().setFirstName("Josh").setMiddleName("Garcia").setSurname("Smith").setLocalDateFromString(dateUnderTest).setGenderFromString("M").build();
    }
}
