package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.AccommodationIncorrectId;
import com.ua.bemyguest.exception.DuplicateHostException;
import com.ua.bemyguest.exception.HostIncorrectId;
import com.ua.bemyguest.exception.HostIncorrectLastName;
import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.model.Host;
import com.ua.bemyguest.service.AccommodationService;
import com.ua.bemyguest.service.HostService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HostController {

    private HostService hostService = new HostService();
    private AccommodationService accommodationService = new AccommodationService();
    private Set<Accommodation> accommodations = new HashSet<>();
    private Set<String> languages = new HashSet<>();

    public void findHostById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id of the host:");
        int hostId = scanner.nextInt();
        try {
            System.out.println(hostService.findHostById(hostId));
        } catch (HostIncorrectId hostIncorrectId) {
            hostIncorrectId.printStackTrace();
        }
    }

    public void findHostByLastName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter last name of the host:");
        String lastName = scanner.nextLine();
        try {
            System.out.println(hostService.findHostByLastName(lastName));
        } catch (HostIncorrectLastName hostIncorrectLastName) {
            hostIncorrectLastName.printStackTrace();
        }
    }

    public void findAllSortedHosts() {
        hostService.printHosts(hostService.findSortedHosts());
    }

    public void addNewHost() {
        Host host = Host.builder().build();
        Scanner scanner = new Scanner(System.in);

        // filling of the host object
        System.out.println("\nPlease, enter host's data:");
        System.out.println("Enter first name of the host:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of the host:");
        String lastName = scanner.nextLine();
        System.out.println("Enter an email of the host:");
        String email = scanner.nextLine();
        System.out.println("Enter phone number of the host:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the country of the host:");
        String country = scanner.nextLine();
        System.out.println("Enter birth date of the host in the format: YYYY-MM-DD");
        String birthDate = scanner.next();
        System.out.println("Enter locality of the host:");
        String locality = scanner.next();
        System.out.println("Enter the quantity of host accommodation:");
        int accommodationSize = scanner.nextInt();
        for (int i = 0; i < accommodationSize; i++) {
            System.out.println("Enter accommodation's id of the host:");
            int accommodationId  = scanner.nextInt();
            try {
                accommodations.add(accommodationService.findAccommodationById(accommodationId));
            } catch (AccommodationIncorrectId accommodationIncorrectId) {
                System.err.println("Wrong id!");
            }
        }
        System.out.println("Enter the quantity of languages:");
        int languagesSize = scanner.nextInt();
        for (int i = 0; i < languagesSize; i++) {
            System.out.println("Enter the name of language:");
            String language = scanner.nextLine();
            languages.add(language);
        }
        host.setFirstName(firstName);
        host.setLastName(lastName);
        host.setEmail(email);
        host.setPhoneNumber(phoneNumber);
        host.setCountry(country);
        host.setBirthDate(LocalDate.parse(birthDate));
        host.setLocality(locality);
        host.setAccommodations(accommodations);
        host.setLanguages(languages);
        try {
            hostService.addHost(host);
            System.out.println("The host was added successfully!");
        } catch (DuplicateHostException e) {
            e.printStackTrace();
        }
    }

    public void printHosts() {
        hostService.printHosts(hostService.getAllHosts());
    }

    public void updateHost() {

    }

    public void deleteHostById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter host's id for deleting:");
        int id = scanner.nextInt();
        try {
            hostService.deleteHostById(id);
            System.out.println("Host deleted.");
        } catch (HostIncorrectId hostIncorrectId) {
            hostIncorrectId.printStackTrace();
        }
    }
}
