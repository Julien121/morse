package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import vue.VueMorse;
import modele.metier.Convertisseur;
import perso.utils.MonJavaFX;

public class CtrlVueMorse {

    private VueMorse vue;
    private Convertisseur convertisseur;

    //@FXML
    //private BorderPane bPAffichageConversion;

    @FXML
    private TextArea tATexteSaisie;

    //@FXML
    //private TextArea tATexteConverti;

    public void setModele(Convertisseur convertisseur) {
        this.convertisseur = convertisseur;
    }

    public void setVue(VueMorse vueMorse) {
        this.vue = vue;
    }

    public void handleActionConvert(ActionEvent event) {
        try {
            if (tATexteSaisie.getText().isEmpty()) {
                throw new IllegalArgumentException("Conversion impossible. Vous n'avez rien saisie.");
            } else {
                //bPAffichageConversion.setVisible(true);
                String textConvertie = convertisseur.verifer(tATexteSaisie.getText().toLowerCase());
                tATexteSaisie.setText(textConvertie);
            }
        }catch (IllegalArgumentException iae){
            MonJavaFX.erreur("Erreur", iae.getMessage());
        }
    }

}
