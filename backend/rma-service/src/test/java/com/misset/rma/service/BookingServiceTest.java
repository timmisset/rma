package com.misset.rma.service;

import com.misset.rma.model.Booking;
import com.misset.rma.model.Resource;
import com.misset.rma.repository.BookingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    private final static String ID = "id";

    @Mock
    BookingRepository bookingRepository;

    @InjectMocks
    BookingService bookingService;

    @Test
    void testGetBookings() {
        // ARRANGE
        Booking booking = new Booking();
        Resource resource = new Resource(ID);
        when(bookingRepository.findAllByResource(ID)).thenReturn(List.of(booking));

        // ACT
        Collection<Booking> bookings = bookingService.getBookingsByResourceId(resource.getId());

        // ASSERT
        assertTrue(bookings.contains(booking));
    }
}
