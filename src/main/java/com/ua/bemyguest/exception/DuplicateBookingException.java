package com.ua.bemyguest.exception;

public class DuplicateBookingException extends Exception{

    @Override
    public String getMessage() {
        return "Duplicate booking";
    }
}