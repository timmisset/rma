package com.misset.rma.model;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookingTest {

    private static final Booking booking = new Booking();

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
        Resource resource = new Resource();
        booking.setResource(resource);
        assertEquals(resource, booking.getResource());
    }

    @Test
    void testGetterSetterProject() {
        Project project = new Project();
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
