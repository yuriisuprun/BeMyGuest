package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.GuestDetailIncorrectId;
import com.ua.bemyguest.model.GuestDetail;
import com.ua.bemyguest.repository.GuestDetailDAO;
import com.ua.bemyguest.repository.impl.GuestDetailDAOH2Impl;
import com.ua.bemyguest.service.GuestDetailService;

import java.util.Scanner;

public class GuestDetailController {

    private GuestDetailService guestDetailService = new GuestDetailService();

    public void printAllGuestDetails(){
        guestDetailService.printGuestDetails(guestDetailService.getAllGuestDetails());
    }

    public void addGuestDetail(){
        GuestDetail guestDetail = new GuestDetail();
        Scanner scanner = new Scanner(System.in);

        // filling of the guest detail object
        System.out.println("\nPlease, enter guest detail's data:");
        System.out.println("Enter guest's id:");
        int guestId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter review:");
        String review = scanner.nextLine();
        guestDetail.setGuestId(guestId);
        guestDetail.setReview(review);
        guestDetailService.addGuestDetail(guestDetail);
    }

    public void updateGuestDetail(){
        Scanner scanner = new Scanner(System.in);
        GuestDetailDAO guestDetailDAO = new GuestDetailDAOH2Impl();
        System.out.println("Enter guest detail's data for updating:");
        guestDetailService.printGuestDetails(guestDetailService.getAllGuestDetails());
        int n = scanner.nextInt() - 1;
        scanner.nextLine();
        GuestDetail guestDetail = guestDetailDAO.getAllGuestDetails().get(n);
        System.out.println("Enter guest detail's id: ");
        guestDetail.setGuestId(scanner.nextInt());
        System.out.println("Enter guest id: ");
        guestDetail.setGuestId(scanner.nextInt());
        System.out.println("Enter the review of guest:");
        guestDetail.setReview(scanner.nextLine());
        guestDetailService.updateGuestDetail(guestDetail);
    }

    public void deleteGuestDetailById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest detail's id for deleting:");
        int id = scanner.nextInt();
        try {
            guestDetailService.deleteGuestDetailById(id);
            System.out.println("The guest's detail was deleted successfully!");
        } catch (GuestDetailIncorrectId guestDetailIncorrectId) {
            System.err.println("Wrong id!");
        }
    }
}
