package com.misset.rma.controller;

import com.misset.rma.model.Booking;
import com.misset.rma.service.BookingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.BookingDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingControllerTest {

    @Mock
    BookingService bookingService;

    @InjectMocks
    BookingController bookingController;

    @Test
    void testAddBooking() {
        // ARRANGE
        BookingDto bookingDto = new BookingDto()
                .project("projectA")
                .resource("resourceA")
                .fromDateTime(ZonedDateTime.now());
        when(bookingService.add(any(Booking.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // ACT

        ResponseEntity<BookingDto> bookingDtoResponseEntity = bookingController.addBooking(bookingDto);

        // ASSERT
        assertEquals(HttpStatus.OK, bookingDtoResponseEntity.getStatusCode());
        BookingDto savedBooking = bookingDtoResponseEntity.getBody();
        assertNull(bookingDto.getId());
        assertNotNull(savedBooking.getId());
        assertEquals("projectA", savedBooking.getProject());
        assertEquals("resourceA", savedBooking.getResource());
    }
}
