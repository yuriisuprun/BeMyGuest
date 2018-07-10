package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.BookingIncorrectId;
import com.ua.bemyguest.exception.BookingIncorrectStartDate;
import com.ua.bemyguest.model.Booking;
import com.ua.bemyguest.service.BookingService;

import java.time.LocalDate;
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
            System.out.println(bookingService.findBookingByStartDate(LocalDate.parse(startDate)));
        } catch (BookingIncorrectStartDate bookingIncorrectStartDate) {
            bookingIncorrectStartDate.printStackTrace();
        }
    }

    public void findAllSortedBookings(){
        bookingService.printBookings(bookingService.findAllSortedBookings());
    }

    public void addBooking(){
        Booking booking = new Booking();
        Scanner scanner = new Scanner(System.in);

        // filling of the host object
        System.out.println("\nPlease, enter host's data:");
        System.out.println("Enter start date of the booking in the format: YYYY-MM-DD");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date of the booking in the format: YYYY-MM-DD");
        String endDate = scanner.nextLine();
        booking.setStartDate(LocalDate.parse(startDate));
        booking.setEndDate(LocalDate.parse(endDate));
    }

    public void printBookings(){
        bookingService.printBookings(bookingService.getAllBookings());
    }

    public void updateBooking(){

    }

    public void deleteBookingById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter booking's id for deleting:");
        int id = scanner.nextInt();
        try {
            bookingService.deleteBookingById(id);
        } catch (BookingIncorrectId bookingIncorrectId) {
            bookingIncorrectId.printStackTrace();
        }
        System.out.println("Booking deleted.");
    }
}
