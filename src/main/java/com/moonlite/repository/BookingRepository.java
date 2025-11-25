package com.moonlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moonlite.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
