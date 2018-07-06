package com.ua.bemyguest.model;

import java.time.LocalDate;


public class Booking {

    public static final String ID = "id";
    public static final String ACCOMMODATION_ID = "accommodation_id";
    public static final String GUEST_ID = "guest_id";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";

    private int id;
    private int accommodationId;
    private int guestId;
    private LocalDate startDate;
    private LocalDate endDate;
}
