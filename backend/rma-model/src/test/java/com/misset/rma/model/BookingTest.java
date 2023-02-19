package com.misset.rma.model;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingTest {

    private static final Booking booking = new Booking();

    private static final String ID = "id";

    @Test
    void testConstructor() {
        Booking bookingWithId = new Booking(ID);
        assertEquals(ID, bookingWithId.getId());
    }

    @Test
    void testGetterSettersFromDate() {
        ZonedDateTime dateTime = ZonedDateTime.now();

        booking.setFromDateTime(dateTime);
        assertEquals(dateTime, booking.getFromDateTime());
    }

    @Test
    void testGetterSettersToDate() {
        ZonedDateTime dateTime = ZonedDateTime.now();

        booking.setToDateTime(dateTime);
        assertEquals(dateTime, booking.getToDateTime());
    }

    @Test
    void testGetterSetterResource() {
        String resource = "resourceId";
        booking.setResource(resource);
        assertEquals(resource, booking.getResource());
    }

    @Test
    void testGetterSetterProject() {
        String project = "resourceId";
        booking.setProject(project);
        assertEquals(project, booking.getProject());
    }

    @Test
    void testConstructorWithId() {
        String id = "id";
        Project project = new Project(id);
        assertEquals(id, project.getId());
    }
}
