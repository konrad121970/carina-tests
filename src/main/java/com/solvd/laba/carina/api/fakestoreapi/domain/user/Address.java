package com.solvd.laba.carina.api.fakestoreapi.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    private Geolocation geolocation;
    private String city;
    private String street;
    private Integer number;
    @JsonProperty("zipcode")
    private String zipCode;

    public Address() {
    }

    public Address(Geolocation geolocation, String city, String street, Integer number, String zipCode) {
        this.geolocation = geolocation;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
    }

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
