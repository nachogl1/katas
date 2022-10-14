package com.katas.drivingLicense;

import com.katas.drivingLicense.chainOfResponsability.DrivingLicenceFifthStepHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrivingLicenceFifthStepHandlerShould {
    private DrivingLicenceFifthStepHandler handler;

    @BeforeEach
    void setUp() {
        handler = new DrivingLicenceFifthStepHandler();
    }

    @ParameterizedTest
    @CsvSource({"12-Jan-2020,0", "13-Jan-2031,1"})
    void returnYearDigitOfBirthday(String date, String expectedYearNumber) {
        CoolDriver driver = getTestDriverWithSCustomBirthday(date);

        String result = handler.handle(driver);

        assertEquals(expectedYearNumber, result);

    }

    private CoolDriver getTestDriverWithSCustomBirthday(String dateUnderTest) {
        return CoolDriver.CoolDriverBuilder.newInstance().setFirstName("Josh").setMiddleName("Garcia").setSurname("Smith").setLocalDateFromString(dateUnderTest).setGenderFromString("M").build();
    }
}
