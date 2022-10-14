package com.katas.drivingLicense;

import com.katas.drivingLicense.CoolDriver.CoolDriverBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrivingLicenseServiceShould {

    DrivingLicenseService service;

    @BeforeEach
    void setUp() {
        service = new DrivingLicenseService();
    }

    @ParameterizedTest
    @CsvSource({
            "John,James,Smith,01-Jan-2000,M,SMITH001010JJ9AA"
            , "Johna,James,Smith,01-Jan-2000,F,SMITH051010JJ9AA"
            , "John,James,Li,01-Jan-2000,M,LI999001010JJ9AA"
            , "Johna,James,Li,01-Jan-2000,F,LI999051010JJ9AA"
    })
    void givenDriverInfoWhenProcessingInfoThenReturnCorrectDrivingLicense(String firstName, String middleName, String surname, String date, String gender, String expectedLicenseNumber) {
        CoolDriver driver = CoolDriverBuilder.newInstance()
                .setFirstName(firstName)
                .setMiddleName(middleName)
                .setSurname(surname)
                .setLocalDateFromString(date)
                .setGenderFromString(gender)
                .build();

        String resultLicenseNumber = service.processDriver(driver);

        assertEquals(expectedLicenseNumber, resultLicenseNumber);
    }
}
