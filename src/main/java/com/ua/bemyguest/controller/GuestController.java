package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.DuplicateGuestException;
import com.ua.bemyguest.exception.GuestIncorrectId;
import com.ua.bemyguest.exception.GuestIncorrectLastName;
import com.ua.bemyguest.model.Guest;
import com.ua.bemyguest.repository.GuestDAO;
import com.ua.bemyguest.repository.impl.GuestDAOH2Impl;
import com.ua.bemyguest.service.GuestService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class GuestController {

    private GuestService guestService = new GuestService();

    public void findGuestById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id of the guest:");
        int guestId = scanner.nextInt();
        try {
            System.out.println(guestService.findGuestById(guestId));
        } catch (GuestIncorrectId guestIncorrectId) {
            guestIncorrectId.printStackTrace();
        }
    }

    public void findGuestByLastName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter last name of the guest:");
        String lastName = scanner.nextLine();
        try {
            System.out.println(guestService.findGuestByLastName(lastName));
        } catch (GuestIncorrectLastName guestIncorrectLastName) {
            guestIncorrectLastName.printStackTrace();
        }
    }

    public void findAllSortedGuests() {
        System.out.println("List of all sorted guests:");
        guestService.printGuests(guestService.findAllSortedGuests());
    }

    public void addGuest() {
        Guest guest = Guest.builder().build();
        Scanner scanner = new Scanner(System.in);

        // filling of the guest object
        System.out.println("\nPlease, enter guest's data:");
        System.out.println("Enter first name of the guest:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the guest:");
        String lastName = scanner.nextLine();
        System.out.println("Enter an email of the guest:");
        String email = scanner.nextLine();
        System.out.println("Enter phone number of the guest:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the country of the guest:");
        String country = scanner.nextLine();
        System.out.println("Enter birth date of the guest in the format: YYYY-MM-DD");
        String birthDate = scanner.nextLine();
        System.out.println("Enter locality of the guest:");
        String locality = scanner.nextLine();
        System.out.println("Enter preferred language of the guest:");
        String preferredLanguage = scanner.nextLine();
        guest.setFirstName(firstName);
        guest.setLastName(lastName);
        guest.setEmail(email);
        guest.setPhoneNumber(phoneNumber);
        guest.setCountry(country);
        guest.setBirthDate(LocalDate.parse(birthDate));
        guest.setLocality(locality);
        guest.setPreferredLanguage(preferredLanguage);
        try {
            guestService.addGuest(guest);
        } catch (DuplicateGuestException e) {
            e.printStackTrace();
        }
    }

    public void printGuests() {
        System.out.println("List of all guests:");
        guestService.printGuests(guestService.getAllGuests());
    }

    public void updateGuest() {
        Scanner scanner = new Scanner(System.in);
        GuestDAO guestDAO = new GuestDAOH2Impl();
        System.out.println("Enter guest's id for updating:");
        guestService.printGuests(guestService.getAllGuests());
        int n = scanner.nextInt() - 1;
        scanner.nextLine();
        Guest guest = guestDAO.getAllGuests().get(n);
        System.out.println("Enter firstName: ");
        guest.setFirstName(scanner.nextLine());
        System.out.println("Enter lastName: ");
        guest.setLastName(scanner.nextLine());
        System.out.println("Enter an email of the guest:");
        guest.setEmail(scanner.nextLine());
        System.out.println("Enter phone number of the guest:");
        guest.setPhoneNumber(scanner.nextLine());
        System.out.println("Enter the country of the guest:");
        guest.setCountry(scanner.nextLine());
        System.out.println("Enter birth date of the guest in the format: YYYY-MM-DD");
        guest.setBirthDate(LocalDate.parse(scanner.nextLine()));
        System.out.println("Enter locality of the guest:");
        guest.setLocality(scanner.nextLine());
        System.out.println("Enter preferred language of the guest:");
        guest.setPreferredLanguage(scanner.nextLine());
        guestService.updateGuest(guest);
    }

    void deleteGuestById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest's id for deleting:");
        guestService.printGuests(guestService.getAllGuests());
        int id = scanner.nextInt();
        try {
            guestService.deleteGuestById(id);
            System.out.println("The guest was deleted successfully.");
        } catch (GuestIncorrectId guestIncorrectId) {
            System.err.println("Wrong id!");
        }
    }
}
