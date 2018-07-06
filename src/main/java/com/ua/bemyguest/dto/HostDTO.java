package com.ua.bemyguest.dto;

import com.ua.bemyguest.model.Accommodation;
import com.ua.bemyguest.model.Host;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class HostDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<Accommodation> accommodations;

    public static HostDTO hostToDTO(Host host){
        return HostDTO.builder()
                .id(host.getId())
                .firstName(host.getFirstName())
                .lastName(host.getLastName())
                .email(host.getEmail())
                .accommodations(host.getAccommodations())
                .build();
    }
}
