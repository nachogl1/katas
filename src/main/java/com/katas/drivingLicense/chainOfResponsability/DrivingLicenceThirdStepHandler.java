package com.katas.drivingLicense.chainOfResponsability;

import com.katas.drivingLicense.CoolDriver;

public class DrivingLicenceThirdStepHandler extends DriverLicenceHandler {
    @Override
    protected String executeStepLogic(CoolDriver driver) {
        String resultOfCurrentStep = "";
        String date = driver.getDate().toString();

        String month = extractMonth(date);
        String[] monthDigits = month.split("");

        add5ToFirstDigitIfFemale(driver, monthDigits);
        resultOfCurrentStep = String.join("", monthDigits);

        return resultOfCurrentStep;
    }

    private void add5ToFirstDigitIfFemale(CoolDriver driver, String[] monthDigits) {
        if (driver.isFemale()) {
            int firstDigit = Integer.parseInt(monthDigits[0]);
            firstDigit += 5;
            monthDigits[0] = String.valueOf(firstDigit);
        }
    }

    private String extractMonth(String date) {
        String month = date.substring(5, 7);
        return month;
    }
}
