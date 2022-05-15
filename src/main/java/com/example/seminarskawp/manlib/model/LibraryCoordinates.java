package com.example.seminarskawp.manlib.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class LibraryCoordinates {

    private Double coordinates_long;
    private Double coordinates_lat;

    public LibraryCoordinates(Double coordinates_long, Double coordinates_lat) {
        this.coordinates_long = coordinates_long;
        this.coordinates_lat = coordinates_lat;
    }

    public LibraryCoordinates() {
    }

    public Double getLang() {
        return coordinates_long;
    }

    public void setLang(Double lang) {
        this.coordinates_long = coordinates_long;
    }

    public Double getLat() {
        return coordinates_lat;
    }

    public void setLat(Double lat) {
        this.coordinates_lat = coordinates_lat;
    }
}
