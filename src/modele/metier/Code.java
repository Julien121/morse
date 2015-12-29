package modele.metier;

public class Code {
	private String code;
	private String lettre;
	
	public Code(String code,String lettre)
	{
		this.code = code;
		this.lettre = lettre;
	}
	
	public String conversion(String uneLettre)
	{
		String lettreTraduit;
		if(uneLettre == this.code)
		{
			lettreTraduit = this.lettre;
		}
		else
		{
			lettreTraduit = this.code;
		}
		return lettreTraduit;
	}
	@Override
	public boolean equals(Object o) {
		String lettre = (String)o;
		System.out.println(this.code.equalsIgnoreCase(lettre) || this.lettre.equalsIgnoreCase(lettre));
		return false;
	}
}
