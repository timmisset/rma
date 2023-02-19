package com.misset.rma.model.availability;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
