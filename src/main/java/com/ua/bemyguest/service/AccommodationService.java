package com.ua.bemyguest.service;

import com.ua.bemyguest.exception.AccommodationIncorrectId;
import com.ua.bemyguest.exception.AccommodationIncorrectTitle;
import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.repository.impl.AccommodationDAOH2Impl;

import java.util.List;

public class AccommodationService {

    private AccommodationDAOH2Impl accommodationDAOH2;

    public AccommodationService() {
        accommodationDAOH2 = AccommodationDAOH2Impl.instance();
    }

    public Accommodation findAccommodationById(int accommodationId) throws AccommodationIncorrectId{
        return accommodationDAOH2.findAccommodationById(accommodationId);
    }

    public Accommodation findAccommodationByTitle(String accommodationTitle) throws AccommodationIncorrectTitle {
        return accommodationDAOH2.findAccommodationByTitle(accommodationTitle);
    }
    
    public List<Accommodation> findSortedAccommodations(){
        return accommodationDAOH2.findSortedAccommodations();
    }

    public void addAccommodation(Accommodation accommodation){
        accommodationDAOH2.addAccommodation(accommodation);
    }

    public List<Accommodation> getAllAccommodations(){
        return accommodationDAOH2.getAllAccommodations();
    }

    public void updateAccommodation(Accommodation accommodation){
        accommodationDAOH2.updateAccommodation(accommodation);
    }

    public void deleteAccommodation(int accommodationId) throws AccommodationIncorrectId{
        try {
            accommodationDAOH2.deleteAccommodation(accommodationId);
        } catch (AccommodationIncorrectId e) {
            e.printStackTrace();
        }
    }

    public void printAccommodations(List<Accommodation> accommodations){
        for (Accommodation accommodation : accommodations) {
            System.out.println(accommodation);
        }
    }
}
