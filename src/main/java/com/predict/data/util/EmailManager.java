package com.predict.data.util;

import com.predict.data.entity.User;
import com.predict.data.service.UserService;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class EmailManager {

  private static final Logger logger = LoggerFactory.getLogger(EmailManager.class);

  private static final String EMAIL_ADDRESS;
  private static final String EMAIL_PASSWORD;
  private static final String EMAIL_HOST;
  private static final String EMAIL_PORT;
  private static final Properties EMAIL_PROPERTIES;

  static {
    // Initialize static variables
    EMAIL_ADDRESS = ConfigManager.getProperty("email_address");
    EMAIL_PASSWORD = ConfigManager.getProperty("email_password");
    EMAIL_HOST = ConfigManager.getProperty("email_host");
    EMAIL_PORT = ConfigManager.getProperty("email_port");

    // Initialize email properties
    Properties properties = new Properties();
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.host", EMAIL_HOST);
    properties.put("mail.smtp.port", EMAIL_PORT);
    properties.put("mail.smtp.starttls.enable", "true");
    EMAIL_PROPERTIES = properties;
  }

  private UserService userService;

  @Autowired
  public EmailManager(UserService userService) {
    this.userService = userService;
  }

  /**
   * Sends a mass email
   *
   * @param recipients is an array of addresses to be blind carbon copied onto the email
   * @param subject is the email subject
   * @param content is the content of the email
   * @returns whether the email was sent successfully
   */
  private void sendEmail(String[] recipients, String subject, String content) {
    Authenticator authenticator = new javax.mail.Authenticator() {
      protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
        return new javax.mail.PasswordAuthentication(EMAIL_ADDRESS, EMAIL_PASSWORD);
      }
    };
    Session session = Session.getInstance(EMAIL_PROPERTIES, authenticator);
    MimeMessage message = new MimeMessage(session);
    try {
      Address[] addresses = new Address[recipients.length];
      for (int i = 0; i < recipients.length; i++) {
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
      logger.error("Email error: ", e);
    }
  }

  /**
   * Sends an email to all current users
   *
   * @param content is the content of the email
   * @returns whether or not it succeeded
   */
  public void sendEmailToAllUsers(String content) {
    try {
      List<User> users = userService.retrieveAllUsers();
      String[] emailAddresses = new String[users.size()];

      for (int i = 0; i < users.size(); i++) {
        emailAddresses[i] = users.get(i).getEmail().replaceAll(",", ".");
        logger.debug("Successfully sent email: " + emailAddresses[i]);
      }
      sendEmail(emailAddresses, "New PredictApp Question!", content);
      logger.debug("Sucecssfully sent email: " + content);
    } catch (Exception e) {
      logger.error("Error sending email: " + content);
    }
  }
}
