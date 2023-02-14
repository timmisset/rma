package com.misset.rma.service.impl;

import com.misset.rma.model.Booking;
import com.misset.rma.repository.BookingRepository;
import com.misset.rma.service.BookingService;

import java.util.Collection;

public class BookingServiceImpl extends AbstractRmaService<Booking> implements BookingService {

    private final BookingRepository bookingRepository;

    protected BookingServiceImpl(BookingRepository bookingRepository) {
        super(bookingRepository);
        this.bookingRepository = bookingRepository;
    }

    public Collection<Booking> getBookingsByResourceId(String id) {
        return bookingRepository.findAllByResource(id);
    }
}
