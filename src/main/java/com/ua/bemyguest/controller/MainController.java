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

    public void doWork() {
        showHelloMessage();
        while (true) {
            showMenu();
            makeChoice();
        }
    }

    private void showMenu() {
        System.out.println(BLACK_UNDERLINED);
        System.out.println("Work with accommodations");
        System.out.println(CYAN);
        System.out.println("1. Show available accommodations.");
        System.out.println("2. Show sorted accommodations.");
        System.out.println("3. Add new accommodation.");
        System.out.println("4. Find accommodation by id.");
        System.out.println("5. Find accommodation by title.");
        System.out.println("6. Update accommodation.");
        System.out.println("7. Delete accommodation.");
        System.out.println(BLACK_UNDERLINED);
        System.out.println("Work with hosts");
        System.out.println(PURPLE);
        System.out.println("8. Show all hosts.");
        System.out.println("9. Show all sorted hosts.");
        System.out.println("10. Add new host.");
        System.out.println("11. Find a host by id.");
        System.out.println("12. Find a host by last name.");
        System.out.println("13. Update a host.");
        System.out.println("14. Delete a host.");
        System.out.println(BLACK_UNDERLINED);
        System.out.println("Work with guests");
        System.out.println(BLUE);
        System.out.println("15. Show all guests.");
        System.out.println("16. Show all sorted guests.");
        System.out.println("17. Add new guest.");
        System.out.println("18. Find a guest by id.");
        System.out.println("19. Find a guest by last name.");
        System.out.println("20. Update a guest.");
        System.out.println("21. Delete a guest.");
        System.out.println(BLACK_UNDERLINED);
        System.out.println("Work with bookings");
        System.out.println(YELLOW);
        System.out.println("22. Show all bookings.");
        System.out.println("23. Show all sorted bookings.");
        System.out.println("24. Add new booking.");
        System.out.println("25. Find a booking by id.");
        System.out.println("26. Find a booking by start date.");
        System.out.println("27. Update a booking.");
        System.out.println("28. Delete a booking.");
        System.out.println(BLACK_UNDERLINED);
        System.out.println("Work with guest details");
        System.out.println(CYAN);
        System.out.println("29. Print all guest details.");
        System.out.println("30. Add new a guest detail.");
        System.out.println("31. Update a guest detail.");
        System.out.println("32. Delete a guest detail.");
        System.out.println(RESET);
        System.out.println("\n0. Exit");
    }

    private void makeChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                accommodationController.showAccommodations();
                break;
            }
            case 2: {
                accommodationController.printSortedAccommodations();
                break;
            }
            case 3: {
                accommodationController.addNewAccommodation();
                break;
            }
            case 4: {
                accommodationController.findAccommodationById();
                break;
            }
            case 5: {
                accommodationController.findAccommodationByTitle();
                break;
            }
            case 6: {
                accommodationController.updateAccommodation();
                break;
            }
            case 7: {
                accommodationController.deleteAccommodation();
                break;
            }
            case 8: {
                hostController.printHosts();
                break;
            }
            case 9: {
                hostController.findAllSortedHosts();
                break;
            }
            case 10: {
                hostController.addNewHost();
                break;
            }
            case 11: {
                hostController.deleteHostById();
                break;
            }
            case 12: {
                hostController.findHostByLastName();
                break;
            }
            case 13: {
                hostController.updateHost();
                break;
            }
            case 14: {
                hostController.deleteHostById();
                break;
            }
            case 15: {
                guestController.printGuests();
                break;
            }
            case 16: {
                guestController.findAllSortedGuests();
                break;
            }
            case 17: {
                guestController.addGuest();
                break;
            }
            case 18: {
                guestController.findGuestById();
                break;
            }
            case 19: {
                guestController.findGuestByLastName();
                break;
            }
            case 20: {
                guestController.updateGuest();
                break;
            }
            case 21: {
                guestController.deleteGuestById();
                break;
            }
            case 22: {
                bookingController.printBookings();
                break;
            }
            case 23: {
                bookingController.printAllSortedBookings();
                break;
            }
            case 24: {
                bookingController.addBooking();
                break;
            }
            case 25: {
                bookingController.findBookingById();
                break;
            }
            case 26: {
                bookingController.findBookingByStartDate();
                break;
            }
            case 27: {
                bookingController.updateBooking();
                break;
            }
            case 28: {
                bookingController.deleteBookingById();
                break;
            }
            case 29: {
                guestDetailController.printAllGuestDetails();
                break;
            }
            case 30: {
                guestDetailController.addGuestDetail();
                break;
            }
            case 31: {
                guestDetailController.updateGuestDetail();
                break;
            }
            case 32: {
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
        System.out.println("************************");
        System.out.println("Welcome to " + GREEN_BOLD_BRIGHT + "BeMyGuest DB!" + RESET);
        System.out.println("************************");
        System.out.println();
    }
}
