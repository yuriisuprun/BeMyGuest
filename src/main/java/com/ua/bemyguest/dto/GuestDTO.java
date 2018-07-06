package com.ua.bemyguest.dto;

import com.ua.bemyguest.model.Guest;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GuestDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String preferredLanguage;

    public static GuestDTO guestToDTO(Guest guest){
        return GuestDTO.builder()
                .id(guest.getId())
                .firstName(guest.getFirstName())
                .lastName(guest.getLastName())
                .email(guest.getEmail())
                .preferredLanguage(guest.getPreferredLanguage())
                .build();
    }
}
