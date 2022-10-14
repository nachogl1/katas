package com.katas.drivingLicense.chainOfResponsability;

import com.katas.drivingLicense.CoolDriver;

public class DrivingLicenceSecondStepHandler extends DriverLicenceHandler {

    @Override
    protected String stepLogic(CoolDriver driver) {

        String date = driver.getDate().toString();
        char decade = extractDecade(date);
        String resultOfCurrentStep = String.valueOf(decade);

        return resultOfCurrentStep;

    }

    private char extractDecade(String date) {
        char decade = date.charAt(2);
        return decade;
    }

}
