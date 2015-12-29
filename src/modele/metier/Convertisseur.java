package modele.metier;

import java.util.ArrayList;
import modele.metier.Code;
import java.util.regex.*;

public class Convertisseur {
	private ArrayList<Code> lesCodes;
        private static Pattern pattern;
        private static Matcher matcher;
	
	public Convertisseur()
	{
		lesCodes = new ArrayList<Code>();
	}

	public void ajoutCode(Code c) {
		lesCodes.add(c);
	}
        
        public void verifer(String str){
            pattern = Pattern.compile("/w");
            matcher = pattern.matcher(str);
            if(matcher.find()){
                encode(str);
            }else{
                decode(str);
            }
        }
        
        public void decode(String str){
        }
        
        public void encode(String str){
            String newStr = "";
            for(int i = 0; i < str.length(); i++){
                for(int j = 1; j <= lesCodes.size(); j++){
                    if(str.charAt(i) == lesCodes.get(j).getLettre()){
                        newStr += lesCodes.get(j).getCodeLettre();
                    }
                }
            }
        }
}
