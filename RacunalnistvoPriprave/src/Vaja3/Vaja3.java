package Vaja3;

import java.util.ArrayList;
import java.util.Arrays;

public class Vaja3 {
	static final int D = 1;
	static int[][] osebki = new int[][] { { 1907, 1980 }, { 1909, 1960 }, { 1920, 1925 }, { 1927, 1999 },
			{ 1930, 1935 }, { 1947, 1980 }, { 1952, 2000 } };
	static int[] nasle;

	public static void main(String[] args) {

		Arrays.sort(osebki, (a, b) -> Integer.compare(a[0], b[0]));

		nasle = new int[osebki.length]; // nalogo bi se dalo izvesti tudi brez te array, vendar bi se zaèelo poznati na
										// spominu, ker veliko ponovitev tako lahko ne izvajamo
		int MaxVeriga = 0;
		for (int i = 0; i < osebki.length; i++)
			MaxVeriga = Math.max(MaxVeriga, najdaljsa_veriga(i));
		System.out.println(MaxVeriga);
	}

	public static int najdaljsa_veriga(int a) {
		if (nasle[a] == 0) {
			int c = 0;
			for (int ob : Nasledniki(a)) {
				c = Math.max(c, najdaljsa_veriga(ob));
			}
			nasle[a] = c + 1;
		}
		return nasle[a];
	}

	public static int[] Nasledniki(int a) {
		int temp = osebki[a][0] + D;
		ArrayList<Integer> c = new ArrayList<>();
		for (int i = a; i < osebki.length && osebki[i][0] <= osebki[a][1]; i++) {
			if (osebki[i][0] >= temp)
				c.add(i);
		}
		int[] b = new int[c.size()];
		for (int i = 0; i < b.length; i++)
			b[i] = c.get(i);
		return b;
	}
}
