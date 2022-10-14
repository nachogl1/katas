package com.katas.drivingLicense;

import com.katas.drivingLicense.chainOfResponsability.*;

public class DrivingLicenseService {
    public String processDriver(CoolDriver driver) {
        DriverLicenceHandler handler = new DrivingLicenceFirstStepHandler();

        handler.cycleHandler(new DrivingLicenceSecondStepHandler())
                .cycleHandler(new DrivingLicenceThirdStepHandler())
                .cycleHandler(new DrivingLicenceFourthStepHandler())
                .cycleHandler(new DrivingLicenceFifthStepHandler())
                .cycleHandler(new DrivingLicenceSixthStepHandler())
                .cycleHandler(new DrivingLicenceSeventhStepHandler());

        return handler.handle(driver);
    }
}
