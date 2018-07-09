package com.ua.bemyguest.exception;

public class AccommodationIncorrectTitle extends Exception{

    @Override
    public String getMessage() {
        return "Incorrect accommodation title";
    }
}
