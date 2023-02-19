package com.misset.rma.service.impl;

import com.misset.rma.logging.PatternOverlapException;
import com.misset.rma.model.Resource;
import com.misset.rma.model.availability.Availability;
import com.misset.rma.model.availability.DailyPattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ResourceServiceImplTest {

    @InjectMocks
    ResourceServiceImpl resourceService;

    @Test
    void testCreatesService() {
        assertNotNull(resourceService);
    }

    @Test
    void testCanPersistThrowsOnSchemaOverlap() {
        Resource resource = new Resource();
        Availability availability = new Availability();
        DailyPattern dailyPattern = new DailyPattern();
        dailyPattern.setFrom(ZonedDateTime.now().minus(5, ChronoUnit.DAYS));
        dailyPattern.setTo(ZonedDateTime.now().minus(3, ChronoUnit.DAYS));

        DailyPattern dailyPattern2 = new DailyPattern();
        dailyPattern2.setFrom(ZonedDateTime.now().minus(4, ChronoUnit.DAYS));
        dailyPattern2.setTo(ZonedDateTime.now().minus(2, ChronoUnit.DAYS));

        availability.setSchema(List.of(dailyPattern, dailyPattern2));
        resource.setAvailability(availability);

        assertThrows(PatternOverlapException.class, () -> resourceService.canPersist(resource));

    }

    @Test
    void testCanPersistThrowsOnOverridesOverlap() {
        Resource resource = new Resource();
        Availability availability = new Availability();
        DailyPattern dailyPattern = new DailyPattern();
        dailyPattern.setFrom(ZonedDateTime.now().minus(5, ChronoUnit.DAYS));
        dailyPattern.setTo(ZonedDateTime.now().minus(3, ChronoUnit.DAYS));

        DailyPattern dailyPattern2 = new DailyPattern();
        dailyPattern2.setFrom(ZonedDateTime.now().minus(4, ChronoUnit.DAYS));
        dailyPattern2.setTo(ZonedDateTime.now().minus(2, ChronoUnit.DAYS));

        availability.setOverrides(List.of(dailyPattern, dailyPattern2));
        resource.setAvailability(availability);

        assertThrows(PatternOverlapException.class, () -> resourceService.canPersist(resource));

    }
}
