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
        this.vue.selectionner("");
    }

    public void handleActionModifierCode(ActionEvent event) {
        this.vue.afficherAction(true);
        this.vue2_labAction.setText("Modifier conversion");
        String select = this.vue.listeSelection();
        if (select != null) {
            this.vue.selectionner(select);
        }
    }

    public void handleActionSupprimerCode(ActionEvent event) {
        try {
            String select = this.vue.listeSelection();
            if (select != null) {
                this.convertisseur.supprimer(new Code(select.split(":")[0].trim().charAt(0), select.split(":")[1].trim()));
                this.vue.afficherListeConversion(this.convertisseur.getLesCodes());
                MonJavaFX.info("Succès", "Action réalisée.");
            } else {
                throw new IllegalArgumentException("Veuillez sélectionner un code avant de supprimer !");
            }
        } catch (IllegalArgumentException iae) {
            MonJavaFX.erreur("Erreur", iae.getMessage());
        }
    }

    public void handleActionValider(ActionEvent event) {
        try {
            String nouvelleSaisie = this.vue.saisieNouvelleConversion();
            if (!nouvelleSaisie.isEmpty()) {
                this.convertisseur.ajouter(new Code(nouvelleSaisie.split(":")[0].trim().charAt(0), nouvelleSaisie.split(":")[1].trim()));
                this.vue.afficherListeConversion(this.convertisseur.getLesCodes());
                this.vue.afficherAction(false);
                MonJavaFX.info("Succès", "Action réalisée.");
            } else {
                this.vue.afficherAction(true);
                throw new IllegalArgumentException("Impossible d'effectuer cette action");
            }
        } catch (IllegalArgumentException iae) {
            MonJavaFX.erreur("Erreur", iae.getMessage());
        }
    }

}
