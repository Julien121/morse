package modele.metier;

import java.util.ArrayList;
import modele.metier.Code;
import java.util.regex.*;

public class Convertisseur {

    private ArrayList<Code> lesCodes;
    private static Pattern pattern;
    private static Matcher matcher;

    public Convertisseur() {
        lesCodes = new ArrayList<Code>();
    }

    public void ajoutCode(Code c) {
        lesCodes.add(c);
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
            if (!tbCode[i].isEmpty() || !tbCode[i+1].isEmpty()) {
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
            System.out.println("|"+tbCode[i]+"|");
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
}
