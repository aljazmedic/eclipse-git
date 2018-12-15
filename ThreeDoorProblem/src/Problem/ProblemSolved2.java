package Problem;

import java.util.Random;
import java.util.Scanner;

public class ProblemSolved2 {
	public static Random rand = new Random();
	public static int doorsNum = 3, stay = -1;
	public static Scanner scn = new Scanner(System.in);
	public static boolean hit;

	public static void main(String[] args) {
		int prize = rand.nextInt(doorsNum) + 1;
		;
		int[] doors = new int[doorsNum];
		for (int i = 0; i < doors.length; i++) {
			if (i + 1 == prize)
				doors[i] = 1;
			else
				doors[i] = 0;
		}

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}

		printArray(doors);
		updateVisual(doors);

		int selection = (scn.nextInt() - 1) % doorsNum;
		if (selection == prize) { // ce zadane doloci vrata, drugace doloci nagrado da ostane
			doors[selection] = 3;
			do {
				stay = rand.nextInt(doorsNum); // stay is not prize
			} while (stay == prize + 1);
		} else {
			stay = prize;
		}

		printArray(doors);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		for (int i = 0; i < doors.length; i++) {
			if (!(i == prize - 1 || i == stay - 1))
				doors[i] = 2;
		}
		System.out.print(hit + "   ");
		printArray(doors);
		updateVisual(doors);
	}

	public static void updateVisual(int[] b) {
		for (int i = 0; i < b.length; i++) {

			if (b[i] == 3)
				System.out.print("XX "); // chosen
			else if (b[i] == 2)
				System.out.print("// "); // opened
			else
				System.out.print("II "); // door
		}
		System.out.println();
	}

	public static void printArray(int[] b) {
		for (int i = 0; i < b.length; i++)
			System.out.print(b[i]);
		System.out.println();
	}
}