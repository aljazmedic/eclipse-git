package rtk2016_Vaje;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solsko_1 {

	public static void main(String[] args) throws FileNotFoundException {
		String nabor = "22233344455566677778889999";
		Scanner scn = new Scanner(new FileReader("src/rtk2016_Vaje/data_Solsko_1.txt"));
		String input = "";
		int maxPritiskov = 0;
		int counter = 0;
		while (scn.hasNextLine()) {
			String temp = scn.nextLine();
			int stevilo = 0;
			char chr = ' ';
			for (int i = 0; i < temp.length(); i++) {
				if (chr == nabor.charAt(temp.charAt(i) - 'a')) {
					stevilo++;
					if (stevilo >= maxPritiskov)
						maxPritiskov = counter;
				} else {
					stevilo = 0;
				}
				chr = nabor.charAt(temp.charAt(i) - 'a');
			}
			input += temp + "\r\n";
			counter++;
		}
		scn.close();
		System.out.println(input.split("\r\n")[maxPritiskov]);
	}

}
