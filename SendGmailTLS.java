package application.betweentwo;

import java.util.Properties;
import javax.mail.*;
//import javax.mail.internet.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendGmailTLS {

	public static void sendGmail()  {
		        String to = "betweentwofrankfurt@gmail.com"; // Empfängeradresse
		        String from = "betweentwoservice@gmail.com"; // Absenderadresse
		        String host = "smtp.gmail.com"; // SMTP-Server-Adresse
		        String user = "betweentwoservice@gmail.com"; // Benutzername für den SMTP-Server
		        String password = "vflzleqmygetgouy"; // Passwort für den SMTP-Server

		        // Konfiguration der SMTP-Einstellungen
		        Properties props = new Properties();
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.starttls.enable", "true");
		        props.put("mail.smtp.host", host);
		        props.put("mail.smtp.port", "587"); //default:587

		        // Erstellen einer Sitzung mit SMTP-Authentifizierung
		        Session session = Session.getInstance(props, new Authenticator() {
		            @Override
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(user, password);
		            }
		        });

		        try {
		            // Erstellen der E-Mail-Nachricht
		            MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(from));
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		            message.setSubject("Bestellung ist Eingegangen");
		            message.setText("Bestellungsdetails");

		            // Senden der E-Mail-Nachricht
		            Transport.send(message);
		            System.out.println("Nachricht erfolgreich gesendet");
		            
		        } catch (MessagingException mex) {
		            System.out.println("Fehler beim Senden der Nachricht: " + mex.getMessage());
		        }
		    }
		}
