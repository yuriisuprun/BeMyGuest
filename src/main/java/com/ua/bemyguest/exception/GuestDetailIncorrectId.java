package com.ua.bemyguest.exception;

public class GuestDetailIncorrectId extends Exception {

    @Override
    public String getMessage() {
        return "Incorrect guest detail id";
    }
}
