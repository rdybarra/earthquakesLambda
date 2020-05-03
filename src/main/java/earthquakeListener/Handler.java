package earthquakeListener;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import earthquakeListener.repositories.EmailRecipients;
import earthquakeListener.repositories.USGSRepository;
import earthquakeListener.utils.EarthquakeEmailContent;
import earthquakeListener.utils.SendEmail;

public class Handler implements RequestHandler<Object, String>{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public String handleRequest(Object event, Context context)
    {
        LambdaLogger logger = context.getLogger();
        String response = new String("200 OK");
        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        // process event
        logger.log("EVENT: " + gson.toJson(event));
        logger.log("EVENT TYPE: " + event.getClass().toString());

        USGSRepository earthquakeRepository = new USGSRepository();
        EmailRecipients emailRecipients = new EmailRecipients();

        EarthquakeEmailContent earthquakeEmailContent = new EarthquakeEmailContent(earthquakeRepository);
        SendEmail emailClient = new SendEmail();
        for (String recipient: emailRecipients.getRecipients()) {
            emailClient.sendEmail(recipient, earthquakeEmailContent.getSubject(), earthquakeEmailContent.getHTMLReport(), earthquakeEmailContent.getTextReport());
        }

        return response;
    }
}

