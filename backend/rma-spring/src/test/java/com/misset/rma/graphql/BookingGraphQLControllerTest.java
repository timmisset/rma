package com.misset.rma.graphql;

import com.misset.rma.model.Booking;
import com.misset.rma.model.Project;
import com.misset.rma.model.Resource;
import com.misset.rma.service.BookingService;
import com.misset.rma.service.ProjectService;
import com.misset.rma.service.ResourceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingGraphQLControllerTest {

    @Mock
    BookingService bookingService;

    @Mock
    ProjectService projectService;

    @Mock
    ResourceService resourceService;

    @InjectMocks
    BookingGraphQLController bookingGraphQLController;

    @Test
    void testBookings() {
        // ARRANGE
        Booking booking = new Booking();
        when(bookingService.getAll()).thenReturn(Collections.singletonList(booking));

        // ACT
        List<Booking> result = bookingGraphQLController.bookings();

        // ASSERT
        assertTrue(result.contains(booking));
    }

    @Test
    void testResource() {
        // ARRANGE
        Booking booking = new Booking();
        booking.setResource("resourceA");
        Resource resource = new Resource();

        when(resourceService.get("resourceA")).thenReturn(resource);

        // ACT
        Resource result = bookingGraphQLController.resource(booking);

        // ASSERT
        assertEquals(resource, result);
    }

    @Test
    void testProject() {
        // ARRANGE
        Booking booking = new Booking();
        booking.setProject("projectA");
        Project project = new Project();

        when(projectService.get("projectA")).thenReturn(project);

        // ACT
        Project result = bookingGraphQLController.project(booking);

        // ASSERT
        assertEquals(project, result);

    }
}
