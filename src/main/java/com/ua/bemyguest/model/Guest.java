package com.ua.bemyguest.model;

import lombok.*;

import java.time.LocalDate;

@Data
@ToString(callSuper=true)
public class Guest extends Person {

    public static final String PREFERRED_LANGUAGE = "preferred_language";

    private String preferredLanguage;

    @Builder
    private Guest(int id, String firstName, String lastName, String email, String phoneNumber,
                 String country, LocalDate birthDate, String locality, String preferredLanguage) {
        super(id, firstName, lastName, email, phoneNumber, country, birthDate, locality);
        this.preferredLanguage = preferredLanguage;
    }
}

