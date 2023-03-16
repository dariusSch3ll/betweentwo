package application.betweentwo;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class EmailSender {

    public static void sendEmail() throws Exception {

        String host = "smtp.gmail.com";
        String user = "BetweenTwoService@gmail.com";
        String password = "NenOViIT9BAaDxVgAYRb";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        String to = "btwofrankfurt@gmail.com";
        String subject = "Bestellung ist reingekommen";
        String body = "Die Bestellung enthält:";

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
        message.setText(body);

        Transport.send(message);

        System.out.println("Email sent successfully.");
    }
}
