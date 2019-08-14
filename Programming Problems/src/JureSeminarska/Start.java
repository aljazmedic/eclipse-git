package JureSeminarska;

import java.util.Scanner; //To ni moja rešitev ampak od Yannicka

public class Start {
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);

		int stTrakov = sc.nextInt() + 1;
		int dolzina = sc.nextInt();

		String[][] skladisce = new String[stTrakov][dolzina];

		sc.nextLine();

		String zaboji = sc.nextLine();
		String[] zab = new String[zaboji.split(",").length];
		String ukaz = "";

		for (int i = 0; i < zaboji.split(",").length; i++) {
			zab[i] = zaboji.split(",")[i];
		}

		Vozicek vozicek = new Vozicek(0, null);

		while (sc.hasNextLine()) {
			ukaz = sc.nextLine();

			if (!(ukaz.split(" ")[0].equals("PREMIK") || ukaz.equals("NALOZI") || ukaz.equals("ODLOZI")
					|| ukaz.equals("GOR") || ukaz.equals("DOL"))) {
				break;
			}

			if (ukaz.length() < 3) {
				break;
			}

			if (ukaz.equals("NALOZI") && vozicek.vsebina == null) {
				if (vozicek.pozicija == 0) {
					vozicek.vsebina = zab[0];
					zab = dol(zab);
				} else if (skladisce[vozicek.pozicija][0] != null) {
					vozicek.vsebina = skladisce[vozicek.pozicija][0];
					skladisce[vozicek.pozicija][0] = null;
				}
			} else if (ukaz.split(" ")[0].equals("PREMIK")) {
				vozicek.pozicija = Integer.parseInt(ukaz.split(" ")[1]);
			} else if (ukaz.equals("ODLOZI") && vozicek.pozicija != 0 && skladisce[vozicek.pozicija][0] == null) {
				skladisce[vozicek.pozicija][0] = vozicek.vsebina;
				vozicek.vsebina = null;
			} else if (ukaz.equals("GOR")) {
				skladisce[vozicek.pozicija] = gor(skladisce[vozicek.pozicija]);
			} else if (ukaz.equals("DOL")) {
				skladisce[vozicek.pozicija] = dol(skladisce[vozicek.pozicija]);
			}
		}

		izpis(skladisce);

		sc.close();

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.printf("start time = %d\n end time = %d\n totalTime = endTime - startTime = %d ms\n", startTime,
				endTime, totalTime);
	}

	public static void izpis(String[][] skladisce) {
		String izpis = "";
		String dodaj = "";
		String reverse = "";

		for (int i = 1; i < skladisce.length; i++) {
			System.out.print(i + ":");

			for (int j = skladisce[i].length - 1; j >= 0; j--) {
				if (skladisce[i][j] != null) {
					reverse = new StringBuffer(skladisce[i][j]).reverse().toString();
					izpis = izpis.concat(dodaj + reverse);
					dodaj = ",";
				} else {
					izpis = izpis.concat(dodaj);
				}
			}

			reverse = new StringBuffer(izpis).reverse().toString();

			System.out.println(reverse);
			izpis = "";
			dodaj = "";
		}
	}

	public static String[] gor(String[] trak) {

		String[] gor = new String[trak.length];

		for (int i = trak.length - 1; i > 0; i--) {
			gor[i] = trak[i - 1];
		}

		return gor;
	}

	public static String[] dol(String[] trak) {
		String[] dol = new String[trak.length];

		for (int i = 0; i < trak.length - 1; i++) {
			dol[i] = trak[i + 1];
		}

		return dol;
	}

}

class Vozicek {
	public int pozicija;
	public String vsebina;

	public Vozicek(int pozicija, String vsebina) {
		this.pozicija = pozicija;
		this.vsebina = vsebina;
	}
}
