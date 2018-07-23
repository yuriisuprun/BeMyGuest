package com.ua.bemyguest.controller;

import java.util.Scanner;

public class MainController {

    // ANSI codes
    private static final String RESET = "\033[0m";
    private static final String YELLOW = "\033[0;33m";
    private static final String BLUE = "\033[0;34m";
    private static final String PURPLE = "\033[0;35m";
    private static final String CYAN = "\033[0;36m";
    private static final String BLACK_UNDERLINED = "\033[4;30m";
    private static final String GREEN_BOLD_BRIGHT = "\033[1;92m";

    private AccommodationController accommodationController = new AccommodationController();
    private BookingController bookingController = new BookingController();
    private GuestDetailController guestDetailController = new GuestDetailController();
    private GuestController guestController = new GuestController();
    private HostController hostController = new HostController();

    Scanner scanner = new Scanner(System.in);

    public void doWork() {
        showHelloMessage();
        while (true) {
            System.out.println();
            showMainMenu();
            makeMainChoice();
        }
    }

    private void showMainMenu(){
        System.out.println("Please, enter the code of an operation...");
        System.out.println("1 - OPERATIONS WITH ACCOMMODATION.");
        System.out.println("2 - OPERATIONS WITH HOSTS.");
        System.out.println("3 - OPERATIONS WITH GUESTS.");
        System.out.println("4 - OPERATIONS WITH BOOKINGS.");
        System.out.println("5 - OPERATIONS WITH GUEST DETAILS.");
        System.out.println("\n0 - For exit.");
    }

    private void makeMainChoice(){
        int choice = scanner.nextInt();
        switch (choice){
            case 1:{
                System.out.println(BLACK_UNDERLINED);
                System.out.println("OPERATIONS WITH ACCOMMODATION");
                System.out.println(YELLOW);
                System.out.println("6 - Show available accommodations.");
                System.out.println("7 - Show sorted accommodations.");
                System.out.println("8 - Add new accommodation.");
                System.out.println("9 - Find accommodation by id.");
                System.out.println("10 - Find accommodation by title.");
                System.out.println("11 - Update accommodation.");
                System.out.println("12 - Delete accommodation.");
                System.out.print(RESET);
                break;
            }
            case 2:{
                System.out.println(BLACK_UNDERLINED);
                System.out.println("OPERATIONS WITH HOSTS");
                System.out.println(YELLOW);
                System.out.println("13 - Show all hosts.");
                System.out.println("14 - Show all sorted hosts.");
                System.out.println("15 - Add new host.");
                System.out.println("16 - Find a host by id.");
                System.out.println("17 - Find a host by last name.");
                System.out.println("18 - Update a host.");
                System.out.println("19 - Delete a host.");
                System.out.print(RESET);
                break;
            }
            case 3:{
                System.out.println(BLACK_UNDERLINED);
                System.out.println("OPERATIONS WITH GUESTS");
                System.out.println(YELLOW);
                System.out.println("20 - Show all guests.");
                System.out.println("21 - Show all sorted guests.");
                System.out.println("22 - Add new guest.");
                System.out.println("23 - Find a guest by id.");
                System.out.println("24 - Find a guest by last name.");
                System.out.println("25 - Update a guest.");
                System.out.println("26 - Delete a guest.");
                System.out.print(RESET);
                break;
            }
            case 4:{
                System.out.println(BLACK_UNDERLINED);
                System.out.println("OPERATIONS WITH BOOKINGS");
                System.out.println(YELLOW);
                System.out.println("27 - Show all bookings.");
                System.out.println("28 - Show all sorted bookings.");
                System.out.println("29 - Add new booking.");
                System.out.println("30 - Find a booking by id.");
                System.out.println("31 - Find a booking by start date.");
                System.out.println("32 - Update a booking.");
                System.out.println("33 - Delete a booking.");
                System.out.print(RESET);
                break;
            }
            case 5:{
                System.out.println(BLACK_UNDERLINED);
                System.out.println("OPERATIONS WITH GUEST DETAILS");
                System.out.println(YELLOW);
                System.out.println("34 - Print all guest details.");
                System.out.println("35 - Add new a guest detail.");
                System.out.println("36 - Update a guest detail.");
                System.out.println("37 - Delete a guest detail.");
                System.out.print(RESET);
                break;
            }
            case 6: {
                accommodationController.showAccommodations();
                break;
            }
            case 7: {
                accommodationController.printSortedAccommodations();
                break;
            }
            case 8: {
                accommodationController.addNewAccommodation();
                break;
            }
            case 9: {
                accommodationController.findAccommodationById();
                break;
            }
            case 10: {
                accommodationController.findAccommodationByTitle();
                break;
            }
            case 11: {
                accommodationController.updateAccommodation();
                break;
            }
            case 12: {
                accommodationController.deleteAccommodation();
                break;
            }
            case 13: {
                hostController.printHosts();
                break;
            }
            case 14: {
                hostController.findAllSortedHosts();
                break;
            }
            case 15: {
                hostController.addNewHost();
                break;
            }
            case 16: {
                hostController.findHostById();
                break;
            }
            case 17: {
                hostController.findHostByLastName();
                break;
            }
            case 18: {
                hostController.updateHost();
                break;
            }
            case 19: {
                hostController.deleteHostById();
                break;
            }
            case 20: {
                guestController.printGuests();
                break;
            }
            case 21: {
                guestController.findAllSortedGuests();
                break;
            }
            case 22: {
                guestController.addGuest();
                break;
            }
            case 23: {
                guestController.findGuestById();
                break;
            }
            case 24: {
                guestController.findGuestByLastName();
                break;
            }
            case 25: {
                guestController.updateGuest();
                break;
            }
            case 26: {
                guestController.deleteGuestById();
                break;
            }
            case 27: {
                bookingController.printBookings();
                break;
            }
            case 28: {
                bookingController.printAllSortedBookings();
                break;
            }
            case 29: {
                bookingController.addBooking();
                break;
            }
            case 30: {
                bookingController.findBookingById();
                break;
            }
            case 31: {
                bookingController.findBookingByStartDate();
                break;
            }
            case 32: {
                bookingController.updateBooking();
                break;
            }
            case 33: {
                bookingController.deleteBookingById();
                break;
            }
            case 34: {
                guestDetailController.printAllGuestDetails();
                break;
            }
            case 35: {
                guestDetailController.addGuestDetail();
                break;
            }
            case 36: {
                guestDetailController.updateGuestDetail();
                break;
            }
            case 37: {
                guestDetailController.deleteGuestDetailById();
                break;
            }
            case 0: {
                System.out.println("See you soon!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice!");
            }
        }
    }

    private void showHelloMessage() {
        System.out.println("**********************************");
        System.out.println("    Welcome to " + YELLOW + "BeMyGuest!" + RESET);
        System.out.println("**********************************");
        System.out.println();
    }
}
