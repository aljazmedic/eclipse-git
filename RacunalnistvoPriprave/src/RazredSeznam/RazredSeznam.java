package RazredSeznam;

import java.util.*;

public class RazredSeznam {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Vnašanje neštevila ali zapolnitev seznama sproži konèni prikaz.");
		System.out.print("Velikost tabele: ");
		Seznam mojaTabela = new Seznam(scn.nextInt());
		while (scn.hasNextLine()) {
			try {
				System.out.print("Vrednost vnosa: ");
				mojaTabela.vnesi(scn.nextInt());
				System.out.println(mojaTabela);
			} catch (Exception ex) {
				break;
			}
		}
		scn.close();
		System.out.println(mojaTabela.koncniPrikaz());
	}
}

class Seznam {
	int[] tabelca;
	int fullness; // Èe je seznam poln, ne moremo dodati nobenega elementa veè. To omogoèa tudi
					// vnašanje nièel

	public String toString() {
		String str = "";
		for (int i : tabelca)
			str += i + " ";
		str.trim();
		return str;
	}

	public String koncniPrikaz() { // koda za konèen prikaz
		return "\r\n" + this + (this.fullness == this.tabelca.length ? "\r\n(Vnešenih preveè elementov.)"
				: "\r\n(Vnešenih " + (this.tabelca.length - this.fullness) + " elementov premalo.)");
	}

	public Seznam(int len) {
		tabelca = new int[len];
		fullness = 0;
	}

	public void vnesi(int vnos) {

		if (this.fullness == this.tabelca.length) {
			System.out.println("Napaka; poln seznam.");
			throw new IndexOutOfBoundsException(); // exception zaradi try stavka v 10. vrstici
		}

		this.fullness++;

		for (int i = 0; i < tabelca.length; i++) {
			if (tabelca[i] > vnos) {
				int temp = tabelca[i];
				tabelca[i] = vnos;
				vnos = temp;
			} else if (this.fullness - 1 == i) { // Èe je veèja od vseh levih elementov, ga lahko postavi zadnjega v
													// vrsto.
				tabelca[i] = vnos;
				break;
			}
		}
	}
}