package com.misset.rma.model.availability;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AvailabilityTest {

    @Test
    void testSchema() {
        DailyPattern dailyPattern = new DailyPattern();
        Availability availability = new Availability();
        availability.setSchema(List.of(dailyPattern));
        assertTrue(availability.getSchema().contains(dailyPattern));
    }

    @Test
    void testOverrides() {
        DailyPattern dailyPattern = new DailyPattern();
        Availability availability = new Availability();
        availability.setOverrides(List.of(dailyPattern));
        assertTrue(availability.getOverrides().contains(dailyPattern));
    }

}
