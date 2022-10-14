package com.katas.drivingLicense;

import com.katas.drivingLicense.chainOfResponsability.DrivingLicenceThirdStepHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrivingLicenceThirdStepHandlerShould {

    private DrivingLicenceThirdStepHandler handler;

    @BeforeEach
    void setUp() {
        handler = new DrivingLicenceThirdStepHandler();
    }

    @ParameterizedTest
    @CsvSource({"M,01", "F,51"})
    void returnTheMonthOfBirth(String gender, String expectedMonth) {
        CoolDriver driver = getTestDriverWithCustomGenderForJanuary(gender);

        String result = handler.handle(driver);

        assertEquals(expectedMonth, result);

    }

    private CoolDriver getTestDriverWithCustomGenderForJanuary(String genderUnderTest) {
        return CoolDriver.CoolDriverBuilder
                .newInstance()
                .setFirstName("Josh")
                .setMiddleName("Garcia")
                .setSurname("Smith")
                .setLocalDateFromString("12-Jan-2020")
                .setGenderFromString(genderUnderTest)
                .build();
    }


}
