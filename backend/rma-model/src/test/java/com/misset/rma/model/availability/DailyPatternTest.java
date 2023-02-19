package com.misset.rma.model.availability;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DailyPatternTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testIsWeekDays(boolean isWeekDays) {
        DailyPattern dailyPattern = new DailyPattern();
        dailyPattern.setWeekDays(isWeekDays);
        assertEquals(isWeekDays, dailyPattern.isWeekDays());
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void testIsWeekendDays(boolean isWeekendDays) {
        DailyPattern dailyPattern = new DailyPattern();
        dailyPattern.setWeekendDays(isWeekendDays);
        assertEquals(isWeekendDays, dailyPattern.isWeekendDays());
    }
}
