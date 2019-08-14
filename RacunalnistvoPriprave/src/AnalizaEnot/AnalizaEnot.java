package AnalizaEnot;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class AnalizaEnot {

	public static ArrayList<Kolicina> listKolicin = new ArrayList<Kolicina>();

	public static void main(String[] args) {
		try {
			File f = new File("src/AnalizaEnot/data.txt");
			Scanner scn = new Scanner(f);
			int times2go = -1;
			while (scn.hasNextLine()) {
				if (times2go == -1) {
					times2go = Integer.parseInt(scn.nextLine());
					continue;
				}
				if (!(times2go == 0)) {
					String temp = scn.nextLine();
					String[] temp1 = null;
					String[] temp2 = null;
					for (int i = 0; i < temp.split(":")[1].split("/").length; i++) {
						String currEnote = temp.split(":")[1].split("/")[i];
						if (i % 2 == 1)
							temp1 = currEnote.substring(1, currEnote.length() - 1).split(" ");
						else
							temp2 = currEnote.substring(1, currEnote.length() - 1).split(" ");
					}
					listKolicin.add(new Kolicina(temp.charAt(0), temp1, temp2));
					times2go--;
				} else {
					String temp = scn.nextLine();
					ArrayList<String> right = new ArrayList<String>();
					ArrayList<String> left = new ArrayList<String>();
					for (String s : temp.split(" = ")[0].split(" / ")) {
						// String[][] tmp1 = Contains(name_);
					}
					break;
				}
			}
			scn.close();
		} catch (Exception e) {
		}
	}

	public static Kolicina findKol(char c) {
		for (Kolicina k : listKolicin) {
			if (k.name == c)
				return k;
		}
		return null;
	}

	public static String[][] Contains(char name_) {
		for (Kolicina k : listKolicin)
			if (name_ == k.name) {
				return new String[][] { k.values1, k.values2 };
			}
		return null;
	}

	public static class Kolicina {
		char name;
		String[] values1; // [0][k] so stevila v stevcu, [1][0] so stevila v imenovalcu
		String[] values2;

		public Kolicina(char name_, String[] values_1, String[] values_2) {
			this.name = name_;
			values1 = values_1;
			values2 = values_2;
		}

		public void change() { // obrne ulomek
			String[] temp = this.values1;
			this.values1 = this.values2;
			this.values2 = temp;
		}
	}
}
