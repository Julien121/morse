package modele.metier;

import java.util.ArrayList;
import modele.metier.Code;

public class Convertisseur {
	/**
	 * La liste des codes
	 */
    private ArrayList<Code> lesCodes;

    /**
     * Constructeur
     */
    public Convertisseur() {
        lesCodes = new ArrayList<Code>();
    }
    /**
     * Retourne la liste des codes
     * @return lesCodes la liste des codes
     */
    public ArrayList<Code> getLesCodes() {
		return lesCodes;
	}
    /**
     * V�rifie la chaine de caract�re et envoie � la bonne fonction la chaine
     * @param str La chaine � convertir
     * @return La chaine convertie
     */
    public String verifer(String str) {
        if (str.matches("[\\w\\s]+")) {//Si la chaine poss�de que lettre ou des chiffre et des espace alors on encode sinon on decode
            return encode(str);
        } else {
            return decode(str);
        }
    }
    /**
     * D�code la chaine de caract�re
     * @param code La chaine de caract�re � d�coder
     * @return La chaine de caract�re d�cod�
     * @throws IllegalArgumentException Si le texte n'a pas pu etre converti
     */
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
        if(newStr.isEmpty())
        {
        	newStr = code;
        	throw new IllegalArgumentException("Le texte n'a pas pu etre converti");
        }
        return newStr;
    }
    /**	
     * Encode la chaine de caract�re
     * @param str La chaine de caract�re � encoder
     * @return La chaine de caract�re encod�
     * @throws IllegalArgumentException Si le texte n'a pas pu etre converti
     */
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
        if(newStr.isEmpty())
        {
        	newStr = str;
        	throw new IllegalArgumentException("Le texte n'a pas pu etre converti");
        }
        return newStr;
    }
    /**
     * Ajoute ou modifie le code dans la liste des codes
     * @param c La devise � ajouter ou modifier
     */
    public void ajouter(Code c)
    {
    	int i = 0;
    	boolean trouve = false;
    	while(i < lesCodes.size() && trouve == false)
    	{
    		if(lesCodes.get(i).getCodeLettre() == c.getCodeLettre() || lesCodes.get(i).getLettre() == c.getLettre())
			{
				trouve = true;
			}
			i++;
    	}
    	if(trouve)
    	{
    		if(lesCodes.get(i-1).getCodeLettre() == c.getCodeLettre())
    		{
    			lesCodes.get(i-1).setLettre(c.getLettre());
    		}else{
    			lesCodes.get(i-1).setCodeLettre(c.getCodeLettre());
    		}
    	}
    	else
    	{
    		lesCodes.add(c);
    	}
    }
    /**
     * Supprime un code dans la liste des codes
     * @param c le code � supprimer
     * @throws IllegalArgumentException Si le code n'a pas pu �tre supprim�
     */
	public void supprimer(Code c)
    {
    	if(lesCodes.contains(c))
    	{
    		lesCodes.remove(c);
    	}
    	else
    	{
    		 throw new IllegalArgumentException("Impossible de supprimer");
    	}
    }
}
