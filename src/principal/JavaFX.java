package principal;

import javafx.application.Application;
import javafx.stage.Stage;
import vue.VueMorse;

public class JavaFX extends Application {
	
    public static void main(String[] args) {
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage){
		new VueMorse(primaryStage);
	}
        
}
