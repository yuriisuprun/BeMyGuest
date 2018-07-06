package com.ua.bemyguest.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(callSuper=true)
public class Host extends Person{

    public static final String ACCOMMODATIONS = "accommodations";
    public static final String LANGUAGES = "languages";
    public static final String JOIN_DATE = "join_date";
    public static final String WORK = "work";

    private Set<Accommodation> accommodations = new HashSet<>();
    private Set<String> languages = new HashSet<>();
    private LocalDate joinDate;
    private String work;

    private Host(){

    }

    public static Builder newBuilder(){
        return new Host().new Builder();
    }

    public Builder toBuilder(){
        return this.new Builder();
    }

    public class Builder {

        private Builder() {

        }

        public Builder setId(int id) {
            Host.super.setId(id);
            return this;
        }

        public Builder setFirstName(String firstName) {
            Host.super.setFirstName(firstName);
            return this;
        }

        public Builder setLastName(String lastName) {
            Host.super.setLastName(lastName);
            return this;
        }

        public Builder setEmail(String email) {
            Host.super.setEmail(email);
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            Host.super.setPhoneNumber(phoneNumber);
            return this;
        }

        public Builder setCountry(String country) {
            Host.super.setCountry(country);
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            Host.super.setBirthDate(birthDate);
            return this;
        }

        public Builder setLocality(String locality) {
            Host.super.setLocality(locality);
            return this;
        }

        public Builder setAccommodations(Set<Accommodation> accommodations){
            Host.this.accommodations = accommodations;
            return this;
        }

        public Builder setLanguages(Set<String> languages){
            Host.this.languages = languages;
            return this;
        }

        public Builder setJoinDate(LocalDate joinDate){
            Host.this.joinDate = joinDate;
            return this;
        }

        public Builder setWork(String work){
            Host.this.work = work;
            return this;
        }

        public Host build(){
            return Host.this;
        }
    }
}
