package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.GuestDetailIncorrectId;
import com.ua.bemyguest.model.GuestDetail;
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
        System.out.println("Enter review:");
        String review = scanner.nextLine();
        guestDetail.setReview(review);
    }

    public void updateGuestDetail(){

    }

    public void deleteGuestDetailById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest detail's id for deleting:");
        int id = scanner.nextInt();
        try {
            guestDetailService.deleteGuestDetailById(id);
        } catch (GuestDetailIncorrectId guestDetailIncorrectId) {
            guestDetailIncorrectId.printStackTrace();
        }
        System.out.println("Guest detail deleted.");
    }
}
