import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
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
		Main.cutPoints = cuts;
		cutting = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			cutting[i][i] = 0;
			for (int j = 0; j <= N; j++) {
				if (i != j)
					cutting[i][j] = -1;
			}
		}
		int minPrice = chopSticks(0, N);
		System.out.println("The minimum cutting is " + minPrice);
	}

	private static int chopSticks(int i, int j) {
		if (cutting[i][j] >= 0) {
			return cutting[i][j];
		}
		/*if (i == j - 1) {
			cutting[i][j] = (cutPoints[j] - cutPoints[i]);
			return (cutPoints[j] - cutPoints[i]);
		}*/
		int MinCena = 1001;
		for (int k = i + 1; k < j; k++) {
			int Cena = (cutPoints[j] - cutPoints[i]) + chopSticks(i, k) + chopSticks(k, j);
			MinCena = Math.min(Cena, MinCena);
		}
		cutting[i][j] = MinCena;
		return MinCena;
	}
}