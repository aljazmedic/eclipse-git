package cuttingSticks_10003;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CuttingSticks {
	public static void main(String[] args) throws IOException{
		Scanner scn = new Scanner(new File("src/cuttingSticks_10003/input.txt"));
		while (scn.hasNextLine()) {
			String tmp = scn.nextLine();
			if (tmp.equals("0"))
				break;
			int l = Integer.parseInt(tmp);
			int n = Integer.parseInt(scn.nextLine());
			tmp = scn.nextLine();
			String[] lenghtStrings = tmp.trim().split(" ");
			int[] cuts = new int[n + 2];
			cuts[0] = 0;
			for (int i = 1; i <= n; i++) {
				cuts[i] = Integer.parseInt(lenghtStrings[i - 1]);
			}
			cuts[++n] = l;
			getSticksCutting(cuts, n);
		}
		scn.close();
	}

	private static int[] cutPoints;
	private static int[][] cutting;

	private static void getSticksCutting(int[] cuts, int N) {
		CuttingSticks.cutPoints = cuts;
		cutting = new int[N + 1][N + 1];
		
		//Nastavi vse na -1 : unassigned, ce je x==y : Ni nic za rezat. 
		for (int i = 0; i <= N; i++) {
			cutting[i][i] = 0;
			for (int j = 0; j <= N; j++) {
				if (i != j)
					cutting[i][j] = -1;
			}
		}
		int minPrice = chopSticks(0, N);
		System.out.println("The minimum cutting is " + minPrice);
		
		//Debuggiranje
		for (int i = 0; i < cutting.length; i++) {
			for (int j = 0; j < cutting[0].length; j++) {
				System.out.print(cutting[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int chopSticks(int i, int j) {
		if (cutting[i][j] >= 0) {
			return cutting[i][j];
		}
		if (i == j - 1) {
			cutting[i][j] = (cutPoints[j] - cutPoints[i]);
			return (cutPoints[j] - cutPoints[i]);
		}
		int MinCena = Integer.MAX_VALUE;
		for (int k = i + 1; k < j; k++) {
			int Cena = (cutPoints[j] - cutPoints[i]) + chopSticks(i, k) + chopSticks(k, j);
			MinCena = Math.min(Cena, MinCena);
		}
		cutting[i][j] = MinCena;
		return MinCena;
	}
}