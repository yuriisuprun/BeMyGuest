package com.ua.bemyguest.repository;

import com.ua.bemyguest.exception.BookingIncorrectId;
import com.ua.bemyguest.exception.BookingIncorrectStartDate;
import com.ua.bemyguest.exception.DuplicateBookingException;
import com.ua.bemyguest.model.Booking;

import java.time.LocalDate;
import java.util.List;

public interface BookingDAO {

    Booking findBookingById(int bookingId) throws BookingIncorrectId;

    Booking findBookingByStartDate(LocalDate bookingStartDate) throws BookingIncorrectStartDate;

    List<Booking> findAllSortedBookings();

    void addBooking(Booking booking) throws DuplicateBookingException;

    List<Booking> getAllBookings();

    void updateBooking(Booking booking);

    void deleteBookingById(int bookingId) throws BookingIncorrectId;
}
