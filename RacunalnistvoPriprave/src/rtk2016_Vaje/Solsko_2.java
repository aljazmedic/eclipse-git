package rtk2016_Vaje;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solsko_2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scn = new Scanner(new FileReader("src/rtk2016_Vaje/data_Solsko_2.txt"));
		int tolerance = 0;
		boolean[] ucenci = null;
		while (scn.hasNextLine()) {
			String temp = scn.nextLine();
			if (tolerance == 0) {
				ucenci = new boolean[Integer.parseInt(temp.split(" ")[0])];
				tolerance = Integer.parseInt(temp.split(" ")[1]);
			} else {
				String[] temp2 = temp.split(" ");
				int counter = 0;
				for (int i = 1; i < temp2.length; i++) {
					int temp3 = Math.abs(Integer.parseInt(temp2[i - 1]) - Integer.parseInt(temp2[i]));
					if (temp3 <= tolerance) {
						ucenci[i] = true;
						ucenci[i - 1] = true;
					}
				}
				for (boolean c : ucenci)
					if (c)
						counter++;
				System.out.println(counter);
			}
		}
		scn.close();
	}
}
