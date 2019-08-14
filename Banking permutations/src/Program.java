import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * BufferedReader scn = new BufferedReader( new
		 * InputStreamReader(System.in));//new FileReader("src/inputs/input4.txt"));//
		 */
		float i = 220.19f;
		System.out.println(i + ":\r\n" + bestPermutation(i));
	}

	public static String bestPermutation(float input) {
		int x = (int) Math.floor(input);
		int y = (int) Math.floor((input % 1)*100);

		if (x % 100 == 0)
			Edegree = 6;
		else if (x % 10 == 0)
			Edegree = 3;
		else
			Edegree = 0;

		if (y % 10 == 0)
			Cdegree = 3;
		else
			Cdegree = 0;
		
		minECombo = "€ ";
		minELength = x;
		minCCombo = "¢ ";
		minCLength = y;
		getEPermutations(x, minECombo, 0);
		getCPermutations(y, minCCombo, 0);
		return minECombo + " " + minCCombo;
	}

	private static int minELength;
	private static String minECombo;
	private static int Edegree;
	public static int[] Eoptions = new int[] { 1, 2, 5, 10, 20, 50, 100, 200, 500 };

	private static int minCLength;
	private static String minCCombo;
	private static int Cdegree;
	public static int[] Coptions = new int[] { 1, 2, 5, 10, 20, 50 };

	private static void getEPermutations(int x, String builded, int num) {
		if (x < 0 || minELength < num) {
			return;
		} else if (x == 0 && num <= minELength) {
			minECombo = builded;
			minELength = num;
			return;
		}

		for (int i = Eoptions.length - 1; i >= Edegree; i--) {
			if (Eoptions[i] > x)
				continue;
			getEPermutations(x - Eoptions[i], builded + Eoptions[i] + ",", num + 1);
		}
		return;
	}

	private static void getCPermutations(int x, String builded, int num) {
		if (x < 0 || minCLength < num) {
			return;
		} else if (x == 0 && num <= minCLength) {
			minCCombo = builded;
			minCLength = num;
			return;
		}

		for (int i = Coptions.length - 1; i >= Cdegree; i--) {
			if (Coptions[i] > x)
				continue;
			getCPermutations(x - Coptions[i], builded + Coptions[i] + ",", num + 1);
		}
		return;
	}
}
