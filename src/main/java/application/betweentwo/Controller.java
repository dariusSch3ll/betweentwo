package application.betweentwo;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Controller {

	private Model model;
	private int currStepNum;
	@FXML
	private Label headline;
	@FXML
	private VBox zutaten;
	@FXML
	private VBox zsmf;
	@FXML
	private VBox rechnen;
	@FXML
	private VBox WareBerechnen;
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
	
	
	
	public  void setDataInView() {
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
	
		ArrayList<Product> produkte = (ArrayList<Product>) currentStep.getProducts();
		for(int i= 0; i < produkte.size();i++) {
			Product p = produkte.get(i);
			
			//Zutaten erscheinen auf der gro�en Hbox
			Label L = new Label (p.getName());
			
			//neue Hbox erstellen
			HBox hb = new HBox (); 
			
			hb.setPrefWidth(517);
	 
			
			Region platzhalter = new Region(); 
			HBox.setHgrow(platzhalter, Priority.ALWAYS);
			
			L.setStyle(" -fx-padding: 0px 0px 0px 10px;");
			
			Label preisL = new Label (produkte.get(i).getPrice()+"");
			
			
			//Checkbox
			CheckBox cb = new CheckBox(); 
			HBox.setHgrow(cb, Priority.ALWAYS);
			
			Label lcb = new Label ();
			
		
		       
			
		
				    	  
			cb.setOnAction(event -> {
			    double ergebnis = 0;
			    for (Node node : zsmf.getChildren()) {
			        if (node instanceof HBox) {
			            HBox hbox = (HBox) node;
			            if (hbox.getChildren().size() == 2 && hbox.getChildren().get(0) instanceof Label && hbox.getChildren().get(1) instanceof Label) {
			                Label priceLabel = (Label) hbox.getChildren().get(1);
			                try {
			                    double getPrice = Double.parseDouble(priceLabel.getText());
			                    ergebnis += getPrice;
			                } catch (NumberFormatException e) {
			                
			                }
			            }
			        }
			    }
			    if (cb.isSelected()) {
			        ergebnis += p.getPrice();
			    } else {
			        ergebnis -= p.getPrice();
			    }
			    rechnen.getChildren().clear();
			    rechnen.getChildren().add(new Label(ergebnis + " Euro"));
			    
			    if (cb.isSelected()) {
			        // Erstelle eine HBox f�r Name und Preis
			        HBox productBox = new HBox();
			        productBox.setAlignment(Pos.CENTER_LEFT);

			        Label nameLabel = new Label(p.getName());
			        nameLabel.setPrefWidth(170);
			 

			        Label priceLabel = new Label(p.getPrice() + "");
			        

			        productBox.getChildren().addAll(nameLabel, priceLabel);

			        zsmf.getChildren().add(productBox);
			    } else {
			        zsmf.getChildren().removeIf(node -> {
			            if (node instanceof HBox) {
			                HBox hbox = (HBox) node;
			                if (hbox.getChildren().size() == 2 && hbox.getChildren().get(0) instanceof Label && hbox.getChildren().get(1) instanceof Label) {
			                    Label nameLabel = (Label) hbox.getChildren().get(0);
			                    Label priceLabel = (Label) hbox.getChildren().get(1);
			                    return nameLabel.getText().equals(p.getName()) && priceLabel.getText().equals(p.getPrice() + "");
			                }
			            }
			            return false;
			        });
			    }
			});

			

			
		
			hb.getChildren().add(cb);
			hb.getChildren().add(lcb);
			hb.getChildren().add(L);
			hb.getChildren().add(platzhalter);
			hb.getChildren().add(preisL);
			

			zutaten.getChildren().add(hb);
			
		}

		
		schrittCounter.setText("Schritt " + (currStepNum+1) + " von " +  model.getStepCount() );
		
		
		
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
	
		zutaten.getChildren().removeAll(zutaten.getChildren());
	       
        
	     
        String name = "";
        String preis= ""; 
        for (Node node : zsmf.getChildren()) {
	        if (node instanceof HBox) {
	            HBox hbox = (HBox) node;
	            if (hbox.getChildren().size() == 2 && hbox.getChildren().get(0) instanceof Label && hbox.getChildren().get(1) instanceof Label) {
	                Label nameLabel = (Label) hbox.getChildren().get(0);
	                name +=nameLabel.getText()+", ";
	                Label priceLabel = (Label) hbox.getChildren().get(1);
	                preis +=priceLabel.getText()+", ";
	                
	                
	            }
	        } 
	   }
        SendGmailTLS.sendGmail(name);
        SendGmailTLS.sendGmail(preis);
        
        Stage messageStage = new Stage();
        
        Label BetweenTwo = new Label("\n\nBetweenTwo\n");
       
        BetweenTwo.setFont(Font.font("SansSerif", FontWeight.BOLD, 15));
        
        Label schrift = new Label("Vielen Dank !"
        		+ "\nIhre Bestellung "
        		+ "wird so schnell wie möglich geliefert :)");
       
        schrift.setFont(Font.font("Serif", FontWeight.BOLD, 15));
       

        VBox messageBox = new VBox(BetweenTwo,schrift);
        messageBox.setAlignment(Pos.CENTER);
        messageBox.setSpacing(50);
        messageBox.setStyle("-fx-background-color:#B2E097;");
        
        
        
        Scene messageScene = new Scene(messageBox,400, 200);
        messageStage.setScene(messageScene);
        messageStage.show();
       
        
 
	}
  


}
