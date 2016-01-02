package vue;

import java.io.IOException;

import controleur.CtrlVueMorse;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class VueMorse extends Scene {

    private Stage primaryStage;
    private VBox rootLayout;
    private CtrlVueMorse controleur;
    
	/**
	 * Initialise la fenêtre
	 * @param parent Une instance de Stage
	 */
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
            this.controleur = (CtrlVueMorse) loader.getController();
            this.controleur.setVue(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setRoot(this.rootLayout);
        this.primaryStage.setScene(this);
    }

    /**
     * Placement de la fenï¿½tre
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

        this.primaryStage.setTitle("Morse");
        this.primaryStage.show();

    }
    /**
     * Crée une nouvelle vue
     * @return Une instance de VueCode
     */
    public VueCode creeVueSecondaire() {

        return new VueCode(this.primaryStage);

    }
    /**
     * Retourne le controleur
     * @return controleur Une instance de CtrlVueMorse
     */
    public CtrlVueMorse getControleur() {
        return this.controleur;
    }
}
