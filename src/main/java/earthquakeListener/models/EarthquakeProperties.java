package earthquakeListener.models;

import com.google.api.client.util.Key;
import java.math.BigInteger;

public class EarthquakeProperties {

    @Key
    private float mag;

    @Key
    private String place;

    @Key
    public BigInteger time;

    public void setMag(float mag) {
        this.mag = mag;
    }

    public void setPlace(String place) {
        this.place = place;
    }


    public void setTime(BigInteger time) {
        this.time = time;
    }

    public float getMag() {
        return mag;
    }

    public String getPlace() {
        return place;
    }

    public BigInteger getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "EarthquakeProperties{" +
                "mag=" + mag +
                ", place='" + place + '\'' +
                ", time=" + time +
                '}';
    }
}
