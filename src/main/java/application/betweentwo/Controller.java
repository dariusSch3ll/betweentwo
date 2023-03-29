package application.betweentwo;
import java.util.ArrayList;
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
	        SendGmailTLS.sendGmail();
	        zutaten.getChildren().removeAll(zutaten.getChildren());
	        setDataInView();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
