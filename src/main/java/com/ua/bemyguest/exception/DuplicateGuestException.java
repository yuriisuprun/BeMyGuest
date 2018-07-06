package com.ua.bemyguest.exception;

public class DuplicateGuestException extends Exception{

    @Override
    public String getMessage() {
        return "Duplicate guest";
    }
}
