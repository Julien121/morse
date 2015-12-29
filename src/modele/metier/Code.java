package modele.metier;

public class Code {
	private String lettre;
	private String codeLettre;
	
	public Code(String lettre,String codeLettre)
	{
		this.lettre = lettre;
		this.codeLettre = codeLettre;
	}
	
	public String getLettre() {
            return lettre;
	}

	public String getCodeLettre() {
		return codeLettre;
	}
}
