package com.katas.drivingLicense.chainOfResponsability;

import com.katas.drivingLicense.CoolDriver;

public class DrivingLicenceFifthStepHandler extends DriverLicenceHandler {
    @Override
    protected String executeStepLogic(CoolDriver driver) {
        String date = driver.getDate().toString();
        String resultOfStep = date.substring(3,4);
        return resultOfStep;

    }
}
