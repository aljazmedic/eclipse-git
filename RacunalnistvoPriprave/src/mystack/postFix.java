package mystack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class postFix {
	public static void main(String[] args) {
		File f = new File("src\\postFix\\data.txt");
		String manualInput = "2 3 1 * + 9 -";
		Scanner scn;
		try {
			scn = new Scanner(f);
		} catch (FileNotFoundException e) {
			scn = new Scanner(manualInput);
		}
		String input = new String();
		while (scn.hasNextLine()) {
			input += scn.nextLine();
		}
		scn.close();
		Stack<String> sklad = new Stack<String>();
		for (String operation : input.split(" ")) {
			float two = 0, one = 0, res = 0;

			if (operation.length() == 1 && (operation.charAt(0) == '/' || operation.charAt(0) == '-' || // preveri èe je
					operation.charAt(0) == '*' || operation.charAt(0) == '+')) { // v poziciji za
				try { // èe sta pred njim dve številki nadaljuje, drugaèe le doda String v sklad //
						// raèunanje
					two = Float.parseFloat(sklad.pop());
					one = Float.parseFloat(sklad.pop());
					switch (operation.charAt(0)) {
					case '/':
						if (two != 0)
							res = one / two;
						else
							throw new Error("Deljenje z niè");
						break;
					case '-':
						res = one - two;
						break;
					case '*':
						res = one * two;
						break;
					case '+':
						res = one + two;
						break;
					}
					sklad.push(Float.toString(res));
				} catch (Exception e) {
				}
			} else {
				sklad.push(operation);
			}
		}

		System.out.println(Float.parseFloat(sklad.pop()));

	}
}
