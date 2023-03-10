package com.misset.rma.repository;

import com.misset.rma.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringBookingRepository extends JpaRepository<Booking, String>, BookingRepository {

    List<Booking> findAllByResource(String resourceId);

}
