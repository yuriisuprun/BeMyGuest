package com.ua.bemyguest.service;

import com.ua.bemyguest.exception.GuestDetailIncorrectId;
import com.ua.bemyguest.model.GuestDetail;
import com.ua.bemyguest.repository.impl.GuestDetailDAOH2Impl;

import java.util.List;

public class GuestDetailService {

    private GuestDetailDAOH2Impl guestDetailDAOH2;

    public GuestDetailService() {
        guestDetailDAOH2 = GuestDetailDAOH2Impl.instance();
    }

    public GuestDetail findGuestDetailById(int guestId) throws GuestDetailIncorrectId{
        return guestDetailDAOH2.findGuestDetailById(guestId);
    }

    public List<GuestDetail> findAllSortedGuestDetails(){
        return guestDetailDAOH2.findAllSortedGuestDetails();
    }

    public void addGuestDetail(GuestDetail guestDetail){
        guestDetailDAOH2.addGuestDetail(guestDetail);
    }

    public List<GuestDetail> getAllGuestDetails(){
        return guestDetailDAOH2.getAllGuestDetails();
    }

    public void updateGuestDetail(GuestDetail guestDetail){
        guestDetailDAOH2.updateGuestDetail(guestDetail);
    }

    public void deleteGuestDetailById(int guestDetailId) throws GuestDetailIncorrectId{
        guestDetailDAOH2.deleteGuestDetailById(guestDetailId);
    }

    public void printGuestDetails(List<GuestDetail> guestDetails){
        for (GuestDetail guestDetail : getAllGuestDetails()) {
            System.out.println(guestDetail);
        }
    }
}
