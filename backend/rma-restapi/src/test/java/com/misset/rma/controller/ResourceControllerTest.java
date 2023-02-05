package com.misset.rma.controller;

import com.misset.rma.model.Booking;
import com.misset.rma.model.Resource;
import com.misset.rma.service.BookingService;
import com.misset.rma.service.ResourceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.BookingDto;
import org.openapitools.model.ResourceDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    ResourceService resourceService;

    @Mock
    BookingService bookingService;

    @InjectMocks
    ResourceController resourceController;

    @Test
    void testAddResourceReturnsResource() {
        // ARRANGE
        when(resourceService.add(any(Resource.class))).thenAnswer(invocation -> invocation.getArguments()[0]);

        // ACT
        ResponseEntity<ResourceDto> responseEntity = resourceController.addResource(new ResourceDto());

        // ASSERT
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testUpdateResourceUpdatesResource() {
        // ARRANGE
        when(resourceService.update(eq(ID), any(Resource.class))).thenAnswer(invocation -> invocation.getArguments()[1]);

        // ACT
        ResponseEntity<ResourceDto> responseEntity = resourceController.updateResource(ID, new ResourceDto());

        // ASSERT
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetResource() {
        // ARRANGE
        when(resourceService.get(ID)).thenReturn(new Resource());

        // ACT
        ResponseEntity<ResourceDto> responseEntity = resourceController.getResource(ID);

        // ASSERT
        assertNotNull(responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetResourcesReturnsAllResources() {
        // ARRANGE
        when(resourceService.getAll()).thenReturn(Arrays.asList(new Resource(), new Resource()));

        // ACT
        ResponseEntity<List<ResourceDto>> resources = resourceController.getResources();

        // ASSERT
        assertEquals(2, resources.getBody().size());
        assertEquals(HttpStatus.OK, resources.getStatusCode());
    }

    @Test
    void testGetResourceBookings() {
        // ARRANGE
        when(bookingService.getBookingsByResourceId(ID)).thenReturn(Arrays.asList(new Booking(), new Booking()));

        // ACT
        ResponseEntity<List<BookingDto>> bookings = resourceController.getResourceBookings(ID);

        // ASSERT
        assertEquals(2, bookings.getBody().size());
        assertEquals(HttpStatus.OK, bookings.getStatusCode());

    }
}
