package com.ua.bemyguest.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Host extends Person{

    public static final String ACCOMMODATIONS = "accommodations";
    public static final String LANGUAGES = "languages";
    public static final String JOIN_DATE = "join_date";
    public static final String WORK = "work";

    private Set<Accommodation> accommodations = new HashSet<>();
    private Set<String> languages = new HashSet<>();
    private LocalDate joinDate;
    private String work;

    @Builder
    private Host(int id, String firstName, String lastName, String email, String phoneNumber,
                String country, LocalDate birthDate, String locality, Set<Accommodation> accommodations,
                 Set<String> languages, LocalDate joinDate, String work) {
        super(id, firstName, lastName, email, phoneNumber, country, birthDate, locality);
        this.accommodations = accommodations;
        this.languages = languages;
        this.joinDate = joinDate;
        this.work = work;
    }
}
