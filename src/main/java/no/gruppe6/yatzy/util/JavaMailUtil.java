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

    public static void setupMail(String mottaker, String emne, String tekst) throws MessagingException {
        System.out.println("Klargjør melding");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String senderMail = "erlendmatch@gmail.com";
        String passord = "RomvesenTelefon8111";

        Session sesjon = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, passord);
            }

        });

        Message melding = prepareMessage(sesjon, senderMail, mottaker, emne, tekst);

        Transport.send(melding);

        System.out.println("Melding sendt");

    }

    private static Message prepareMessage(Session sesjon, String senderMail, String mottaker, String emne,
                                          String tekst) {
        try {
            Message message = new MimeMessage(sesjon);
            message.setFrom(new InternetAddress(senderMail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(mottaker));
            message.setSubject(emne);
            message.setText(tekst);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
