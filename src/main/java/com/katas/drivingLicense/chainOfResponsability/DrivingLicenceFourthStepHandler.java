package com.katas.drivingLicense.chainOfResponsability;

import com.katas.drivingLicense.CoolDriver;

public class DrivingLicenceFourthStepHandler extends DriverLicenceHandler {

    @Override
    protected String executeStepLogic(CoolDriver driver) {
        String date = driver.getDate().toString();
        String resultOfCurrentStep = extractDateOfMonth(date);

        return resultOfCurrentStep;


    }

    private String extractDateOfMonth(String date) {
        return date.substring(8);
    }

}
