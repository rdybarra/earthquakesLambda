package earthquakeListener.repositories;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import earthquakeListener.models.USGSEarthquake;
import earthquakeListener.models.USGSEarthquakes;
import earthquakeListener.utils.GeometryFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class USGSRepository {
    List<USGSEarthquake> earthquakes = new ArrayList<USGSEarthquake>();
    boolean hasFetchedEarthquakes = false;

    public ArrayList<USGSEarthquake> get1Point0EarthquakesPastDay() {
        if (this.hasFetchedEarthquakes) {
            return (ArrayList) this.earthquakes;
        }

        final String uri = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_day.geojson";

        USGSEarthquakes earthquakes = new USGSEarthquakes();

        try {
            HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(uri));
            HttpResponse response = request.setParser(new JacksonFactory().createJsonObjectParser()).execute();
            earthquakes = response.parseAs(earthquakes.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }

        GeometryFilter geometryFilter = new GeometryFilter();

        ArrayList<USGSEarthquake> southernCaliforniaEarthquakes =  geometryFilter.filterByCoordinates(earthquakes.getFeatures());
        this.earthquakes = southernCaliforniaEarthquakes;
        this.hasFetchedEarthquakes = true;

        return southernCaliforniaEarthquakes;
    }

    public int getNumberOfEarthquakesInPastDay() {
        this.get1Point0EarthquakesPastDay();
        return this.earthquakes.size();
    }

    private String getCityFromPlace(String place) {
        String[] placeComponents = place.split("of");
        if (placeComponents.length > 1) {
            return placeComponents[1].trim();
        }

        return place;
    }

    public List<String> getHotspots() {
        final int hotspotThreshold = 4;
        ArrayList<String> hotspots = new ArrayList<String>();
        Map<String, Integer> locationCounts = new HashMap<String, Integer>();

        this.get1Point0EarthquakesPastDay();

        for(int i=0; i < this.earthquakes.size(); i++) {
            String place = this.getCityFromPlace(this.earthquakes.get(i).getProperties().getPlace());
            int count = locationCounts.getOrDefault(place, new Integer(0));
            count += 1;
            locationCounts.put(place, new Integer(count));
        }

        for (Map.Entry<String,Integer> locationCount : locationCounts.entrySet()) {
            if (locationCount.getValue() >= hotspotThreshold) {
                hotspots.add(locationCount.getKey() + " (" + locationCount.getValue() + ")");
            }
        }

        return hotspots;
    }
}
