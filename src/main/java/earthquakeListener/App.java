package earthquakeListener;

import earthquakeListener.models.USGSEarthquake;
import earthquakeListener.repositories.USGSRepository;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        USGSRepository earthquakeRepository = new USGSRepository();
//        int numberOfEarthquakes = earthquakeRepository.getNumberOfEarthquakesInPastDay();

        ArrayList<String> hotSpots =(ArrayList) earthquakeRepository.getHotspots();

        for(int i = 0; i < hotSpots.size(); i++) {
            System.out.println(hotSpots.get(i));
        }
    }
}
