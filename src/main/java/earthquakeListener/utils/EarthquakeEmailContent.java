package earthquakeListener.utils;

import earthquakeListener.repositories.USGSRepository;

import java.util.ArrayList;

public class EarthquakeEmailContent {
    private USGSRepository earthquakeRepository;

    public EarthquakeEmailContent(USGSRepository earthquakeRepository) {
        this.earthquakeRepository = earthquakeRepository;
    }

    public String getSubject() {
        return "Earthquake Report";
    }

    public String getTextReport() {
        int numberOfEarthquakes = this.earthquakeRepository.getNumberOfEarthquakesInPastDay();
        ArrayList<String> hotSpots =(ArrayList) this.earthquakeRepository.getHotspots();

        String textBody = "Earthquake Report."
                + "There were " + numberOfEarthquakes + " earthquakes today. "
                + "There were " + hotSpots.size() + " hot spot(s). ";
        for (String hotSpot: hotSpots) {
            textBody = textBody + hotSpot + " ";
        }

        return textBody.trim();
    }

    public String getHTMLReport() {
        int numberOfEarthquakes = this.earthquakeRepository.getNumberOfEarthquakesInPastDay();
        ArrayList<String> hotSpots =(ArrayList) this.earthquakeRepository.getHotspots();
        boolean hasHotSpots = hotSpots.size() > 0;

        for (String hotSpot: hotSpots) {
            System.out.println(hotSpot);
        }

        String htmlBody = "<h1>Earthquake Report</h1>"
                + "<p>There were " + numberOfEarthquakes + " earthquakes today.</p>";


        if (!hasHotSpots) {
            htmlBody += "There were no hot spots today";
        } else {
            htmlBody += "<p>There were " + hotSpots.size() + " hot spot(s):</p>";
        }

        if (hasHotSpots) {
            htmlBody = htmlBody + "<ul>";
            for (String hotSpot : hotSpots) {
                htmlBody = htmlBody + "<li>" + hotSpot + "</li>";
            }
            htmlBody = htmlBody + "</ul>";
        }

        return htmlBody;
    }
}
