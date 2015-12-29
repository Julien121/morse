package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import vue.VueMorse;
import modele.metier.Convertisseur;

public class CtrlVueMorse{
	private VueMorse vue;
	private Convertisseur convertisseur;
	
	@FXML
	private TextArea tATexte;
	
	@FXML
	private TextArea tATexteConverti;
	
	public void setModele(Convertisseur convertisseur) {
		this.convertisseur = convertisseur;
	}
	public void setVue(VueMorse vueMorse) {
		this.vue = vue;
	}
	public void handleActionConvert(ActionEvent event) {
		tATexteConverti.setVisible(true);
		String textConvertie = convertisseur.verifer(tATexte.getText());
		tATexteConverti.setText(textConvertie);
	}

}
