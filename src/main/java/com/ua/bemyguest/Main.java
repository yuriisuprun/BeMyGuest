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

    public static void main(String... args) {

        /*HostDAOH2Impl hostDAO = new HostDAOH2Impl();
        hostDAO.dropHostTable();*/

        /*HostDAOH2Impl hostDAOH2 = new HostDAOH2Impl();
        Host host = Host.builder()
                .firstName("Drew")
                .birthDate(LocalDate.now())
                .joinDate(LocalDate.of(2015, 01, 15))
                .build();
        try {
            hostDAOH2.addHost(host);
        } catch (DuplicateHostException e) {
            e.printStackTrace();
        }*/


        MainController mainController = new MainController();
        mainController.doWork();
    }
}

