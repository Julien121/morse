package vue;

import controleur.CtrlVueCode;
import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import perso.utils.MonJavaFX;

public class VueCode extends Stage {

    private CtrlVueCode controleur;

    private VBox rootLayout;

    public VueCode(Stage parent) {

        try {
            URL fxmlURL = VueMorse.class.getResource("Vue2.fxml");
            FXMLLoader loader = new FXMLLoader();
            this.rootLayout = (VBox) loader.load();

            this.controleur = (CtrlVueCode) loader.getController();
            this.controleur.setVue(this);

            Scene scene = new Scene(this.rootLayout);
            this.initOwner(parent);
            this.initModality(Modality.APPLICATION_MODAL);
            this.setX(parent.getX() + 80);
            this.setY(parent.getY() + 140);
            this.setScene(scene);
            this.setTitle("Listes de conversion");
        } catch (IOException ex) {
            MonJavaFX.erreur("Problème FXML", "Erreur lors du chargement de la vue \n" + ex.getMessage());
            System.out.println(ex.getMessage());
        }

    }

    public CtrlVueCode getControleur() {
        return this.controleur;
    }
}
