package com.misset.rma.model;

import com.misset.rma.model.availability.Availability;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResourceTest {

    private static final String ID = "id";

    @Test
    void testResourceConstructor() {
        Resource resource = new Resource(ID);
        assertEquals(ID, resource.getId());
    }

    @Test
    void testSetAvailability() {
        Availability availability = new Availability();
        Resource resource = new Resource();
        resource.setAvailability(availability);
        assertEquals(availability, resource.getAvailability());
    }

}
