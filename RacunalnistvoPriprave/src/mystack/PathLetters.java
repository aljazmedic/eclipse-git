package mystack;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//65-90
public class PathLetters {
	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {
		File f = new File(
				"D:\\Aljaz\\Eclipse\\Workspace\\RacunalnistvoPriprave\\src\\PotSCrkami\\podatkiPathLetter.txt");
		Scanner scn;
		try {
			scn = new Scanner(f);
		} catch (FileNotFoundException e) {
			return;
		}
		char startPlace, endPlace;
		String temp;
		temp = scn.nextLine();
		if (temp.length() != 3)
			throw new Error("Napacen vnos");
		startPlace = temp.split(" ")[0].charAt(0);
		endPlace = temp.split(" ")[1].charAt(0);

		char[] table = new char[26];

		while (scn.hasNext()) {
			getInfo(scn.nextLine(), table);
		}
		scn.close();
		int num = startPlace;
		System.out.print(startPlace);
		while (num - 'A' != endPlace - 'A') {
			System.out.print(table[num - 'A']);
			num = table[num - 'A'];
		}
	}

	public static void getInfo(String input, char[] table) {
		char loc = ' ';
		for (String a : input.split(" ")) {
			if (a.length() != 1)
				continue;
			if (a.charAt(0) <= 'Z' && a.charAt(0) >= 'A') {
				if (loc == ' ')
					loc = a.charAt(0);
				else {
					table[loc - 'A'] = a.charAt(0);
					return;
				}
			}
		}
	}
}