package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.AccommodationIncorrectId;
import com.ua.bemyguest.exception.DuplicateHostException;
import com.ua.bemyguest.exception.HostIncorrectId;
import com.ua.bemyguest.exception.HostIncorrectLastName;
import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.model.Host;
import com.ua.bemyguest.repository.HostDAO;
import com.ua.bemyguest.repository.impl.HostDAOH2Impl;
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
        System.out.println("\nPlease, enter host's data...");
        System.out.println("Enter first name of host:");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name of host:");
        String lastName = scanner.nextLine();
        System.out.println("Enter an email of host:");
        String email = scanner.nextLine();
        System.out.println("Enter phone number of host:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter the country of host:");
        String country = scanner.nextLine();
        System.out.println("Enter birth date of the host in the format: YYYY-MM-DD");
        String birthDate = scanner.nextLine();
        System.out.println("Enter locality of host:");
        String locality = scanner.nextLine();
        System.out.println("Enter the quantity of host accommodation:");
        int accommodationSize = scanner.nextInt();
        for (int i = 0; i < accommodationSize; i++) {
            System.out.println("Enter accommodation's id of host:");
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
            scanner.next();
            languages.add(language);
        }
        System.out.println("Enter the join date in the format: YYYY-MM-DD:");
        scanner.nextLine();
        String joinDate = scanner.nextLine();
        System.out.println("Enter the host's place of work and the position:");
        String work = scanner.nextLine();
        host.setFirstName(firstName);
        host.setLastName(lastName);
        host.setEmail(email);
        host.setPhoneNumber(phoneNumber);
        host.setCountry(country);
        host.setBirthDate(LocalDate.parse(birthDate));
        host.setLocality(locality);
        host.setAccommodations(accommodations);
        host.setLanguages(languages);
        host.setJoinDate(LocalDate.parse(joinDate));
        host.setWork(work);
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
        Scanner scanner = new Scanner(System.in);
        HostDAO hostDAO = new HostDAOH2Impl();
        hostService.printHosts(hostService.getAllHosts());
        System.out.println("Enter a host's id for updating:");
        int hostId = scanner.nextInt();
        scanner.nextLine();
        Host host = null;
        try {
            host = hostService.findHostById(hostId);
        } catch (HostIncorrectId hostIncorrectId) {
            hostIncorrectId.printStackTrace();
        }
        System.out.println("Please, enter the data for updating...");
        System.out.println("Enter new first name: ");
        host.setFirstName(scanner.nextLine());
        System.out.println("Enter new last name: ");
        host.setLastName(scanner.nextLine());
        System.out.println("Enter new email of host:");
        host.setEmail(scanner.nextLine());
        System.out.println("Enter phone number of host:");
        host.setPhoneNumber(scanner.nextLine());
        System.out.println("Enter the country of host:");
        host.setCountry(scanner.nextLine());
        System.out.println("Enter birth date of the host in the format: YYYY-MM-DD");
        host.setBirthDate(LocalDate.parse(scanner.nextLine()));
        System.out.println("Enter locality of the host:");
        host.setLocality(scanner.nextLine());
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
            scanner.next();
            languages.add(language);
        }
        System.out.println("Enter the join date in the format: YYYY-MM-DD:");
        scanner.nextLine();
        host.setJoinDate(LocalDate.parse(scanner.nextLine()));
        System.out.println("Enter the host's place of work and the position:");
        host.setWork(scanner.nextLine());
        hostService.updateHost(host);
        System.out.println("The host with id #" + hostId + " was updated successfully.");
    }

    public void deleteHostById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter host's id for deleting:");
        int hostId = scanner.nextInt();
        try {
            hostService.deleteHostById(hostId);
            System.out.println("The host with id #" + hostId + " was deleted.");
        } catch (HostIncorrectId hostIncorrectId) {
            System.err.println("Wrong id!");
        }
    }
}
