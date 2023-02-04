package com.misset.rma.repository;

import com.misset.rma.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, String> {

    List<Booking> findAllByResourceId(String resourceId);

}
