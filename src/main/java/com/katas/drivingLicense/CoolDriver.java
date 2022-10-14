package com.katas.drivingLicense;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CoolDriver {
    private final String firstName;
    private final String middleName;
    private final String surname;
    private final LocalDate date;
    private final DrivingGender gender;

    private CoolDriver(String firstName, String middleName, String surname, LocalDate date, DrivingGender gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.date = date;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isFemale() {
        return gender == DrivingGender.F;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CoolDriver{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", date=").append(date);
        sb.append(", gender=").append(gender);
        sb.append('}');
        return sb.toString();
    }

    public static class CoolDriverBuilder {
        private String firstName;
        private String middleName;
        private String surname;
        private LocalDate date;
        private DrivingGender gender;

        public static CoolDriverBuilder newInstance() {
            return new CoolDriverBuilder();
        }


        public CoolDriverBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }


        public CoolDriverBuilder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public CoolDriverBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }


        public CoolDriverBuilder setLocalDateFromString(String date) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
            formatter = formatter.withLocale(Locale.UK);
            this.date = LocalDate.parse(date, formatter);
            return this;
        }


        public CoolDriverBuilder setGenderFromString(String gender) {
            this.gender = DrivingGender.valueOf(gender);
            return this;
        }

        public CoolDriver build() {
            return new CoolDriver(this.firstName, this.middleName, this.surname, this.date, this.gender);
        }
    }
}
