
package Dnevnik;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author dijak
 */
public class dnevnik {
	public static void main(String[] args) {
		Scanner scn;
		try {
			File f = new File("/Dnevnik/input.txt");
			scn = new Scanner(f);
		} catch (Exception e) {
			scn = null;
		}

		String current = scn.nextLine();
		String temp = "t";
		int n = 0;
		System.out.println(current);

		while (temp.length() > 0) {
			try {
				temp = scn.nextLine();
			} catch (Exception e) {
				temp = "";
			}

			if (temp.equals(current)) {
				n++;
			} else if (n == 1 && !temp.equals(current)) {
				n = 0;
				System.out.println(current + "\n\r" + temp);
			} else if (n == 0) {
				System.out.println(temp);
				n = 0;
			} else {
				System.out.println("Ponovljeno " + n + "-krat \n\r" + temp);
				n = 0;
			}
			current = temp;
		}
	}

}
