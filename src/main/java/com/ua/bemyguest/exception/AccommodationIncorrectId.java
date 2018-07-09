package com.ua.bemyguest.exception;

public class AccommodationIncorrectId extends Exception {

    @Override
    public String getMessage() {
        return "Incorrect accommodation id";
    }
}
