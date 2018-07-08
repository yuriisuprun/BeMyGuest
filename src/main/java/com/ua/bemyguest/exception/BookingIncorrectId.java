package com.ua.bemyguest.exception;

public class BookingIncorrectId extends Exception {

    @Override
    public String getMessage() {
        return "Incorrect booking id";
    }
}
