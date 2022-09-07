package com.katas.bank.clock;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class AtomicBankClockTests {

    @Test
    @DisplayName("givenDateAndFormat_WhenPassedToClock_ThenClockReturnCorrectDateFormatted")
    void givenDateAndFormat_WhenPassedToClock_ThenClockReturnCorrectDateFormatted() {
        AtomicBankClock clockMock = spy(AtomicBankClock.class);

        String expectedLocalDate = "01/01/2022";

        when(clockMock.getCurrentLocalDate()).thenReturn(LocalDate.of(2022, Month.JANUARY, 1));
        String resultLocalDate = clockMock.getCurrentDateAsString();

        assertThat(resultLocalDate).isEqualTo(expectedLocalDate);


    }
}
