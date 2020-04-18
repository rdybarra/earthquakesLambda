//package com.example.earthquakes.utils;
//
///*
//Box coordinate of so cal randomly chosen by me :)
//1 2
//4 3
//
//1. 35.4620  -121.2955
//2. 35.4620  -115.2434
//3. 31.5656  -115.2424
//4. 31.5656  -121.2955
//*/
//
//import com.example.earthquakes.models.USGSEarthquake;
//
//import java.util.ArrayList;
//
//public class GeometryFilter {
//    final double northLat = 35.4620;
//    final double southLat = 31.5656;
//    final double westLong = -121.2955;
//    final double eastLong = -115.2424;
//
//    public ArrayList<USGSEarthquake> filterByCoordinates(ArrayList<USGSEarthquake> earthquakes) {
//        ArrayList<USGSEarthquake> filteredEarthquakes = new ArrayList();
//
//        for(int i = 0; i < earthquakes.size(); i++) {
//            if (latitudeInBounds(earthquakes.get(i).getGeometry().getCoordinates()[1]) && longitudeInBounds(earthquakes.get(i).getGeometry().getCoordinates()[0])) {
//                filteredEarthquakes.add(earthquakes.get(i));
//            }
//        }
//
//        return filteredEarthquakes;
//    }
//
//    private static boolean inRange(double value, double min, double max) {
//        return value > min && value < max;
//    }
//
//    private boolean latitudeInBounds(double latitude) {
//        return GeometryFilter.inRange(latitude, this.southLat, this.northLat);
//    }
//
//    private boolean longitudeInBounds(double longitude) {
//        return GeometryFilter.inRange(longitude, this.westLong, this.eastLong);
//    }
//}
