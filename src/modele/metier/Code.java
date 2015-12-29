package modele.metier;

public class Code {
	private String Lettre;
	private String codeLettre;
	
	public Code(String Lettre,String codeLettre)
	{
		this.Lettre = Lettre;
		this.codeLettre = codeLettre;
	}
	
	public String getLettre() {
		return Lettre;
	}

	public String getCodeLettre() {
		return codeLettre;
	}

	public String conversion(String uneLettre)
	{
		String lettreTraduit;
		if(uneLettre == this.Lettre)
		{
			lettreTraduit = this.codeLettre;
		}
		else
		{
			lettreTraduit = this.Lettre;
		}
		return lettreTraduit;
	}
	@Override
	public boolean equals(Object o) {
		String lettre = (String)o;
		System.out.println(this.Lettre.equalsIgnoreCase(lettre) || this.codeLettre.equalsIgnoreCase(lettre));
		return false;
	}
}
