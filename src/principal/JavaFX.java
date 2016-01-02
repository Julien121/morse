package principal;

import controleur.CtrlVueMorse;
import javafx.application.Application;
import javafx.stage.Stage;
import vue.VueMorse;

public class JavaFX extends Application {
	
    public static void main(String[] args) {
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage)
	{
		VueMorse vue = new VueMorse(primaryStage);
		CtrlVueMorse controleur = vue.getControleur(); 
		controleur.setModele(dao.FichiersPlats.lecture());
	}
        
}
