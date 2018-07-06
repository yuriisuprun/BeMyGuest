package com.ua.bemyguest.repository;

import com.ua.bemyguest.model.Accommodation;

import java.util.List;

public interface AccommodationDAO {

    Accommodation findAccommodationById(int accommodationId);

    Accommodation findAccommodationByName(String accommodationName);

    void findSorted();

    void addAccommodation(Accommodation accommodation);

    List<Accommodation> getAllAccommodations();

    void updateAccommodation(Accommodation accommodation);

    void deleteAccommodation(int accommodationId);
}
