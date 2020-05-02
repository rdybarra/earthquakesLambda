package earthquakeListener.repositories;

import java.util.ArrayList;

public class EmailRecipients {
    public ArrayList<String> getRecipients() {
        ArrayList<String> recipients = new ArrayList<String>();

        // TODO: not this. I know this isn't fooling anyone, but at least make it a little challenging for the bots.
        String recipient = "ricky" + "." + "ybarra";
        recipient += "@";
        recipient += "yah" + "oo";
        recipient += ".";
        recipient += "com";

        recipients.add(recipient);

        return recipients;
    }
}
