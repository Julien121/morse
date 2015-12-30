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
			this.codeLettre = codeLettre;
		}
		else
		{
			throw new IllegalArgumentException("Le code ne peut pas être vide");
		}
	}
	
}
