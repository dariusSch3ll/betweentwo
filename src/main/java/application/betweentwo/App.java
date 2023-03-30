package application.betweentwo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.*;


public class App extends Application{
	
	//Created Logging
	private static Logger applicationlogger = LogManager.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		applicationlogger.info("Initialising App");
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
	    
        Scene scene = new Scene(root, 800, 400);
    
        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
		
	}

}
