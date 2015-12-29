package modele.metier;

public class Code {
	private char lettre;
	private String codeLettre;
	
	public Code(char lettre,String codeLettre)
	{
		this.lettre = lettre;
		this.codeLettre = codeLettre;
	}
	
	public char getLettre() {
            return lettre;
	}

	public String getCodeLettre() {
		return codeLettre;
	}
}
