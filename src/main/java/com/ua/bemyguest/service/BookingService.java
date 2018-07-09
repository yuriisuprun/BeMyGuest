package com.ua.bemyguest.service;

import com.ua.bemyguest.exception.BookingIncorrectId;
import com.ua.bemyguest.exception.BookingIncorrectStartDate;
import com.ua.bemyguest.exception.DuplicateBookingException;
import com.ua.bemyguest.model.Booking;
import com.ua.bemyguest.repository.impl.BookingDAOH2Impl;

import java.time.LocalDate;
import java.util.List;

public class BookingService {

    private BookingDAOH2Impl bookingDAOH2;

    public BookingService() {
        bookingDAOH2 = BookingDAOH2Impl.instance();
    }

    public void findBookingById(int bookingId) throws BookingIncorrectId{

    }

    public Booking findBookingByStartDate(LocalDate bookingStartDate) throws BookingIncorrectStartDate{
        return bookingDAOH2.findBookingByStartDate(bookingStartDate);
    }

    public List<Booking> findAllSortedBookings(){
        return bookingDAOH2.findAllSortedBookings();
    }

    public void addBooking(Booking booking) throws DuplicateBookingException{
        bookingDAOH2.addBooking(booking);
    }

    public List<Booking> getAllBookings(){
        return bookingDAOH2.getAllBookings();
    }

    public void updateBooking(Booking booking){
        bookingDAOH2.updateBooking(booking);
    }

    public void deleteBookingById(int bookingId) throws BookingIncorrectId{
        bookingDAOH2.deleteBookingById(bookingId);
    }

    public void printBookings(List<Booking> bookings){
        for (Booking booking : getAllBookings()) {
            System.out.println(booking);
        }
    }
}
