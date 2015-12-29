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
        
        public String verifer(String str){
            if(str.matches("[\\w\\s]+")){
            	System.out.println(str);
                return encode(str);
            }else{
                return decode(str);
            }
        }
        
        public String decode(String str){
            String newStr = "";
            for(int i = 0; i < str.length(); i++){
                for(int j = 1; j <= lesCodes.size(); j++){
                    /*if(str.charAt(i) == lesCodes.get(j).getCodeLettre()){
                        newStr += lesCodes.get(j).getLettre();
                    }*/
                }
            }
            return newStr;
        }
        
        public String encode(String str){
            String newStr = "";
            for(int i = 0; i < str.length(); i++){
                for(int j = 1; j < lesCodes.size(); j++){
                    if(str.charAt(i) == lesCodes.get(j).getLettre()){
                        newStr += lesCodes.get(j).getCodeLettre();
                    }
                }
                newStr += " ";
            }
            return newStr;
        }
}
