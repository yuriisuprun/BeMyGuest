package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.AccommodationIncorrectId;
import com.ua.bemyguest.exception.AccommodationIncorrectTitle;
import com.ua.bemyguest.exception.HostIncorrectId;
import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.model.AccommodationType;
import com.ua.bemyguest.model.Host;
import com.ua.bemyguest.service.*;

import java.util.List;
import java.util.Scanner;

public class MainController {

    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

    private AccommodationService accommodationService = new AccommodationService();
    private BookingService bookingService = new BookingService();
    private GuestDetailService guestDetailService = new GuestDetailService();
    private GuestService guestService = new GuestService();
    private HostService hostService = new HostService();

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
        System.out.println("Make your choice: ");
        System.out.println("1. Show available accommodations.");
        System.out.println("2. Add new Cook.");
        System.out.println("3. Remove Cook.");
        System.out.println("4. Show list of Bartenders");
        System.out.println("5. Add new Bartender.");
        System.out.println("6. Remove Bartender");
        System.out.println("7. Show list of Waiters");
        System.out.println("8. Add new Waiter");
        System.out.println("9. Remove Waiter");
        System.out.println("10. Show list of Dishwashers");
        System.out.println("11. Add new Dishwasher");
        System.out.println("12. Remove Dishwasher");

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
                accommodationController.addNewAccommodation();
                break;
            }
            case 3: {
                accommodationController.findAccommodationById();
                break;
            }
            case 4: {
                accommodationController.findAccommodationByTitle();
                break;
            }
            case 5: {
                accommodationController.updateAccommodation();
                break;
            }
            case 6: {
                accommodationController.deleteAccommodation();
                break;
            }
            case 7: {
                showGuestDetails();
                break;
            }
            case 8: {
//                addNewWaiter();
                break;
            }
            case 9: {

                break;
            }
            case 10: {
                showGuests();
                break;
            }
            case 11: {

                break;
            }
            case 12: {

                break;
            }case 13: {
                showHosts();
                break;
            }case 0: {
                System.out.println("See you soon!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice!");
            }
        }
    }

    private void showBookings() {
        bookingService.printBookings(bookingService.getAllBookings());
    }

    private void showGuestDetails() {
        guestDetailService.printGuestDetails(guestDetailService.getAllGuestDetails());
    }

    private void showGuests() {
        guestService.printGuests(guestService.getAllGuests());
    }

    private void showHosts() {
        hostService.printHosts(hostService.getAllHosts());
    }

    private void showHelloMessage() {
        System.out.println("************************");
        System.out.println("Welcome to " + GREEN_BOLD + "BeMyGuest DB!" + RESET);
        System.out.println("************************");
        System.out.println();
    }
}
