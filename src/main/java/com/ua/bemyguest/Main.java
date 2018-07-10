package com.ua.bemyguest;

import com.ua.bemyguest.controller.MainController;
import com.ua.bemyguest.exception.DuplicateGuestException;
import com.ua.bemyguest.exception.DuplicateHostException;
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
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

       /* MainController mainController = new MainController();
        mainController.doWork();*/

        Set<String> languages = new HashSet<>();
        languages.add("French");
        languages.add("English");
        languages.add("Italian");

       Host host = Host.builder()
               .firstName("James")
               .lastName("Smith")
               .email("james@gmail.com")
               .phoneNumber("0999990334")
               .country("USA")
               .birthDate(LocalDate.parse("1967-01-01"))
               .locality("Baltimore")
               .accommodations(null)
               .languages(languages)
               .joinDate(LocalDate.parse("2008-04-04"))
               .work("IT company, software engineer")
               .build();

       HostDAO hostDAO = new HostDAOH2Impl();
       AccommodationDAO accommodationDAO = new AccommodationDAOH2Impl();
        /*try {
            hostDAO.addHost(host);
        } catch (DuplicateHostException e) {
            e.printStackTrace();
        }*/

        Accommodation accommodation = Accommodation
                .newBuilder()
                .setTitle("Room in Rome")
                .setLocality("Rome")
                .setCountry("Italy")
                .setAddress("45 Porrettana street")
                .setHost(host)
                .setAccommodationType(AccommodationType.ROOM)
                .setDescription("Great room in the center of city.")
                .setPrice(1000)
                .build();

        accommodationDAO.addAccommodation(accommodation);
        System.out.println(hostDAO.getAllHosts());
    }
}

