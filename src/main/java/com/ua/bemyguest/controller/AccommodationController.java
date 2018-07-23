package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.AccommodationIncorrectId;
import com.ua.bemyguest.exception.AccommodationIncorrectTitle;
import com.ua.bemyguest.exception.HostIncorrectId;
import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.model.AccommodationType;
import com.ua.bemyguest.service.AccommodationService;
import com.ua.bemyguest.service.HostService;

import java.util.Scanner;

public class AccommodationController {

    private AccommodationService accommodationService = new AccommodationService();
    private HostService hostService = new HostService();

    public void findAccommodationById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id of the accommodation:");
        int accommodationId = scanner.nextInt();
        try {
            System.out.println(accommodationService.findAccommodationById(accommodationId));
        } catch (AccommodationIncorrectId accommodationIncorrectId) {
            accommodationIncorrectId.printStackTrace();
        }
    }

    public void findAccommodationByTitle(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a title of the accommodation:");
        String accommodationTitle = scanner.next();
        try {
            System.out.println(accommodationService.findAccommodationByTitle(accommodationTitle));
        } catch (AccommodationIncorrectTitle accommodationIncorrectTitle) {
            accommodationIncorrectTitle.printStackTrace();
        }
    }

    public void printSortedAccommodations(){
        accommodationService.printAccommodations(accommodationService.findSortedAccommodations());
    }

    public void addNewAccommodation() {
        Accommodation accommodation = new Accommodation();
        Scanner scanner = new Scanner(System.in);

        // filling of the accommodation object
        System.out.println("\nEnter accommodation's data...");
        System.out.println("Enter the title of accommodation:");
        String title = scanner.nextLine();
        System.out.println("Enter the locality of accommodation:");
        String locality = scanner.nextLine();
        System.out.println("Enter the country of accommodation:");
        String country = scanner.nextLine();
        System.out.println("Enter the address of accommodation:");
        String address = scanner.nextLine();
        System.out.println("Enter host's id:");
        int hostId = scanner.nextInt();
        System.out.println("Enter accommodation type(room, hostel, apartment, house):");
        String accommodationType = scanner.next().toUpperCase();
        System.out.println("Enter a description of accommodation:");
        String description = scanner.next();
        scanner.nextLine();
        System.out.println("Enter accommodation price per night:");
        double price = scanner.nextDouble();
        accommodation.setTitle(title);
        accommodation.setLocality(locality);
        accommodation.setCountry(country);
        accommodation.setAddress(address);
        try {
            accommodation.setHost(hostService.findHostById(hostId));
        } catch (HostIncorrectId hostIncorrectId) {
            hostIncorrectId.printStackTrace();
        }
        accommodation.setAccommodationType(AccommodationType.valueOf(accommodationType));
        accommodation.setDescription(description);
        accommodation.setPrice(price);
        accommodationService.addAccommodation(accommodation);
        System.out.println("The accommodation was added successfully!");
    }

    public void showAccommodations() {
        accommodationService.printAccommodations(accommodationService.getAllAccommodations());
    }

    public void updateAccommodation(){
        Scanner scanner = new Scanner(System.in);
        Accommodation newAccommodation = new Accommodation();
        System.out.println("Enter accommodation's id you want to update");
        int accommodationId = scanner.nextInt();
        System.out.println("Enter the title of the accommodation:");
        String title = scanner.next();
        System.out.println("Enter the locality of the accommodation:");
        String locality = scanner.next();
        System.out.println("Enter the country of the accommodation:");
        String country = scanner.next();
        System.out.println("Enter the address of the accommodation:");
        String address = scanner.next();
        System.out.println("Enter host's id:");
        int hostId = scanner.nextInt();
        System.out.println("Enter accommodation type:");
        String accommodationType = scanner.next();
        System.out.println("Enter a description of the accommodation:");
        String description = scanner.next();
        System.out.println("Enter accommodation type:");
        double price = scanner.nextDouble();
        newAccommodation.setId(accommodationId);
        newAccommodation.setTitle(title);
        newAccommodation.setLocality(locality);
        newAccommodation.setCountry(country);
        newAccommodation.setAddress(address);
        try {
            newAccommodation.setHost(hostService.findHostById(hostId));
        } catch (HostIncorrectId hostIncorrectId) {
            hostIncorrectId.printStackTrace();
        }
        newAccommodation.setAccommodationType(AccommodationType.valueOf(accommodationType));
        newAccommodation.setDescription(description);
        newAccommodation.setPrice(price);
        accommodationService.updateAccommodation(newAccommodation);
    }

    public void deleteAccommodation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter accommodation's id for deleting:");
        int id = scanner.nextInt();
        try {
            accommodationService.deleteAccommodation(id);
            System.out.println("The accommodation deleted.");
        } catch (AccommodationIncorrectId accommodationIncorrectId) {
            System.err.println("Wrong id!");
        }
    }
}
