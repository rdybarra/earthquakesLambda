//package com.example.earthquakes.repositories;
//
//import com.example.earthquakes.utils.GeometryFilter;
//import com.example.earthquakes.models.USGSEarthquake;
//import com.example.earthquakes.models.USGSEarthquakes;
//
//import org.springframework.web.client.RestTemplate;
//
//import java.util.ArrayList;
//
//public class USGSRepository {
//    public ArrayList<USGSEarthquake> get1Point0EarthquakesPastDay() {
//        final String uri = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_day.geojson";
//
//        RestTemplate restTemplate = new RestTemplate();
//        USGSEarthquakes result = restTemplate.getForObject(uri, USGSEarthquakes.class);
//
//        GeometryFilter geometryFilter = new GeometryFilter();
//        return geometryFilter.filterByCoordinates(result.getEarthquakes());
//    }
//}
