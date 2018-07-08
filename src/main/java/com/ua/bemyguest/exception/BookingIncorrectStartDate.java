package com.ua.bemyguest.exception;

public class BookingIncorrectStartDate extends Exception{

    @Override
    public String getMessage() {
        return "Incorrect start date of the booking";
    }
}
