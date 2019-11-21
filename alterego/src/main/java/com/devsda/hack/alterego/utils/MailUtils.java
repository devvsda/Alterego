package com.devsda.hack.alterego.utils;

import com.devsda.hack.alterego.constant.AlteregoConstants;
import com.devsda.hack.alterego.model.BookingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {

    private static final Logger log = LoggerFactory.getLogger(MailUtils.class);

    public static void sendMail(BookingInfo bookingInfo) {
        String recipient = "mail2jhamb@gmail.com";
        String sender = "hackalterego@gmail.com";
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("hackalterego@gmail.com", "hack@microsoft");
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.addRecipient(Message.RecipientType.CC, new InternetAddress(bookingInfo.getEmailId()));
            message.setSubject(AlteregoConstants.MailConstants.SUBJECT);
            message.setText(AlteregoConstants.MailConstants.BODY);
            Transport.send(message);
            log.info("Mail successfully sent");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookingInfo bi = new BookingInfo();
        bi.setEmailId("amnwidfrenz@gmail.com");
        sendMail(bi);
    }
}