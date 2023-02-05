package com.misset.rma.service;

import com.misset.rma.model.Booking;
import com.misset.rma.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookingService extends AbstractRmaService<Booking> {

    private final BookingRepository bookingRepository;

    @Autowired
    protected BookingService(BookingRepository bookingRepository) {
        super(bookingRepository);
        this.bookingRepository = bookingRepository;
    }

    public Collection<Booking> getBookingsByResourceId(String id) {
        return bookingRepository.findAllByResource(id);
    }
}
