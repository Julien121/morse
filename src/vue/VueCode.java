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
            MonJavaFX.erreur("Problème FXML", "Erreur lors du chargement de la vue \n" + ex.getMessage());
        }

    }

    public CtrlVueCode getControleur() {
        return this.controleur;
    }

    public ListView<String> getListView() {
        return (ListView<String>) this.root.lookup("#vue2_ListeConversion");
    }

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

    //public String saisieNouvelleConversion() {

        //String conversion = null;
        //TextInputDialog inDialog = new TextInputDialog();
        //inDialog.setTitle("Saisie d'une nouvelle conversion");
        //inDialog.setHeaderText("Nouvelle conversion");
        //inDialog.setContentText("La conversion");
        //Optional<String> textIn = inDialog.showAndWait();
        //if (textIn.isPresent()) {
        //    conversion = textIn.get();
        //}
        //return conversion;
    //}
    
    public void afficherAction(boolean visible){
        TextField tSaisieConversion = (TextField) this.root.lookup("#vue2_tfSaisieModifConversion");
        tSaisieConversion.setVisible(visible);
        Button valider = (Button) this.root.lookup("#vue2_btnValider");
        valider.setVisible(visible);
    }
    
    public String saisieNouvelleConversion(){
        
        String conversion = null;
        TextField tSaisieConversion = (TextField) this.root.lookup("#vue2_tfSaisieModifConversion");
        conversion = tSaisieConversion.getText();
        return conversion; 
    }
    
    public String selectionner(){
        ListView<String> liste = (ListView<String>) this.root.lookup("#vue2_ListeConversion");
        String items = liste.getSelectionModel().getSelectedItem();
        return items;
    }
}
