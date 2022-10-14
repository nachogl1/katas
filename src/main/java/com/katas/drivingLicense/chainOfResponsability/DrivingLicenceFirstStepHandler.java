package com.katas.drivingLicense.chainOfResponsability;

import com.katas.drivingLicense.CoolDriver;

public class DrivingLicenceFirstStepHandler extends DriverLicenceHandler {


    @Override
    protected String stepLogic(CoolDriver driver) {

        String resultOfCurrentStep = driver.getSurname();
        resultOfCurrentStep = addTrailing9s(resultOfCurrentStep);
        resultOfCurrentStep = resultOfCurrentStep.substring(0, 5);

        return resultOfCurrentStep;

    }

    private String addTrailing9s(String result) {
        return result + "99999";
    }
}
