package com.katas.drivingLicense.chainOfResponsability;

import com.katas.drivingLicense.CoolDriver;

public abstract class DriverLicenceHandler {
    private DriverLicenceHandler nextHandler;
    private String licenceOnProgress = "";

    public DriverLicenceHandler cycleHandler(DriverLicenceHandler handler) {
        this.nextHandler = handler;
        return this.nextHandler;
    }

    public final String handle(CoolDriver driver) {
        this.licenceOnProgress += executeStepLogic(driver);
        return handleNext(driver);
    }

    void setLicenceOnProgress(String licenceOnProgress) {
        this.licenceOnProgress += licenceOnProgress;
    }

    protected abstract String executeStepLogic(CoolDriver driver);

    private String handleNext(CoolDriver driver) {
        if (this.nextHandler == null) return this.licenceOnProgress.toUpperCase();

        this.nextHandler.prepare(this.licenceOnProgress);
        return this.nextHandler.handle(driver);
    }


    private void prepare(String licenceOnProgress) {
        setLicenceOnProgress(licenceOnProgress);
    }
}
