package com.katas.drivingLicense;

public enum DrivingGender {
    M("MALE"), F("FEMALE");

    private final String gender;

    DrivingGender(String gender) {
        this.gender = gender;
    }
}
