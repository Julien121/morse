package controleur;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modele.metier.Code;
import modele.metier.Convertisseur;
import perso.utils.MonJavaFX;
import vue.VueCode;

public class CtrlVueCode {

    private VueCode vue;
    private Convertisseur convertisseur;

     @FXML
    private Label vue2_labAction;
     
    public void setModele(Convertisseur convertisseur) {
        this.convertisseur = convertisseur;
        this.vue.afficherAction(false);
        this.vue.afficherListeConversion(this.convertisseur.getLesCodes());
    }

    public void setVue(VueCode vueCode) {
        this.vue = vueCode;
    }

    public void handleActionFermerFenetre(ActionEvent event) {
        this.vue.close();
    }

    public void handleActionAjouterCode(ActionEvent event) {
        this.vue.afficherAction(true);
        this.vue2_labAction.setText("Ajouter conversion");
    }

    public void handleActionModifierCode(ActionEvent event) {
        this.vue.afficherAction(true);
        this.vue2_labAction.setText("Modifier conversion");
    }

    public void handleActionSupprimerCode(ActionEvent event) {
        try {
            String select = this.vue.selectionner();
            if (select != null) {
                this.convertisseur.supprimer(new Code(select.split(":")[0].trim().charAt(0), select.split(":")[1].trim()));
                this.vue.afficherListeConversion(this.convertisseur.getLesCodes());
            } else {
                throw new IllegalArgumentException("Veuillez sélectionner un code avant de supprimer !");
            }
        } catch (IllegalArgumentException iae) {
            MonJavaFX.erreur("Erreur", iae.getMessage());
        }
    }

    public void handleActionValider(ActionEvent event) {
        try {
            String select = this.vue.selectionner();
            String nouvelleSaisie = this.vue.saisieNouvelleConversion();
            if (select != null) {
                nouvelleSaisie = select;
                System.out.println("Selectionner:" + select);
            }
            if (!nouvelleSaisie.isEmpty()) {
                this.convertisseur.ajouter(new Code(nouvelleSaisie.split(":")[0].trim().charAt(0), nouvelleSaisie.split(":")[1].trim()));
                this.vue.afficherListeConversion(this.convertisseur.getLesCodes());
                this.vue.afficherAction(false);
            } else {
                this.vue.afficherAction(true);
                throw new IllegalArgumentException("Impossible d'effectuer cette action");
            }
        } catch (IllegalArgumentException iae) {
            MonJavaFX.erreur("Erreur", iae.getMessage());
        }
    }

}
