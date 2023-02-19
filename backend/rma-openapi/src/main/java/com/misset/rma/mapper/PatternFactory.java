package com.misset.rma.mapper;

import com.misset.rma.model.PatternDto;
import com.misset.rma.model.PatternPatternDetailsDto;
import com.misset.rma.model.availability.DailyPattern;
import com.misset.rma.model.availability.Pattern;
import com.misset.rma.model.availability.WeeklyPattern;

import java.time.DayOfWeek;
import java.util.List;

public class PatternFactory {
    private PatternFactory() {
        // empty constructor
    }

    public static Pattern createPattern(PatternDto patternDto) {
        PatternPatternDetailsDto patternDetails = patternDto.getPatternDetails();
        if (patternDetails.getWeekdays() != null || patternDetails.getWeekends() != null) {
            return createDailyPattern(patternDetails);
        } else {
            return createWeeklyPattern(patternDetails);
        }
    }

    private static DailyPattern createDailyPattern(PatternPatternDetailsDto patternDetails) {
        DailyPattern dailyPattern = new DailyPattern();
        dailyPattern.setWeekDays(Boolean.TRUE.equals(patternDetails.getWeekdays()));
        dailyPattern.setWeekendDays(Boolean.TRUE.equals(patternDetails.getWeekends()));
        return dailyPattern;
    }

    private static WeeklyPattern createWeeklyPattern(PatternPatternDetailsDto patternDetails) {
        WeeklyPattern weeklyPattern = new WeeklyPattern();
        weeklyPattern.setWeekDays(toDaysOfWeek(patternDetails.getDays()));
        return weeklyPattern;
    }

    private static List<DayOfWeek> toDaysOfWeek(List<PatternPatternDetailsDto.DaysEnum> days) {
        return days.stream().map(daysEnum -> DayOfWeek.valueOf(daysEnum.name())).toList();
    }

}
