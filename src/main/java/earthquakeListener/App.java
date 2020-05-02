package earthquakeListener;

import earthquakeListener.repositories.EmailRecipients;
import earthquakeListener.repositories.USGSRepository;
import earthquakeListener.utils.EarthquakeEmailContent;
import earthquakeListener.utils.SendEmail;

public class App {
    public static void main(String[] args) {
        USGSRepository earthquakeRepository = new USGSRepository();
        EmailRecipients emailRecipients = new EmailRecipients();

        EarthquakeEmailContent earthquakeEmailContent = new EarthquakeEmailContent(earthquakeRepository);
        SendEmail emailClient = new SendEmail();
        for (String recipient: emailRecipients.getRecipients()) {
            emailClient.sendEmail(recipient, earthquakeEmailContent.getSubject(), earthquakeEmailContent.getHTMLReport(), earthquakeEmailContent.getTextReport());
        }
    }
}
