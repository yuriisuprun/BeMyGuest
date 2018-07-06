package com.ua.bemyguest.repository;

import com.ua.bemyguest.exception.DuplicateGuestException;
import com.ua.bemyguest.exception.GuestIncorrectId;
import com.ua.bemyguest.exception.GuestIncorrectLastName;
import com.ua.bemyguest.model.Guest;

import java.util.List;

public interface GuestDAO {

    Guest findGuestById(int guestId) throws GuestIncorrectId;

    Guest findGuestByLastName(String guestLastName) throws GuestIncorrectLastName;

    void findSorted();

    void addGuest(Guest guest) throws DuplicateGuestException;

    List<Guest> getAllGuests();

    void updateGuest(Guest guest);

    void deleteGuestById(int guestId) throws GuestIncorrectId;
}
