package com.ua.bemyguest.repository;

import com.ua.bemyguest.exception.AccommodationIncorrectId;
import com.ua.bemyguest.exception.AccommodationIncorrectTitle;
import com.ua.bemyguest.model.Accommodation;

import java.util.List;

public interface AccommodationDAO {

    Accommodation findAccommodationById(int accommodationId) throws AccommodationIncorrectId;

    Accommodation findAccommodationByTitle(String accommodationTitle) throws AccommodationIncorrectTitle;

    List<Accommodation> findSortedAccommodations();

    void addAccommodation(Accommodation accommodation);

    List<Accommodation> getAllAccommodations();

    void updateAccommodation(Accommodation accommodation);

    void deleteAccommodation(int accommodationId) throws AccommodationIncorrectId;
}
