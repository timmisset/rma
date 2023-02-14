package com.misset.rma.controller;

import com.misset.rma.model.Booking;
import com.misset.rma.model.Resource;
import com.misset.rma.service.impl.BookingServiceImpl;
import com.misset.rma.service.impl.ResourceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.BookingDto;
import org.openapitools.model.ResourceDto;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResourceControllerTest {

    private static final String ID = "id";

    @Mock
    ResourceServiceImpl resourceService;

    @Mock
    BookingServiceImpl bookingService;

    @InjectMocks
    ResourceController resourceController;

    @Test
    void testAddResourceReturnsResource() {
        // ARRANGE
        when(resourceService.add(any(Resource.class))).thenAnswer(invocation -> invocation.getArguments()[0]);

        // ACT
        ResourceDto resourceDto = resourceController.addResource(new ResourceDto());

        // ASSERT
        assertNotNull(resourceDto);
    }

    @Test
    void testUpdateResourceUpdatesResource() {
        // ARRANGE
        when(resourceService.update(eq(ID), any(Resource.class))).thenAnswer(invocation -> invocation.getArguments()[1]);

        // ACT
        ResourceDto resourceDto = resourceController.updateResource(ID, new ResourceDto());

        // ASSERT
        assertNotNull(resourceDto);
    }

    @Test
    void testGetResource() {
        // ARRANGE
        when(resourceService.get(ID)).thenReturn(new Resource());

        // ACT
        ResourceDto resourceDto = resourceController.getResource(ID);

        // ASSERT
        assertNotNull(resourceDto);
    }

    @Test
    void testGetResourcesReturnsAllResources() {
        // ARRANGE
        when(resourceService.getAll()).thenReturn(Arrays.asList(new Resource(), new Resource()));

        // ACT
        List<ResourceDto> resources = resourceController.getResources();

        // ASSERT
        assertEquals(2, resources.size());
    }

    @Test
    void testGetResourceBookings() {
        // ARRANGE
        when(bookingService.getBookingsByResourceId(ID)).thenReturn(Arrays.asList(new Booking(), new Booking()));

        // ACT
        List<BookingDto> bookings = resourceController.getResourceBookings(ID);

        // ASSERT
        assertEquals(2, bookings.size());

    }
}
