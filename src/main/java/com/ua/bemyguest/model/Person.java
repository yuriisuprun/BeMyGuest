package com.ua.bemyguest.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public abstract class Person {

    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String COUNTRY = "country";
    public static final String BIRTH_DATE = "birth_date";
    public static final String LOCALITY = "locality";

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String country;
    private LocalDate birthDate;
    private String locality;
}
