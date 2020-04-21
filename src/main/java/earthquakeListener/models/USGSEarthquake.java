package earthquakeListener.models;

import com.google.api.client.util.Key;

public class USGSEarthquake {
    @Key
    private EarthquakeProperties properties;

    @Key
    private EarthquakeGeometry geometry;

    public void setProperties(EarthquakeProperties properties) {
        this.properties = properties;
    }

    public void setGeometry(EarthquakeGeometry geometry) {
        this.geometry = geometry;
    }

    public EarthquakeGeometry getGeometry() {
        return geometry;
    }

    public EarthquakeProperties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "USGSEarthquake{" +
                "properties=" + properties.toString() +
                "geometry=" + geometry.toString() +
                '}';
    }
}

