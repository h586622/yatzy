package no.gruppe6.yatzy.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {

    private static Message message;

    public static void setupMail(String recepient, String subject, String text) throws MessagingException {
        System.out.println("Klargjør melding");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String senderMail = "erlendmatch@gmail.com";
        String password = "RomvesenTelefon8111";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, password);
            }

        });

        message = prepareMessage(session, senderMail, recepient, subject, text);



    }

    private static Message prepareMessage(Session session, String senderMail, String recepient, String subject,
                                          String text) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setText(text);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setSubject(String subject) {
        try {
            message.setSubject(subject);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void setText(String text) {
        try {
            message.setText(text);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendMail() {
        try {
            Transport.send(message);
            System.out.println("Melding sendt");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
