package modele.metier;

public class Code {
	private char lettre;
	private String codeLettre;
	
	public Code(char lettre,String codeLettre)
	{
		this.setLettre(lettre);
		this.setCodeLettre(codeLettre);
	}
	
	public char getLettre() {
            return lettre;
	}

	public String getCodeLettre() {
		return codeLettre;
	}

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

	public void setCodeLettre(String codeLettre) {
		if(!codeLettre.isEmpty())
		{
			int i = 0;
			boolean valide = true;
			while(i < codeLettre.length() && valide == true){
				if(codeLettre.charAt(i) != ' ' || codeLettre.charAt(i) != '-' || codeLettre.charAt(i) != '.'){
					valide = false;
				}
			}
			if(valide)
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
			throw new IllegalArgumentException("Le code ne peut pas être vide");
		}
	}
	
}
