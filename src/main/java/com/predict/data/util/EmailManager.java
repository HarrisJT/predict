package com.predict.data.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public final class EmailManager {

    private static final String EMAIL_ADDRESS = "predictapp.noreply@gmail.com";
    private static final String EMAIL_PASSWORD = "coffee4hat2";
    private static final String EMAIL_HOST = "smtp.gmail.com";
    private static final String EMAIL_PORT = "587";
    private static final Properties EMAIL_PROPERTIES;

    /**
     * Static utility class
     */
    private EmailManager() { }

    static {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", EMAIL_HOST);
        properties.put("mail.smtp.port", EMAIL_PORT);
        properties.put("mail.smtp.starttls.enable", "true");
        EMAIL_PROPERTIES = properties;
    }

    public static boolean sendEmail(String[] recipients, String subject, String content) {
        Authenticator authenticator = new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(EMAIL_ADDRESS, EMAIL_PASSWORD);
            }
        };
        Session session = Session.getInstance(EMAIL_PROPERTIES, authenticator);
        MimeMessage message = new MimeMessage(session);
        try {
            // Format email
            Address[] addresses = new Address[recipients.length];
            for(int i = 0; i < recipients.length; i++) {
                addresses[i] = new InternetAddress(recipients[i]);
            }
            Address system = new InternetAddress(EMAIL_ADDRESS);
            message.setFrom(system);
            message.addRecipient(Message.RecipientType.TO, system);
            message.addRecipients(Message.RecipientType.BCC, addresses);
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
        } catch (MessagingException e) {
            return false;
        }
        return true;
    }
}
