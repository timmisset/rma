package com.misset.rma.service;

import com.misset.rma.repository.BookingRepository;
import com.misset.rma.service.impl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringBookingServiceImpl extends BookingServiceImpl {

    @Autowired
    protected SpringBookingServiceImpl(BookingRepository bookingRepository) {
        super(bookingRepository);
    }
}
