package com.solvd.laba.carina.api.fakestoreapi.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geolocation {

    private Double latitude;

    private Double longitude;

    public Geolocation() {
    }

    public Geolocation(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @JsonProperty("lat")
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    @JsonProperty("long")
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
