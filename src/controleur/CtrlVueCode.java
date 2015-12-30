package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import vue.VueMorse;
import modele.metier.Convertisseur;
import perso.utils.MonJavaFX;
import vue.VueCode;

public class CtrlVueCode {

    private VueCode vue;
    private Convertisseur convertisseur;

    public void setModele(Convertisseur convertisseur) {
        this.convertisseur = convertisseur;
    }

    public void setVue(VueCode vueCode) {
        this.vue = vueCode;
    }
    
    public void handleActionFermerFenetre(ActionEvent event) {
        this.vue.close();
    }
    
    public void handleActionAjouterCode(ActionEvent event) {
        
    }
    
    public void handleActionModifierCode(ActionEvent event) {
        
    }
    
    public void handleActionSupprimerCode(ActionEvent event) {
        
    }

}