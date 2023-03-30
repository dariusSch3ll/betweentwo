module Konfigurator {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.fxml;
	requires java.mail;
    
    opens application.betweentwo to javafx.graphics, javafx.fxml;
}