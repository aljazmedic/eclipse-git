package OklepajskiIzrazi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class OklepajskiIzrazi_7 { // NO_UCD (unused code)
	public static void main(String[] args) {
		String str = "";
		File f = new File("src/OklepajskiIzrazi/data7.txt");
		try {
			Scanner scn = new Scanner(f);
			while (scn.hasNext()) {
				String temp = scn.nextLine();
				Dopolni(temp);
				str += temp + "\r\n";
			}
			scn.close();
		} catch (FileNotFoundException e) {
			System.out.println("Nc");
		}
		System.out.println("\r\n" + str);
	}

	public static void Dopolni(String s) {
		StringBuffer ss = new StringBuffer(s);
		Stack<Character> sklad = new Stack<Character>();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (!(s.charAt(i) == '*')) { // s.charAt(i) == '>' || s.charAt(i) == '}' || s.charAt(i) == ']' ||
											// s.charAt(i) == ')'
				sklad.push(s.charAt(i));
			} else {
				try {
					switch (sklad.pop()) {
					case '>':
						ss.setCharAt(i, '<');
						continue;
					case '}':
						ss.setCharAt(i, '{');
						continue;
					case ')':
						ss.setCharAt(i, '(');
						continue;
					case ']':
						ss.setCharAt(i, '[');
						continue;
					}
				} catch (Exception ex) {
					System.out.println("Ni rešitve");
					return;
				}
			}
		}
		System.out.println(ss);
		s = ss.toString();
	}

}
