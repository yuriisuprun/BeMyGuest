package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.DuplicateGuestException;
import com.ua.bemyguest.exception.GuestIncorrectId;
import com.ua.bemyguest.exception.GuestIncorrectLastName;
import com.ua.bemyguest.model.Guest;
import com.ua.bemyguest.service.GuestService;

import java.util.List;
import java.util.Scanner;

public class GuestController {

    private GuestService guestService = new GuestService();

    public void findGuestById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id of the guest:");
        int guestId = scanner.nextInt();
        try {
            System.out.println(guestService.findGuestById(guestId));
        } catch (GuestIncorrectId guestIncorrectId) {
            guestIncorrectId.printStackTrace();
        }
    }

    public void findGuestByLastName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter last name of the guest:");
        String lastName = scanner.nextLine();
        try {
            System.out.println(guestService.findGuestByLastName(lastName));
        } catch (GuestIncorrectLastName guestIncorrectLastName) {
            guestIncorrectLastName.printStackTrace();
        }
    }

    public void findAllSortedGuests(){
        guestService.printGuests(guestService.findAllSortedGuests());
    }

    public void addGuest(){
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
        int country = scanner.nextInt();
        System.out.println("Enter birth date of the guest in the format: YYYY-MM-DD");
        String birthDate = scanner.next();
        System.out.println("Enter locality of the guest:");
        String locality = scanner.next();
        System.out.println("Enter accommodations of the host");


        guest.setFirstName(firstName);
    }

    public void printGuests(){
        guestService.printGuests(guestService.getAllGuests());
    }

    public void updateGuest(){

    }

    void deleteGuestById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest's id for deleting:");
        int id = scanner.nextInt();
        try {
            guestService.deleteGuestById(id);
        } catch (GuestIncorrectId guestIncorrectId) {
            guestIncorrectId.printStackTrace();
        }
        System.out.println("Guest deleted.");
    }
}
