import java.util.ArrayList;

public class Cracker {

	public static void main(String[] args) {
		String getPswordString = "harmonika"; 
		try {
			for(String str : getPasswords(getPswordString)) System.out.println(str);
		}catch (Exception e) {}
	}
	
	public static String[] getPasswords(String str) {  //Zamenja
		new Sprememba('a', new char[] {'@', '4', 'â', 'Â'});
		new Sprememba('b', new char[] {'8', '6'});
		new Sprememba('e', new char[] {'3'});
		new Sprememba('t', new char[] {'7'});
		new Sprememba('i', new char[] {'1'});
		new Sprememba('o', new char[] {'0'});
		new Sprememba('s', new char[] {'5'});
		
		ArrayList<String> temp = crack(str, "");
		return temp.toArray(new String[temp.size()]);
	}
	
	public static ArrayList<String> crack(String original, String buildedString) {
		if(buildedString.length()==original.length()) {
			ArrayList<String> ret = new ArrayList<String>();
			ret.add(buildedString);
			return ret;
		}
		ArrayList<String> ret = new ArrayList<String>();
		for(char ch : Sprememba.changeFrom(original.charAt(buildedString.length()))) {
			ret.addAll(crack(original, buildedString+ch));
		}
		return ret;
	}
	
	static class Sprememba {
		private char character; 
		private char[] changes;
		public static ArrayList<Sprememba> items = new ArrayList<Sprememba>();
		
		private char[] getSubstitutes() {
			return changes;
		}
		
		private char getCharacter() {
			return character;
		}
		
		public Sprememba(char c, char[] chg) {
			this.character = c;
			this.changes = new char[chg.length+1];
			this.changes[0] = (char) (c+'A'-'a');
			int i = 0;
			for(char ch : chg) this.changes[++i] = ch;
			items.add(this);
		}
		public static char[] changeFrom(char c) {
			char[] chgs = Sprememba.contains(c);
			char[] ret  = new char[chgs.length+1];
			ret[0] = c;
			int i = 0;
			for(char ch : chgs) ret[++i] = ch;
			return ret;
		}
		
		private static char[] contains(char c) { // že imamo ta znak?
			for(int i = 0; i < items.size(); i++) {
				if(items.get(i).getCharacter() == c) {
					return items.get(i).getSubstitutes(); 
				}
			}
			return new char[] {(char) (c+'A'-'a')}; //drugaèe samo vrnemo veliko èrko za test
		}
	}
}
