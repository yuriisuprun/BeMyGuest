package com.ua.bemyguest.controller;

import com.ua.bemyguest.exception.GuestDetailIncorrectId;
import com.ua.bemyguest.model.GuestDetail;
import com.ua.bemyguest.service.GuestDetailService;

import java.util.List;
import java.util.Scanner;

public class GuestDetailController {

    private GuestDetailService guestDetailService = new GuestDetailService();

    public void findGuestDetailById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an id of a guest detail:");
        int guestDetailId = scanner.nextInt();
        try {
            System.out.println(guestDetailService.findGuestDetailById(guestDetailId));
        } catch (GuestDetailIncorrectId guestDetailIncorrectId) {
            guestDetailIncorrectId.printStackTrace();
        }
    }

    public void findAllSortedGuestDetails(){
        guestDetailService.printGuestDetails(guestDetailService.findAllSortedGuestDetails());
    }

    public void addGuestDetail(){
        GuestDetail guestDetail = new GuestDetail();
        Scanner scanner = new Scanner(System.in);

        // filling of the guest object
        System.out.println("\nPlease, enter guest detail's data:");
        System.out.println("Enter review:");
        String review = scanner.nextLine();
        guestDetail.setReview(review);
    }

    public void getAllGuestDetails(){
        guestDetailService.printGuestDetails(guestDetailService.getAllGuestDetails());
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
