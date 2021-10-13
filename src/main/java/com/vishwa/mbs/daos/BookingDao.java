package com.vishwa.mbs.daos;

import com.vishwa.mbs.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Booking, Integer> {
}
