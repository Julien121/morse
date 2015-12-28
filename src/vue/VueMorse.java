package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VueMorse extends Scene implements EventHandler<ActionEvent> {
	
	private Stage primaryStage;
	
	public VueMorse(Stage stage) {

		super(new Group(), 400, 600);


		this.primaryStage = stage;
	}

	@Override
	public void handle(ActionEvent arg0) {
		
	}
}
