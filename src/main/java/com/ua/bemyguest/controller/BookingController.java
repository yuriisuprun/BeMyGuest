package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.BookingIncorrectId;
import com.ua.bemyguest.exception.BookingIncorrectStartDate;
import com.ua.bemyguest.exception.DuplicateBookingException;
import com.ua.bemyguest.model.Booking;
import com.ua.bemyguest.repository.BookingDAO;
import com.ua.bemyguest.repository.impl.BookingDAOH2Impl;
import com.ua.bemyguest.service.BookingService;

import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class BookingController {

    private BookingService bookingService = new BookingService();

    public void findBookingById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id of the booking:");
        int bookingId = scanner.nextInt();
        try {
            System.out.println(bookingService.findBookingById(bookingId));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findBookingByStartDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter start date of the booking in the format: YYYY-MM-DD");
        String startDate = scanner.nextLine();
        try {
            List<Booking> bookingList = bookingService.findBookingByStartDate(LocalDate.parse(startDate));
            ListIterator<Booking> bookingListIterator = bookingList.listIterator();
            while (bookingListIterator.hasNext()){
                System.out.println(bookingListIterator.next());
            }
        } catch (BookingIncorrectStartDate bookingIncorrectStartDate) {
            System.err.println("Incorrect start date!");
        }
    }

    public void printAllSortedBookings(){
        bookingService.printBookings(bookingService.findAllSortedBookings());
    }

    public void addBooking(){
        Booking booking = new Booking();
        Scanner scanner = new Scanner(System.in);

        // filling of the host object
        System.out.println("\nPlease, enter booking's data:");
        System.out.println("Enter accommodation id:");
        int accommodationId = scanner.nextInt();
        System.out.println("Enter guest id:");
        int guestId = scanner.nextInt();
        System.out.println("Enter start date of the booking in the format: YYYY-MM-DD");
        String startDate = scanner.next();
        System.out.println("Enter end date of the booking in the format: YYYY-MM-DD");
        String endDate = scanner.next();
        booking.setAccommodationId(accommodationId);
        booking.setGuestId(guestId);
        booking.setStartDate(LocalDate.parse(startDate));
        booking.setEndDate(LocalDate.parse(endDate));
        try {
            bookingService.addBooking(booking);
        } catch (DuplicateBookingException e) {
            e.printStackTrace();
        }
        System.out.println("The booking was added successfully!");
    }

    public void printBookings(){
        bookingService.printBookings(bookingService.getAllBookings());
    }

    public void updateBooking(){
        Scanner scanner = new Scanner(System.in);
        BookingDAO bookingDAO = new BookingDAOH2Impl();
        System.out.println("Enter booking's id for updating:");
        bookingService.printBookings(bookingService.getAllBookings());
        int n = scanner.nextInt() - 1;
        scanner.nextLine();
        Booking booking = bookingDAO.getAllBookings().get(n);
        System.out.println("Enter accommodation id: ");
        booking.setAccommodationId(scanner.nextInt());
        System.out.println("Enter guest id: ");
        booking.setGuestId(scanner.nextInt());
        System.out.println("Enter start date of booking:");
        booking.setStartDate(LocalDate.parse(scanner.next()));
        System.out.println("Enter end date of booking:");
        booking.setEndDate(LocalDate.parse(scanner.next()));
        bookingService.updateBooking(booking);
    }

    public void deleteBookingById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter booking's id for deleting:");
        int id = scanner.nextInt();
        try {
            bookingService.deleteBookingById(id);
            System.out.println("The booking was deleted successfully!");
        } catch (BookingIncorrectId bookingIncorrectId) {
            System.err.println("Incorrect id!");
        }
    }
}
