package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import vue.VueMorse;
import modele.metier.Code;
import modele.metier.Convertisseur;
import perso.utils.MonJavaFX;
import vue.VueCode;

public class CtrlVueCode {

    private VueCode vue;
    private Convertisseur convertisseur;

    public void setModele(Convertisseur convertisseur) {
        this.convertisseur = convertisseur;
        this.vue.afficherListeConversion(this.convertisseur.getLesCodes());
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
    	try
    	{
    		String codeselected = this.vue.getListView().getSelectionModel().getSelectedItem();
	        if (codeselected != null)
	        {
		        this.convertisseur.supprimer(new Code(codeselected.split(":")[0].trim().charAt(0),codeselected.split(":")[1].trim()));
		        this.vue.afficherListeConversion(this.convertisseur.getLesCodes());
	        }
	        else
	        {
	        	throw new IllegalArgumentException("Veuillez sélectionner un code avant de supprimer !");
	        }
    	}
    	catch(IllegalArgumentException iae)
    	{
            MonJavaFX.erreur("Erreur", iae.getMessage());
    	}
    }

}
