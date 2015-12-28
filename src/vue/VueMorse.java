package vue;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class VueMorse extends Scene implements EventHandler<ActionEvent> {
	
	private Stage primaryStage;
	private VBox rootLayout;
	
	public VueMorse(Stage stage) {

		super(new Group(), 400, 600);
		this.primaryStage = stage;
		
		this.chargeFenetre();
		this.placeFenetre();
	}
	
	/**
	 * Chargement du fichier fxml
	 */
	private void chargeFenetre() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(VueMorse.class.getResource("Vue1.fxml"));
			this.rootLayout = (VBox) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.setRoot(this.rootLayout);
		this.primaryStage.setScene(this);

		Button bCreer = (Button) this.rootLayout.lookup("#vue1_bCreer");
		bCreer.setOnAction(this);

	}
	/**
	 * Placement de la fenétre
	 */
	private void placeFenetre() {

		int hauteurEcran;
		int largeurEcran;
		int origineX, origineY;

		Rectangle2D dimEcran = Screen.getPrimary().getVisualBounds();

		hauteurEcran = (int) (dimEcran.getHeight());
		largeurEcran = (int) (dimEcran.getWidth());

		// Placement : Ã  10% du bord
		origineX = largeurEcran / 10;
		origineY = hauteurEcran / 10;

		this.primaryStage.setX(origineX);
		this.primaryStage.setY(origineY);

		this.primaryStage.setTitle("Portefeuille javaFX");
		this.primaryStage.show();

	}
	@Override
	public void handle(ActionEvent arg0) {
		
	}
}
