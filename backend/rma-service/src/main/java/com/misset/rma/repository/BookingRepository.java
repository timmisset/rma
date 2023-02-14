package com.misset.rma.repository;

import com.misset.rma.model.Booking;

import java.util.List;

public interface BookingRepository extends Repository<Booking> {

    List<Booking> findAllByResource(String resourceId);

}
