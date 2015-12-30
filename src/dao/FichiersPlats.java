package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modele.metier.Code;
import modele.metier.Convertisseur;

public class FichiersPlats {

    private static final File f = new File("CodeMorse.txt");
 
    public static Convertisseur lecture() {
    	Convertisseur m = new Convertisseur();
        String[] newStr;
        if (f.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String str;
                char lettre;
                String codeLettre = "";
                while ((str = br.readLine()) != null) {
                    newStr = str.split("\\|");
                    lettre = newStr[0].trim().charAt(0);
                    codeLettre = newStr[1].trim();
                    Code c = new Code(lettre, codeLettre);
                    m.ajouter(c);
                }
                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } catch(IllegalArgumentException iae)
            {
            	iae.printStackTrace();
            }
            
        }
        return m;
    }

    public static void sauve(ArrayList<Code> listeCode) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            for (Code c : listeCode) {
                bw.write(c.getLettre() + " | " + c.getCodeLettre());
                bw.newLine();
            }
            bw.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
