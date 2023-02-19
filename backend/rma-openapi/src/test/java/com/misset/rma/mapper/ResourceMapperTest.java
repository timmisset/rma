package com.misset.rma.mapper;

import com.misset.rma.model.*;
import com.misset.rma.model.availability.DailyPattern;
import com.misset.rma.model.availability.Pattern;
import com.misset.rma.model.availability.WeeklyPattern;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResourceMapperTest {

    @Test
    void testSetsIdViaConstructor() {
        String id = "id";
        Resource resource = ResourceMapper.INSTANCE.fromDto(new ResourceDto().id(id));
        assertEquals(id, resource.getId());
    }

    @Test
    void testSetsAvailabilityDailyPattern() {
        ResourceDto resourceDto = new ResourceDto().availability(
                new AvailabilityDto().addSchemaItem(
                        new PatternDto().patternDetails(
                                new PatternPatternDetailsDto().weekdays(true)
                        ))
        );
        Resource resource = ResourceMapper.INSTANCE.fromDto(resourceDto);
        Pattern pattern = resource.getAvailability().getSchema().iterator().next();
        assertTrue(pattern instanceof DailyPattern);
        assertTrue(((DailyPattern) pattern).isWeekDays());
    }

    @Test
    void testSetsAvailabilityWeeklyPattern() {
        ResourceDto resourceDto = new ResourceDto().availability(
                new AvailabilityDto().addSchemaItem(
                        new PatternDto().patternDetails(
                                new PatternPatternDetailsDto().days(
                                        List.of(PatternPatternDetailsDto.DaysEnum.MONDAY, PatternPatternDetailsDto.DaysEnum.TUESDAY)
                                )
                        ))
        );
        Resource resource = ResourceMapper.INSTANCE.fromDto(resourceDto);
        Pattern pattern = resource.getAvailability().getSchema().iterator().next();
        assertTrue(pattern instanceof WeeklyPattern);
        assertTrue(((WeeklyPattern) pattern).getWeekDays().containsAll(List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY)));
    }

}
