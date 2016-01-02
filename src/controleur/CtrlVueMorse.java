package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import vue.VueMorse;
import modele.metier.Convertisseur;
import perso.utils.MonJavaFX;
import vue.VueCode;

public class CtrlVueMorse {

    private VueMorse vue;
    private Convertisseur convertisseur;

    @FXML
    private TextArea tATexteSaisie;

    public void setModele(Convertisseur convertisseur) {
        this.convertisseur = convertisseur;
    }

    public void setVue(VueMorse vueMorse) {
        this.vue = vueMorse;
    }

    public void handleActionConvert(ActionEvent event) {
        try {
            if (tATexteSaisie.getText().isEmpty()) {
                throw new IllegalArgumentException("Conversion impossible. Vous n'avez rien saisie.");
            } else {
                String textConvertie = convertisseur.verifer(tATexteSaisie.getText().toLowerCase());
                tATexteSaisie.setText(textConvertie);
            }
        } catch (IllegalArgumentException iae) {
            MonJavaFX.erreur("Erreur", iae.getMessage());
        }
    }

    public void handleActionAffVueCode(ActionEvent event) {
        VueCode c = this.vue.creeVueSecondaire();
        c.getControleur().setModele(this.convertisseur);
        c.showAndWait();
    }

}
