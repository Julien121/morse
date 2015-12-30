package modele.metier;

import java.util.ArrayList;
import modele.metier.Code;
import java.util.regex.*;

public class Convertisseur {

    private ArrayList<Code> lesCodes;

    public Convertisseur() {
        lesCodes = new ArrayList<Code>();
    }

    public ArrayList<Code> getLesCodes() {
        return lesCodes;
    }

    public String verifer(String str) {
        if (str.matches("[\\w\\s]+")) {
            System.out.println(str);
            return encode(str);
        } else {
            System.out.println(str);
            return decode(str);
        }
    }

    public String decode(String code) {
        String newStr = "";
        String[] tbCode = code.split("\\s");
        int j;
        boolean trouve = false;
        for (int i = 0; i < tbCode.length; i++) {
            j = 0;
            if (!tbCode[i].isEmpty() || !tbCode[i + 1].isEmpty()) {
                while (j < lesCodes.size() && trouve == false) {
                    if (tbCode[i].equals(lesCodes.get(j).getCodeLettre())) {
                        newStr += lesCodes.get(j).getLettre();
                        trouve = true;
                    }
                    j++;
                }
                trouve = false;
            } else {
                newStr += " ";
            }
            System.out.println("|" + tbCode[i] + "|");
        }
        return newStr;
    }

    public String encode(String str) {
        String newStr = "";
        int j;
        boolean trouve = false;
        for (int i = 0; i < str.length(); i++) {
            j = 0;
            if (!Character.toString(str.charAt(i)).equals(" ")) {
                while (j < lesCodes.size() && trouve == false) {
                    if (str.charAt(i) == lesCodes.get(j).getLettre()) {
                        newStr += lesCodes.get(j).getCodeLettre() + " ";
                        trouve = true;
                    }
                    j++;
                }
                trouve = false;
            } else {
                newStr += "  ";
            }
        }
        return newStr;
    }

    public void ajouter(Code c) {
        int i = 0;
        boolean trouve = false;
        while (i < lesCodes.size() && trouve == false) {
            if (lesCodes.get(i).getCodeLettre() == c.getCodeLettre() || lesCodes.get(i).getLettre() == c.getLettre()) {
                trouve = true;
            }
            i++;
        }
        if (trouve) {
            if (lesCodes.get(i - 1).getCodeLettre() == c.getCodeLettre()) {
                lesCodes.get(i - 1).setLettre(c.getLettre());
            } else {
                lesCodes.get(i - 1).setCodeLettre(c.getCodeLettre());
            }
        } else {
            lesCodes.add(c);
        }
    }

    public void supprimer(Code c) {
        if (lesCodes.contains(c)) {
            lesCodes.remove(c);
        } else {
            throw new IllegalArgumentException("Impossible de supprimer");
        }
    }
}
