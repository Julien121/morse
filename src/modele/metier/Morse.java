package modele.metier;

import java.util.ArrayList;
import modele.metier.Code;

public class Morse {
	private ArrayList<Code> codeMorse;
	
	public Morse()
	{
		codeMorse = new ArrayList<Code>();
	}

	public void ajoutCode(Code c) {
		codeMorse.add(c);
	}
}
