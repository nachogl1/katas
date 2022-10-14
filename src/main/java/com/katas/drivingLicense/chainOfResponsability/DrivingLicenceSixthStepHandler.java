package com.katas.drivingLicense.chainOfResponsability;

import com.katas.drivingLicense.CoolDriver;

public class DrivingLicenceSixthStepHandler extends DriverLicenceHandler {
    @Override
    protected String stepLogic(CoolDriver driver) {
        StringBuilder resultOfCurrentStep = new StringBuilder();

        resultOfCurrentStep.append(driver.getFirstName(), 0, 1);
        //Assume only one letter is not allowed
        String middleName = driver.getMiddleName();
        middleName += "9";
        resultOfCurrentStep.append(middleName, 0, 1);

        return resultOfCurrentStep.toString();
    }
}
