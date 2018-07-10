package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.HostIncorrectId;
import com.ua.bemyguest.model.Host;
import com.ua.bemyguest.service.HostService;

import java.util.Scanner;

public class HostController {

    private HostService hostService = new HostService();

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
        int country = scanner.nextInt();
        System.out.println("Enter birth date of the host in the format: YYYY-MM-DD");
        String birthDate = scanner.next();
        System.out.println("Enter locality of the host:");
        String locality = scanner.next();
        System.out.println("Enter accommodations of the host");



        host.setFirstName(firstName);
    }

    public void findHostByLastName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id of the host:");
        int hostId = scanner.nextInt();
        try {
            System.out.println(hostService.findHostById(hostId));
        } catch (HostIncorrectId hostIncorrectId) {
            hostIncorrectId.printStackTrace();
        }
    }

    public void findAllSortedHosts(){

    }
}
