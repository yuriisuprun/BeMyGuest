package com.ua.bemyguest.exception;

public class HostIncorrectLastName extends Exception {

    @Override
    public String getMessage() {
        return "Incorrect last name of the host";
    }
}
