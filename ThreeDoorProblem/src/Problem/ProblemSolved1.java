package Problem;

import java.util.Random;

public class ProblemSolved1 {
	public static Random rand = new Random();
	public static int doors = 3;
	public static int tries = 5000;
	private static int gets;

	public static void main(String[] args) {
		for (int h = 0; h < tries; h++) {
			int prize = rand.nextInt(doors);
			int selection = rand.nextInt(doors);
			if (prize != selection)
				gets++;
		}
		double percentage = ((double)gets/(double)tries)*100;
		System.out.println(gets + " / " + tries + "\r\n%" + percentage);
	}
}
