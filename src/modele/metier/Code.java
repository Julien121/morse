package modele.metier;

public class Code {
	private char lettre;
	private String codeLettre;
	
	public Code(char lettre,String codeLettre)
	{
		this.setLettre(this.lettre);
		this.codeLettre = codeLettre;
	}
	
	public char getLettre() {
            return lettre;
	}
        
        public void setLettre(char uneLettre) {
           
            if(Character.isAlphabetic(uneLettre)){
                this.lettre = uneLettre;
            }else{
                System.out.print("Erreur");
            }
            
        }

	public String getCodeLettre() {
		return codeLettre;
	}

	public String conversion(String uneLettre)
	{
		String lettreTraduit;
		if(uneLettre == this.lettre)
		{
			lettreTraduit = this.codeLettre;
		}
		else
		{
			lettreTraduit = this.lettre;
		}
		return lettreTraduit;
	}
	@Override
	public boolean equals(Object o) {
		String lettre = (String)o;
		System.out.println(this.lettre.equalsIgnoreCase(lettre) || this.codeLettre.equalsIgnoreCase(lettre));
		return false;
	}

    /**
     * @param lettre the lettre to set
     */
}
