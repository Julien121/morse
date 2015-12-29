package modele.metier;

import java.util.ArrayList;
import modele.metier.Code;

public class Convertisseur {
	private ArrayList<Code> lesCodes;
	
	public Convertisseur()
	{
		lesCodes = new ArrayList<Code>();
	}

	public void ajoutCode(Code c) {
		lesCodes.add(c);
	}
}
