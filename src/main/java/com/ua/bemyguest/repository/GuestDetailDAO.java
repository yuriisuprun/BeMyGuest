package com.ua.bemyguest.repository;

import com.ua.bemyguest.exception.GuestDetailIncorrectId;
import com.ua.bemyguest.model.GuestDetail;

import java.util.List;

public interface GuestDetailDAO {

    GuestDetail findGuestDetailById(int guestId) throws GuestDetailIncorrectId;

    List<GuestDetail> findAllSortedGuestDetails();

    void addGuestDetail(GuestDetail guestDetail);

    List<GuestDetail> getAllGuestDetails();

    void updateGuestDetail(GuestDetail guestDetail);

    void deleteGuestDetailById(int guestDetailId) throws GuestDetailIncorrectId;
}
