package earthquakeListener;

//import earthquakeListener.controllers.Earthquakes;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.reflect.TypeToken;
import earthquakeListener.models.USGSEarthquake;
import earthquakeListener.models.USGSEarthquakes;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
//        Earthquakes earthquakesController = new Earthquakes();

//        ArrayList<com.example.earthquakes.models.USGSEarthquake> earthquakes = earthquakesController.fetchLocalEarthquakes();

        String rawResponse = "";
        USGSEarthquakes earthquakes = new USGSEarthquakes();

        try {
            HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
            HttpRequest request = requestFactory.buildGetRequest(new GenericUrl("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/1.0_day.geojson"));
//            rawResponse = request.execute().parseAsString();
//            System.out.println(rawResponse);

            Type type = new TypeToken<USGSEarthquakes>() {}.getType();
            System.out.println(type);

            HttpResponse response = request.setParser(new JacksonFactory().createJsonObjectParser()).execute();

            System.out.println(response.getStatusCode());


            earthquakes = response.parseAs(earthquakes.getClass());

            System.out.println(earthquakes.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(earthquakes.toString());
    }
}
