package com.ua.bemyguest.exception;

public class GuestIncorrectId extends Exception {

    @Override
    public String getMessage() {
        return "Incorrect guest id!";
    }
}
