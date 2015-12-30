package perso.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MonJavaFX {
	
	public static void erreur(String header, String msg) {
		
		Alert dialogE = new Alert(AlertType.ERROR);
		dialogE.setTitle("Erreur en cours...");
		dialogE.setHeaderText(header);
		dialogE.setContentText(msg);
		dialogE.showAndWait();
		
	}

	public static void info(String header, String msg) {
		
		Alert dialogE = new Alert(AlertType.INFORMATION);
		dialogE.setTitle("Information...");
		dialogE.setHeaderText(header);
		dialogE.setContentText(msg);
		dialogE.showAndWait();
		
	}

}
