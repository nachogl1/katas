package com.katas.LeapYearChecker;

public class LeapYearSGChecker {
    public boolean isLeapYear(int year) {
        if (divisibleBy4(year) && divisibleBy100(year) && !divisibleBy400(year)) {
            return false;
        }

        if (!divisibleBy4(year)) {
            return false;
        }
        return true;
    }

    private boolean divisibleBy400(int year) {
        return year % 400 == 0;
    }

    private boolean divisibleBy100(int year) {
        return year % 100 == 0;
    }

    private boolean divisibleBy4(int year) {
        return year % 4 == 0;
    }
}
