package com.ua.bemyguest.exception;

public class DuplicateHostException extends Exception {

    @Override
    public String getMessage() {
        return "Duplicate host";
    }
}
