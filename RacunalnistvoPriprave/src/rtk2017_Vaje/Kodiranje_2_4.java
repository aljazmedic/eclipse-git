package rtk2017_Vaje;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Kodiranje_2_4 {
	public static void main(String[] args) throws IOException {
		String zadnje = "Janez", input = "";
		Scanner scn = new Scanner(new File("src/rtk2017_Vaje/KodiranjeData.txt"));
		while (scn.hasNextLine()) {
			input = scn.nextLine();
		}
		scn.close();
		Decode(input, getKey(input, zadnje));
	}

	private static String getKey(String input, String zadnje) {
		String kljuc = "", kljucP = "";
		if (input.length() < zadnje.length())
			return null;
		for (int i = 0; i < zadnje.length(); i++) {
			kljuc += (char) ('a'
					+ (((input.substring(input.length() - zadnje.length()).charAt(i) - zadnje.charAt(i) - 1) + 26)
							% 26));
		}
		if (input.length() % zadnje.length() != 0) {
			for (int i = 1; i <= zadnje.length(); i++) {
				kljucP += kljuc.charAt((i + input.length() % zadnje.length()) % zadnje.length());
			}
		} else {
			kljucP = kljuc;
		}
		return kljucP;
	}

	public static void Decode(String input, String kljucP) {
		String ret = "";
		for (int i = 0; i < input.length(); i++) {
			if ((input.charAt(i) < 'a' || input.charAt(i) > 'z') && (input.charAt(i) < 'A' || input.charAt(i) > 'Z')) {
				ret += input.charAt(i);
				continue;
			}
			System.out.println(input.charAt(i) + " " + kljucP.charAt(i % kljucP.length()));
			ret += (char) ('a' + (((input.charAt(i) - 'a' + kljucP.charAt(i % kljucP.length()) - 'a') + 26) % 26));
		}
		System.out.println(ret);
	}

}
