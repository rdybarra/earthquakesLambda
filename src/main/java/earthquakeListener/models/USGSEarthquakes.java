//package earthquakeListener.models;
//
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//
//public class USGSEarthquakes {
//    static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//    static JsonFactory JSON_FACTORY = new JacksonFactory();
//}


package earthquakeListener.models;
import com.google.api.client.util.Key;

import java.util.ArrayList;
import java.util.List;

public class USGSEarthquakes {
    @Key
    public List<USGSEarthquake> features = new ArrayList();



    public void setFeatures(List<USGSEarthquake> earthquakes) {
        this.features = earthquakes;
    }

    public List<USGSEarthquake> getFeatures() {
        return this.features;
    }

    @Override
    public String toString() {
        String outputString = "";

        for(int i = 0; i < this.features.size(); i++) {
            outputString = outputString + this.features.get(i) + "\n\n";
        }

        return "USGSEarthquakes{" +
                "earthquakes=\n" + outputString +
                '}';
    }
}
