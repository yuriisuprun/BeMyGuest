package com.ua.bemyguest.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(callSuper=true)
public class Host extends Person{

    public static final String JOIN_DATE = "join_date";
    public static final String WORK = "work";

    private Set<Accommodation> accommodations = new HashSet<>();
    private LocalDate joinDate;
    private String work;

    @Builder
    private Host(int id, String firstName, String lastName, String email, String phoneNumber,
                String country, LocalDate birthDate, String locality, Set<Accommodation> accommodations,
                 LocalDate joinDate, String work) {
        super(id, firstName, lastName, email, phoneNumber, country, birthDate, locality);
        this.accommodations = accommodations;
        this.joinDate = joinDate;
        this.work = work;
    }
}
