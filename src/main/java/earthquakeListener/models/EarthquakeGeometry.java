package com.example.earthquakes.models;

import com.google.api.client.util.Key;

import java.util.Arrays;

public class EarthquakeGeometry {
    @Key
    private Double[] coordinates = new Double[3];

    public void setCoordinates(Double[] coordinates) {
        this.coordinates = coordinates;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "EarthquakeGeometry{" +
                "coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
}
