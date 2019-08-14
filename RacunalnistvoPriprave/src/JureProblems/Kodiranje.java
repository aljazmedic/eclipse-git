package JureProblems;

import java.sql.Time;

public class Kodiranje {
	public static int length = 10;
	public static int steviloKoncev = 0;
	public static int steviloKod = 0;
	static int[] tab = new int[5];

	public static void main(String[] args) {
		rekFunction("");
		System.out.println("Vse zakodirane kode " + steviloKod);
		System.out.println("Vsi veljavne kode, ki so dolge " + length + ": " + steviloKoncev);
		System.out.println(tab[0] + " " + tab[1] + " " + tab[2] + " " + tab[3] + " " + tab[4]);
		System.out.println((double) (tab[0] + tab[1] * 2 + tab[2] * 3 + tab[3] * 4 + tab[4] * 4)
				/ (tab[0] + tab[1] + tab[2] + tab[3] + tab[4]));
	}

	public static void rekFunction(String built) {
		boolean ma2 = contains(built, '1');
		if (built.length() == 10 && ma2) {
			steviloKod++;
			System.out.println(built);
			test(built);
			return;
		} else if (built.length() < 10) {
			rekFunction(built + "1");
			rekFunction(built + "01");
			rekFunction(built + "001");
			rekFunction(built + "0001");
			rekFunction(built + "0000");
		} else {
			return;
		}
	}

	public static boolean contains(String s, char chr) {
		byte b = 0;
		for (char c : s.toCharArray()) {
			if (c == chr)
				b++;
		}
		if (b == (int) (0.2 * length))
			return true;
		return false;
	}

	public static void test(String s) {
		int state = 0;
		for (char c : s.toCharArray()) {
			if (c == '1' && state <= 3) {
				tab[state]++;
				steviloKoncev++;
				state = 0;
			} else if (c == '0' && state == 3) {
				tab[4]++;
				steviloKoncev++;
				state = 0;
			} else {
				state++;
			}
		}
	}
}
