package no.gruppe6.yatzy.util;

import no.gruppe6.yatzy.dao.SpillDAO;
import no.gruppe6.yatzy.entities.Spilldeltagelse;

import java.util.List;
import java.util.Properties;

import javax.ejb.EJB;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {

    @EJB
    private SpillDAO spillDao;


    /**
     * A method to set up
     *
     * @param mottaker is the receiver of the mail, as a String
     * @param emne   is the subject of the mail to be sent
     * @param tekst     is the content of the mail
     * @throws MessagingException
     */
    public static void setupMail(String mottaker, String emne, String tekst) throws MessagingException {

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String senderMail = "erlendmatch@gmail.com";
        String password = "RomvesenTelefon8111";

        Session sesjon = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, password);
            }

        });

        Message melding = prepareMessage(sesjon, senderMail, mottaker, emne, tekst);

        Transport.send(melding);


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

    public static void gameStartMail(List<Spilldeltagelse> spilldeltagelse, String spillnavn) throws MessagingException {

        for (Spilldeltagelse s : spilldeltagelse) {
            setupMail(s.getBruker().getEpost(), "Yatzy App", "Spillet " + spillnavn + " har startet, logg deg inn og bli med på morroa!");
        }

    }

}


