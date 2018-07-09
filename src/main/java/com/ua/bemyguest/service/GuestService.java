package com.ua.bemyguest.service;

import com.ua.bemyguest.exception.DuplicateGuestException;
import com.ua.bemyguest.exception.GuestIncorrectId;
import com.ua.bemyguest.exception.GuestIncorrectLastName;
import com.ua.bemyguest.model.Guest;
import com.ua.bemyguest.repository.impl.GuestDAOH2Impl;

import java.util.List;

public class GuestService {

    private GuestDAOH2Impl guestDAOH2;

    public GuestService() {
        guestDAOH2 = GuestDAOH2Impl.instance();
    }

    public Guest findGuestById(int guestId) throws GuestIncorrectId{
        return guestDAOH2.findGuestById(guestId);
    }

    public Guest findGuestByLastName(String guestLastName) throws GuestIncorrectLastName{
        return guestDAOH2.findGuestByLastName(guestLastName);
    }

    public List<Guest> findAllSortedGuests(){
        return guestDAOH2.findAllSortedGuests();
    }

    public void addGuest(Guest guest) throws DuplicateGuestException{
        guestDAOH2.addGuest(guest);
    }

    public List<Guest> getAllGuests(){
        return guestDAOH2.getAllGuests();
    }

    public void updateGuest(Guest guest){
        guestDAOH2.updateGuest(guest);
    }

    public void deleteGuestById(int guestId) throws GuestIncorrectId{
        guestDAOH2.deleteGuestById(guestId);
    }
}
