package com.ua.bemyguest.exception;

public class GuestIncorrectLastName extends Exception {
    @Override
    public String getMessage() {
        return "Incorrect last name of the guest";
    }
}
