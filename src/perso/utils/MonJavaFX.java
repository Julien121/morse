package perso.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MonJavaFX {
	
	/**
	 * Affiche une fen�tre d'erreur
	 * @param header Le titre de la fen�tre
	 * @param msg Le message d'erreur
	 */
	public static void erreur(String header, String msg) {
		
		Alert dialogE = new Alert(AlertType.ERROR);
		dialogE.setTitle("Erreur en cours...");
		dialogE.setHeaderText(header);
		dialogE.setContentText(msg);
		dialogE.showAndWait();
		
	}
	/**
	 * Affiche une fen�tre informationnelle
	 * @param header Le titre de la fen�tre
	 * @param msg Le message d'informations
	 */
	public static void info(String header, String msg) {
		
		Alert dialogE = new Alert(AlertType.INFORMATION);
		dialogE.setTitle("Information...");
		dialogE.setHeaderText(header);
		dialogE.setContentText(msg);
		dialogE.showAndWait();
		
	}

}
