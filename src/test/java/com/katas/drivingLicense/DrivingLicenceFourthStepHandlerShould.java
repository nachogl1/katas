package com.katas.drivingLicense;

import com.katas.drivingLicense.chainOfResponsability.DrivingLicenceFourthStepHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrivingLicenceFourthStepHandlerShould {
    private DrivingLicenceFourthStepHandler handler;

    @BeforeEach
    void setUp() {
        handler = new DrivingLicenceFourthStepHandler();
    }

    @ParameterizedTest
    @CsvSource({"12-Jan-2020,12", "13-Jan-2030,13"})
    void returnTheDateWithinMonthOfBirth(String date, String expectedDateOfMonth) {
        CoolDriver driver = getTestDriverWithSCustomBirthday(date);

        String result = handler.handle(driver);

        assertEquals(expectedDateOfMonth, result);

    }

    private CoolDriver getTestDriverWithSCustomBirthday(String dateUnderTest) {
        return CoolDriver.CoolDriverBuilder.newInstance().setFirstName("Josh").setMiddleName("Garcia").setSurname("Smith").setLocalDateFromString(dateUnderTest).setGenderFromString("M").build();
    }
}
