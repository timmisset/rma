package com.misset.rma.model.availability;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WeeklyPatternTest {

    private WeeklyPattern weeklyPattern = new WeeklyPattern();

    @Test
    void testSetWeekDays() {
        List<DayOfWeek> dayOfWeeks = List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY);
        weeklyPattern.setWeekDays(dayOfWeeks);
        assertTrue(weeklyPattern.getWeekDays().containsAll(dayOfWeeks));
    }

    @Test
    void testAddWeekDays() {
        List<DayOfWeek> dayOfWeeks = List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY);
        weeklyPattern.setWeekDays(dayOfWeeks);
        weeklyPattern.addWeekDay(DayOfWeek.FRIDAY);
        assertTrue(weeklyPattern.getWeekDays().containsAll(dayOfWeeks));
        assertTrue(weeklyPattern.getWeekDays().contains(DayOfWeek.FRIDAY));
    }
}
