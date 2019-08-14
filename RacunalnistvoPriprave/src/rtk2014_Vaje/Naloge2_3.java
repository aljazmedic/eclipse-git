package rtk2014_Vaje;

public class Naloge2_3 {

	public static void main(String[] args) {
		Desifriraj("nexttuesdayfourfiftypminthemainsquare", "r**aa**k***s****e***q*e**o********wl*",
				"thistuesdayfourfiftypmanddefinetlynotnexttuesdayfourfiftypminthemainsquare");
	}

	public static void Desifriraj(String p1, String c1, String p2) {
		char[] sifriranje = new char[26];
		for (int i = 0; i < p1.length(); i++) {
			char c = c1.charAt(i);
			char p = p1.charAt(i);

			if (c != '*') {
				if (sifriranje[p - 'a'] == ((char) 0) || sifriranje[p - 'a'] == c) {
					sifriranje[p - 'a'] = c;
				} else {
					System.out.println("Neveljavna šifra");
				}
			}
		}

		String ret = "";
		for (int i = 0; i < p2.length(); i++) {
			ret += sifriranje[p2.charAt(i) - 'a'] == ((char) 0) ? '*' : sifriranje[p2.charAt(i) - 'a'];
		}
		System.out.println(ret);
	}
}
