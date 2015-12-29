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
}
