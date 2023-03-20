package application.betweentwo;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class Controller {

	private Model model;
	private int currStepNum;
	@FXML
	private Label headline;
	@FXML
	private VBox zutaten;
	@FXML
	private Label schrittCounter;
	@FXML
	private Button zurueckButton;
	@FXML
	private Button weiterButton;

	public Controller() {
		this.model = new Model();
		model.generateData();

		this.currStepNum = 0;
	}

	@FXML
	private void initialize() {
		setDataInView();
	}
	
	
	public void setDataInView() {
		Step currentStep = model.getStepByNum(currStepNum);
		headline.setText(currentStep.getName()); 			//headline 
		//Versteckt Weiter und Zurueck Button, wenn die Navigation sich am Anfang und am Ende befindet
		//Anfang
		if (currStepNum == 0)	{
			zurueckButton.setVisible(false);
		}else {
			zurueckButton.setVisible(true);
		}
		//Ende
		if (currStepNum == 3)	{
			weiterButton.setVisible(false);
		}else {
			weiterButton.setVisible(true);
		}
	
		ArrayList<Product> produkte = currentStep.getProducts();
		for(int i= 0; i < produkte.size();i++) {
			
			Product p = produkte.get(i);
			
			Label l = new Label (p.getName());
			HBox hb = new HBox (); 
			
			
			hb.setPrefWidth(517);
	 
			
			Region platzhalter = new Region(); 
			HBox.setHgrow(platzhalter, Priority.ALWAYS);
			
			l.setStyle(" -fx-padding: 0px 0px 0px 10px;");
			
			
			Label preisL = new Label (produkte.get(i).getPrice()+"");
			
			
			CheckBox cb = new CheckBox(); 
			HBox.setHgrow(cb, Priority.ALWAYS);
			
			Label lcb = new Label ();
			
			cb.selectedProperty().addListener(
				      (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
				    	  System.out.println(p.getName());
				      });
			
		
			hb.getChildren().add(cb);
			hb.getChildren().add(lcb);
			hb.getChildren().add(l);
			hb.getChildren().add(platzhalter);
			hb.getChildren().add(preisL);
			

			zutaten.getChildren().add(hb);
			
			
			
		}

		
		schrittCounter.setText("Schritt " + (currStepNum+1) + " von " +  model.getStepCount() );
		
	}
	public static void sendGmail()  {
        String to = "betweentwofrankfurt@gmail.com"; // Empfängeradresse
        String from = "betweentwoservice@gmail.com"; // Absenderadresse
        String host = "smtp.gmail.com"; // SMTP-Server-Adresse
        String user = "betweentwoservice@gmail.com"; // Benutzername für den SMTP-Server
        String password = ""; // Passwort für den SMTP-Server

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

	
	
	@FXML
	private void weiter (ActionEvent event) {
		currStepNum++;
		zutaten.getChildren().removeAll(zutaten.getChildren());
		setDataInView();
		
		
		
	}
	
	@FXML
	private void zurueck (ActionEvent event) {
		currStepNum--;
		zutaten.getChildren().removeAll(zutaten.getChildren());
		setDataInView();
		
	}
	
	@FXML
	private void bestellen (ActionEvent event) {
		try {
			//meine Problemstelle
	        sendGmail();
	        zutaten.getChildren().removeAll(zutaten.getChildren());
	        setDataInView();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
