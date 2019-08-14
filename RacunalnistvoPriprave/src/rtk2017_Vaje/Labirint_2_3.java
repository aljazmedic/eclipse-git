package rtk2017_Vaje;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Labirint_2_3 extends Rtk2017Vaje {
	public static String name = Labirint_2_3.class.getName().split("_Vaje.")[1].split("_")[0];

	public static boolean[][] labirint = null;

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(new File(getVajaData(name)));
		int vrstica = 0;
		while (scn.hasNextLine()) {
			String temp = scn.nextLine();
			if (labirint == null) {
				labirint = new boolean[Integer.parseInt(temp.split(" ")[0])][Integer.parseInt(temp.split(" ")[1])]; // nastavi
																													// 2d
																													// array
																													// labirint
			} else if (vrstica < labirint.length) {
				for (int i = 0; i < temp.split(" ").length; i++) {
					labirint[vrstica][i] = temp.split(" ")[i].equals("1") ? true : false; // bere labirint, ppretvori v
																							// boolean
				}
				vrstica++;
			} else {
				if (temp.charAt(0) == '@') { // dokler ne doèaka @ dodaja relativne kordinate
					Direction.finish();
					break;
				}
				new Direction(temp.charAt(0));
			}
		}
		scn.close();
		for (int i = 0; i < labirint.length; i++) {
			nextCoord: for (int j = 0; j < labirint[0].length; j++) {
				Direction pointer = new Direction(j, i); // preveri vsako polje
				if (labirint[pointer.y][pointer.x])
					continue nextCoord; // èe je polje true je tam stena... nadaljuj
				for (int c = 0; c < Direction.seznam.size(); c++) {
					pointer.move(Direction.seznam.get(c));
					try { // èe gre out of bound pomeni da mesto avtomatièno ni možno
						if (labirint[pointer.y][pointer.x]) {
							continue nextCoord;
						}
					} catch (IndexOutOfBoundsException e) {
						continue nextCoord;
					}
				}
				System.out.println((Direction.end.x + j + 1) + " " + (Direction.end.y + i + 1)); // èe prestane vse
																									// teste je mesto
																									// primerno
			}
		}
	}

	static class Direction {
		public byte x;
		public byte y;
		public static ArrayList<Direction> seznam = new ArrayList<Direction>();
		public static Direction end;

		public Direction(char c) { // za dodajanje relativnih kordinat, ki jih doda na seznam
			y = 0;
			x = 0;
			switch (c) {
			case 'V':
				x = 1;
				break;
			case 'S':
				y = -1;
				break;
			case 'J':
				y = 1;
				break;
			case 'Z':
				x = -1;
				break;
			}
			seznam.add(this);
		}

		public Direction(int a, int b) { // za dodajanje absolutnih kordinat
			x = (byte) a;
			y = (byte) b;
		}

		public void move(Direction s) { // vektorsko sešteje 2 Directiona
			this.x = (byte) (s.x + x);
			this.y = (byte) (s.y + y);
		}

		public static void finish() { // ko se pokaze @ se end nastavi na relativne kordinate izhodisca in konca
			Direction ret = new Direction(0, 0);
			for (Direction d : seznam)
				ret.move(d);
			end = ret;
		}
	}
}