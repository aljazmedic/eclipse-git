package Tek2015skup1nal4;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Tek2015skup1nal4 {
	public static void main(String[] args) {
		String input = "";
		String usable = "";
		String finish = "";
		try {
			File f = new File("src/Tek2015skup1nal4/input.txt");
			Scanner scn = new Scanner(f);
			while (scn.hasNextLine())
				input += scn.nextLine();
			System.out.println(input);
			scn.close();
		} catch (Exception e) {
		}

		char[] miza = new char[(int) Math.pow(2, 5)];
		Initialize(miza);

		for (char i : input.toCharArray()) {
			if ((i == '1' || i == '0')) {
				usable += i;
			}
		}
		for (int i = 0; i < usable.length(); i += 5) {
			finish += miza[Integer.parseInt(usable.substring(i, i + 5), 2)];
		}
		System.out.println(finish);
	}

	public static void Initialize(char[] miza) {
		Arrays.fill(miza, '*');
		int sistem = 2;
		miza[Integer.parseInt("11000", sistem)] = '0' + 1;
		miza[Integer.parseInt("10100", sistem)] = '0' + 2;
		miza[Integer.parseInt("10010", sistem)] = '0' + 3;
		miza[Integer.parseInt("01010", sistem)] = '0' + 4;
		miza[Integer.parseInt("00110", sistem)] = '0' + 5;
		miza[Integer.parseInt("10001", sistem)] = '0' + 6;
		miza[Integer.parseInt("01001", sistem)] = '0' + 7;
		miza[Integer.parseInt("00101", sistem)] = '0' + 8;
		miza[Integer.parseInt("00011", sistem)] = '0' + 9;
		miza[Integer.parseInt("01100", sistem)] = '0' + 0;
	}
}
