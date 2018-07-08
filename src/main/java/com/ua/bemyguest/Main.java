package com.ua.bemyguest;

import com.ua.bemyguest.exception.DuplicateGuestException;
import com.ua.bemyguest.exception.GuestIncorrectId;
import com.ua.bemyguest.exception.GuestIncorrectLastName;
import com.ua.bemyguest.model.Guest;
import com.ua.bemyguest.model.Host;
import com.ua.bemyguest.repository.AccommodationDAO;
import com.ua.bemyguest.repository.GuestDAO;
import com.ua.bemyguest.repository.HostDAO;
import com.ua.bemyguest.repository.impl.AccommodationDAOH2Impl;
import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.model.AccommodationType;
import com.ua.bemyguest.repository.impl.GuestDAOH2Impl;
import com.ua.bemyguest.repository.impl.HostDAOH2Impl;
import com.ua.bemyguest.service.Init;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        /*Guest guest = Guest.builder()
                    .preferredLanguage("English")
                    .build();
        System.out.println(guest);

        Host host = Host.newBuilder()
                    .setCountry("Netherlands")
                    .setFirstName("Bram")
                    .build();
        System.out.println(host);

        Accommodation accommodation = Accommodation.newBuilder()
                    .setAccommodationType(AccommodationType.APARTMENT)
                    .build();
        System.out.println(accommodation);*/

        /*HostDAO hostDAO = new HostDAOH2Impl();
        hostDAO.addHost(Host.newBuilder()
                .setFirstName("David")
                .setLastName("Hamilton")
                .setEmail("dav@gmail.com")
                .setPhoneNumber("0983688221")
                .setCountry("Belgium")
                .setBirthDate(LocalDate.of(1982, Month.JANUARY, 1))
                .setLocality("Antwerp")
                .setJoinDate(LocalDate.of(2015, Month.JULY, 21))
                .setWork("programmer")
                .build());*/

        Init init = new Init();

        AccommodationDAO accommodationDAO = new AccommodationDAOH2Impl();
        /*accommodationDAO.addAccommodation(Accommodation.newBuilder()
                .setTitle("Cozy apartment")
                .setAccommodationType(AccommodationType.APARTMENT)
                .setCountry("Italy")
                .build());
        System.out.println(accommodationDAO);*/

        /*Host host = Host.newBuilder()
                .setFirstName("Kevin")
                .build();

        accommodationDAO.addAccommodation(Accommodation.newBuilder()
                .setTitle("Light room in Barcelona")
                .setHost(host)
                .build());

        System.out.println(accommodationDAO.getAllAccommodations());*/

        GuestDAO guestDAO = new GuestDAOH2Impl();
        /*try {
            guestDAO.addGuest(Guest.builder()
                    .preferredLanguage("Chinese")
                    .lastName("Gug")
                    .build());
        } catch (DuplicateGuestException e) {
            e.printStackTrace();
        }

        try {
            guestDAO.addGuest(Guest.builder()
                    .preferredLanguage("German")
                    .lastName("Apf")
                    .build());
        } catch (DuplicateGuestException e) {
            e.printStackTrace();
        }*/

        LocalDate localDate = LocalDate.now();

        /*try {
            guestDAO.addGuest(Guest.builder()
                    .preferredLanguage("German")
                    .birthDate(localDate)
                    .lastName("Zog")
                    .build());
        } catch (DuplicateGuestException e) {
            e.printStackTrace();
        }*/

        try {
        guestDAO.addGuest(Guest.builder()
                .preferredLanguage("Japanese")
                .birthDate(LocalDate.parse("2000-02-22", DateTimeFormatter.ISO_DATE))
                .lastName("Amm")
                .build());
    } catch (DuplicateGuestException e) {
        e.printStackTrace();
    }
        System.out.println(guestDAO.findAllSortedGuests());

        /*Guest guest = Guest.builder()
                .id(1)
                .firstName("Jennifer")
                .lastName("Lorry")
                .birthDate(LocalDate.parse("2012-02-22", DateTimeFormatter.ISO_DATE))
                .build();
        guestDAO.updateGuest(guest);*/


        HostDAO hostDAO = new HostDAOH2Impl();
        Host host = Host.builder()
                .firstName("Levis")
                .work("University: lecturer")
                .build();

        Accommodation accommodation = Accommodation.newBuilder()
                .setCountry("England")
                .setAccommodationType(AccommodationType.HOSTEL)
                .setHost(host)
                .build();
    }
}

