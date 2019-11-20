package com.devsda.hack.alterego.utils;

import com.devsda.hack.alterego.model.BookingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {

    private static final Logger log = LoggerFactory.getLogger(MailUtils.class);

    public static void sendMail(BookingInfo bookingInfo) {
        String recipient = "amanr.rastogi@gmail.com";
        String sender = "amanr.rastogi@gmail.com";
        String host = "127.0.0.1";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(bookingInfo.getEmailId()));
            message.setSubject("Compensation request for delayed flight");
            message.setText("This is a test mail");
            Transport.send(message);
            log.info("Mail successfully sent");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}