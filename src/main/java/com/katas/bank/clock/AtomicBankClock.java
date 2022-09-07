package com.katas.bank.clock;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class AtomicBankClock implements BankClock {

    @Override
    public String getCurrentDateAsString() {
        LocalDate date = getCurrentLocalDate();
        DateTimeFormatter formatter = getLocalDateFormatter();
        return formatter.format(date);
    }

    protected LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    private DateTimeFormatter getLocalDateFormatter() {
        return DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.ENGLISH);
    }

}
