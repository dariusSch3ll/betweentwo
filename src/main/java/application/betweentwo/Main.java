package application.betweentwo;


import org.apache.logging.log4j.*;


public class Main {

	//Created Logging
	private static Logger applicationlogger = LogManager.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		applicationlogger.info("Launching Main Class");
		App.main(args);
	}
}
