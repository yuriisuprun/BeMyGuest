package com.ua.bemyguest.model;

import lombok.*;

@Data
@Builder(toBuilder=true)
@ToString(callSuper=true)
public class Guest extends Person {

    public static final String PREFERRED_LANGUAGE = "preferred_language";

    private String preferredLanguage;
}

