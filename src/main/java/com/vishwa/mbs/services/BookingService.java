package com.vishwa.mbs.services;

import com.vishwa.mbs.entities.Booking;
import com.vishwa.mbs.exceptions.BookingDetailsNotFoundException;
import com.vishwa.mbs.exceptions.MovieTheatreDetailsNotFoundException;
import com.vishwa.mbs.exceptions.UserDetailsNotFoundException;

import java.util.List;

public interface BookingService {

    public Booking acceptBookingDetails(Booking booking) throws MovieTheatreDetailsNotFoundException,
            UserDetailsNotFoundException;
    public Booking getBookingDetails(int id) throws BookingDetailsNotFoundException;
    public boolean deleteBooking(int id) throws BookingDetailsNotFoundException;
    public List<Booking> getAllBookingDetails();

}
