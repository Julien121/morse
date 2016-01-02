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
    
    /**
     * Met à jour la vueMorse
     * @param vueCode Le nouvelle vueMorse
     */
    public void setVue(VueMorse vueMorse) {
        this.vue = vueMorse;
    }
    
    /**
     * Trait l'input quand l'on clique sur le bouton convertir
     * @param vueCode Une instance de ActionEvent
     * @throws IllegalArgumentException Si la saisie est vide
     */
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
    /**
     * Affiche la fenêtre des codes lorsque l'on clique sur le bouton convertir
     * @param vueCode Une instance de ActionEvent
     */
    public void handleActionAffVueCode(ActionEvent event) {
        VueCode c = this.vue.creeVueSecondaire();
        c.getControleur().setModele(this.convertisseur);
        c.showAndWait();
    }

}
