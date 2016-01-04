package vue;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import controleur.CtrlVueCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.metier.Code;
import perso.utils.MonJavaFX;

public class VueCode extends Stage {

    private CtrlVueCode controleur;

    private VBox root;
    
	/**
	 * Initialise la fenêtre
	 * @param parent Une instance de Stage
	 */
    public VueCode(Stage parent) {

        try {
            URL fxmlURL = VueMorse.class.getResource("Vue2.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
            this.root = (VBox) fxmlLoader.load();

            this.controleur = fxmlLoader.getController();
            this.controleur.setVue(this);

            Scene scene = new Scene(this.root);
            this.initOwner(parent);
            this.initModality(Modality.APPLICATION_MODAL);
            this.setX(parent.getX() + 80);
            this.setY(parent.getY() + 140);
            this.setScene(scene);
            this.setTitle("Listes de conversion");
        } catch (IOException ex) {
            MonJavaFX.erreur("ProblÃ¨me FXML", "Erreur lors du chargement de la vue \n" + ex.getMessage());
        }

    }
    
    /**
     * Retourne le controleur
     * @return controleur Une instance de CtrlVueCode
     */
    public CtrlVueCode getControleur() {
        return this.controleur;
    }
    /**
     * Crée la listView et ajoute les codes dans la listView
     * @param lesCodes La liste des codes
     */
    public void afficherListeConversion(ArrayList<Code> lesCodes) {
        FlowPane fP = (FlowPane) this.root.lookup("#FPListView");
        fP.getChildren().clear();
        ObservableList<String> items = FXCollections.observableArrayList();
        ListView<String> liste = new ListView<String>();
        for (Code c : lesCodes) {
            items.add(Character.toString(c.getLettre()) + " : " + c.getCodeLettre());
        }
        liste.setItems(items);
        liste.setPrefWidth(350.0);
        liste.setPrefHeight(150.0);
        liste.setId("vue2_ListeConversion");
        fP.getChildren().add(liste);
    }
    /**
     * Affiche ou cache le formulaire
     * @param visible Vrai il affiche le formulaire sinon il le cache
     */
    public void afficherAction(boolean visible){
        TextField tSaisieConversion = (TextField) this.root.lookup("#vue2_tfSaisieModifConversion");
        tSaisieConversion.setVisible(visible);
        Button valider = (Button) this.root.lookup("#vue2_btnValider");
        valider.setVisible(visible);
    }
    /**
     * Récupère la saisie
     * @return La saisie
     */
    public String saisieNouvelleConversion(){
        
        String conversion = null;
        TextField tSaisieConversion = (TextField) this.root.lookup("#vue2_tfSaisieModifConversion");
        conversion = tSaisieConversion.getText();
        return conversion; 
    }
    /**
     * Récupère la sélection de la listView
     * @return La sélection
     */
	public String listeSelection(){
		@SuppressWarnings("unchecked")
		ListView<String> liste = (ListView<String>) this.root.lookup("#vue2_ListeConversion");
        String items = liste.getSelectionModel().getSelectedItem();
        return items;
    }
    /**
     * Affiche le texte dans l'input
     * @param select Le texte à afficher
     */
    public void selectionner(String select){
        TextField tSaisieConversion = (TextField) this.root.lookup("#vue2_tfSaisieModifConversion");
        tSaisieConversion.setPromptText("Format (a:.-)");
        tSaisieConversion.setText(select);
    }
}
