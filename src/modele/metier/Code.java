package modele.metier;

public class Code {
	/**
	 * La lettre du code
	 */
	private char lettre;
	/**
	 * Le code correspondant � la lettre
	 */
	private String codeLettre;
	/**
	 * Constructeur
	 * @param lettre La lettre du code
	 * @param codeLettre Le code correspondant � la lettre
	 */
	public Code(char lettre,String codeLettre)
	{
		this.setLettre(lettre);
		this.setCodeLettre(codeLettre);
	}
	/**
	 * Retourne lettre
	 * @return lettre Valeur de lettre
	 */
	public char getLettre() {
            return lettre;
	}
   /**
    * Retourne codeLettre
    * @return codeLettre Valeur de codeLettre
    */
	public String getCodeLettre() {
		return codeLettre;
	}

   /**
    * Met � jour la lettre
    * @param lettre Le nouveau lettre
    */
	public void setLettre(char lettre) {
		if(!Character.toString(lettre).isEmpty())
		{
			this.lettre = lettre;
		}
		else
		{
			throw new IllegalArgumentException("La lettre ne peut pas être vide");
		}
	}
   /**
    * Met � jour le codeLettre
    * @param codeLettre  Le nouveau codeLettre
    */
	public void setCodeLettre(String codeLettre) {
		if(!codeLettre.isEmpty())// Si le param�tre et pas vide on fait le traitement sinon on cr�e une exception
		{
			int i = 0;
			boolean valide = true;
			while(i < codeLettre.length() && valide == true){// On parcourt chaque caract�re de la chaine de caract�res
				if(codeLettre.charAt(i) != ' ' && codeLettre.charAt(i) != '-' && codeLettre.charAt(i) != '.'){//s'il poss�de autre chose qu'un .,- ou un espace on arr�te la boucle
					System.out.println(codeLettre.charAt(i));
					valide = false;
				}
				i++;
			}
			if(valide)//si le code est bon on le place dans codeLettre sinon on cr�e une exception
			{
				this.codeLettre = codeLettre;
			}
			else
			{
				throw new IllegalArgumentException("Le code peut seulement contenir un espace un point ou un tiret");
			}
		}
		else
		{
			throw new IllegalArgumentException("Le code ne peut pas �tre vide");
		}
	}
	
	@Override
	public boolean equals(Object d) {
		
		if (d instanceof Code) {
			Code code = ((Code)d);
			if(Character.toString(code.lettre).equalsIgnoreCase(Character.toString(this.lettre)) && code.codeLettre.equalsIgnoreCase(this.codeLettre))
			{
				return true;
			}
		}
		
		return false;
	}
	
}
