package com.misset.rma.controller;

import com.misset.rma.api.BookingApi;
import com.misset.rma.mapper.BookingMapper;
import com.misset.rma.model.Booking;
import com.misset.rma.service.impl.BookingServiceImpl;
import org.openapitools.model.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController implements BookingApi {

    private static final BookingMapper mapper = BookingMapper.INSTANCE;
    private final BookingServiceImpl bookingService;

    @Autowired
    public BookingController(BookingServiceImpl bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public BookingDto addBooking(BookingDto bookingDto) {
        Booking booking = mapper.fromDto(bookingDto);
        return mapper.toDto(bookingService.add(booking));
    }
}
