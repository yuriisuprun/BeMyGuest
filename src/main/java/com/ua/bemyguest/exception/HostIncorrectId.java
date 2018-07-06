package com.ua.bemyguest.exception;

public class HostIncorrectId extends Exception {

    @Override
    public String getMessage() {
        return "Incorrect host id!";
    }
}
