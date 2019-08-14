package rtk2016_Vaje;

public class NalogeD_3 {

	public static void main(String[] args) {
		Osvezi(1, 59);
	}

	public static void Spremeni(int stevka, int segment) {
		System.out.println("spremembe: " + stevka + ":" + segment);
	}

	public static void Osvezi(int h, int m) {
		String[] spremembe = new String[] { "1100101", "1001111", "0000110", "1100001", "1010001", "0000100", "0111101",
				"0101101", "0000100", "0001100", "", "0101100" }; // 01 12 23 34 45 56 67 78 89 90 50 30
		/*
		 * 101, 79, 6, 97, 81, 4, 61, 45, 4, 12, 44
		 */
		int ph = h;
		int pm = m--;
		int stevkaSprememba = 4;
		if (pm < 0) {
			pm = 59;
			ph--;
			stevkaSprememba = 2;
			if (ph < 0) {
				ph = 23;

			}
		}
		if (pm % 10 == 9) {
			stevkaSprememba = 3;
			if (pm / 10 >= 5.0f) {
				stevkaSprememba = 2;
				if (ph % 10 == 9 || ph == 23) {
					stevkaSprememba = 1;
				}
			}
		}
		String zapis = "" + String.format("%02d", ph) + String.format("%02d", pm);

		for (int i = 3; i >= stevkaSprememba - 1; i--) {
			String TrenSpremembe = spremembe[zapis.charAt(i) - '0'];
			for (int j = 0; j < TrenSpremembe.length(); j++) {
				if (!zapis.substring(0, 2).equals("23") || !zapis.substring(3, 4).equals("59")) {
					if (TrenSpremembe.charAt(j) == '1') {
						Spremeni(i + 1, j + 1);
					}
				}
			}
		}

	}
}
