package com.misset.rma.model.availability;

import org.apache.commons.lang3.Range;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class PatternTest {
    private static final int INTERVAL = 1;
    private final Pattern pattern = new Pattern() {
    };

    @Test
    void testSetFrom() {
        ZonedDateTime dateTime = ZonedDateTime.now();
        pattern.setFrom(dateTime);
        assertEquals(dateTime, pattern.getFrom());
    }

    @Test
    void testSetTo() {
        ZonedDateTime dateTime = ZonedDateTime.now();
        pattern.setTo(dateTime);
        assertEquals(dateTime, pattern.getTo());
    }

    @Test
    void testSetInterval() {
        pattern.setInterval(INTERVAL);
        assertEquals(INTERVAL, pattern.getInterval());
    }

    @Test
    void testComputeRange() {
        pattern.setFrom(ZonedDateTime.now().minus(2, ChronoUnit.DAYS));
        pattern.setTo(ZonedDateTime.now().minus(1, ChronoUnit.DAYS));
        Range<ZonedDateTime> zonedDateTimeRange = pattern.computeRange();
        assertFalse(zonedDateTimeRange.contains(ZonedDateTime.now()));
        assertTrue(zonedDateTimeRange.contains(ZonedDateTime.now().minus(36, ChronoUnit.HOURS)));
    }
}
