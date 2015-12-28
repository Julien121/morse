package controleur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import vue.VueMorse;

public class CtrlVueMorse{
	private VueMorse vue;
	
	@FXML
	private TextArea tAConvert;
	
	public void setModele() {
		
	}
	public void setVue(VueMorse vueMorse) {
		this.vue = vue;
	}
	public void handleActionConvert(ActionEvent event) {
		System.out.println(event.getSource().toString());
		System.out.println(this.tAConvert.getText());
	}

}
