package com.ua.bemyguest.controller;

import com.ua.bemyguest.service.*;

import java.util.Scanner;

public class MainController {

    /*private AccommodationService accommodationService = new AccommodationService();
    private BookingService bookingService = new BookingService();
    private GuestDetailService guestDetailService = new GuestDetailService();
    private GuestService guestService = new GuestService();
    private HostService hostService = new HostService();

    public void doWork() {
        showHelloMessage();
        while (true) {
            showMenu();
            makeChoice();
        }
    }

    private void showMenu() {
        System.out.println("Make your choice: ");
        System.out.println("1. Show list of Cooks.");
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
        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();
        switch (choice) {
            case 1: {
                showCooksList();
                break;
            }
            case 2: {
                addNewCook();
                break;
            }
            case 3: {
                removeCook();
                break;
            }
            case 4: {
                showBartendersList();
                break;
            }
            case 5: {
                addNewBartender();
                break;
            }
            case 6: {
                removeBartender();
                break;
            }
            case 7: {
                showWaitersList();
                break;
            }
            case 8: {
                addNewWaiter();
                break;
            }
            case 9: {
                removeWaiter();
                break;
            }
            case 10: {
                showDishwashersList();
                break;
            }
            case 11: {
                addNewDishwasher();
                break;
            }
            case 12: {
                removeDishwasher();
                break;
            }
            case 0: {
                System.out.println("Goodbye!!!");
                System.exit(1);
            }
            default: {
                System.out.println("Wrong choice!");
            }
        }
    }

    private void showAccommodations() {
        accommodationService.printAccommodations(accommodationService.getAllAccommodations());
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

    private void addNewCook() {

        Cook cook = new Cook();
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter cook's data:");
        System.out.println("Enter firstname: ");
        String firstname = s.nextLine();
        System.out.println("Enter lastname: ");
        String lastname = s.nextLine();
        System.out.println("Enter middlename: ");
        String middlename = s.nextLine();
        System.out.println("Enter experience: ");
        int experience = s.nextInt();

        cook.setFirstName(firstname);
        cook.setLastName(lastname);
        cook.setMiddleName(middlename);
        cook.setExperience(experience);

        cookService.addCook(cook);
    }

    private void addNewBartender() {

        Bartender bartender = new Bartender();
        Scanner s = new Scanner(System.in);
        System.out.println("\nEnter bartender's data:");
        System.out.println("Enter firstname: ");
        String firstname = s.nextLine();
        System.out.println("Enter lastname: ");
        String lastname = s.nextLine();
        System.out.println("Enter middlename: ");
        String middlename = s.nextLine();
        System.out.println("Enter quantityMadeCocktails: ");
        int quantityMadeCocktails = s.nextInt();

        bartender.setFirstName(firstname);
        bartender.setLastName(lastname);
        bartender.setMiddleName(middlename);
        bartender.setQuantityMadeCocktails(quantityMadeCocktails);

        bartenderService.addBartender(bartender);
    }

    private void addNewWaiter() {
        Waiter waiter = new Waiter();
        System.out.println("\nEnter waiter's data:");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName = s.nextLine();
        System.out.println("Enter last name:");
        String lastName = s.nextLine();
        System.out.println("Enter middle name:");
        String middleName = s.nextLine();
        System.out.println("Enter experience:");
        int experience = s.nextInt();

        waiter.setFirstName(firstName);
        waiter.setLastName(lastName);
        waiter.setMiddleName(middleName);
        waiter.setExperience(experience);

        waiterService.addWaiter(waiter);
    }

    private void addNewDishwasher() {
        Dishwasher dishwasher = new Dishwasher();
        System.out.println("\nEnter dishwasher's data:");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first name:");
        String firstName = s.nextLine();
        System.out.println("Enter last name:");
        String lastName = s.nextLine();
        System.out.println("Enter middle name:");
        String middleName = s.nextLine();
        System.out.println("Enter experience:");
        int hoursWork = s.nextInt();

        dishwasher.setFirstName(firstName);
        dishwasher.setLastName(lastName);
        dishwasher.setMiddleName(middleName);
        dishwasher.setWorkHours(hoursWork);

        dishwasherService.addDishwasher(dishwasher);
    }

    private void removeBartender() {

    }

    private void removeCook() {

    }

    private void removeWaiter() {

    }

    private void removeDishwasher() {

    }

    private void showHelloMessage() {
        System.out.println("*******************");
        System.out.println("BeMyGuest Database");
        System.out.println("*******************");
        System.out.println();
    }*/
}
