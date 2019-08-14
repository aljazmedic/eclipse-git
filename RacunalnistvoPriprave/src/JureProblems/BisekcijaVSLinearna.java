package JureProblems;

import java.util.Random;

public class BisekcijaVSLinearna {

	public static void main(String[] args) {
		// write your code here
		// testiranje IntelliJ IDEA integracije

		System.out.println("   n     |    linearno  |   dvojisko   |");
		System.out.println("---------+--------------+---------------");

		for (int i = 1000; i <= 100000; i += 1000) {
			System.out.printf(" %7d | %12d | %12d |\n", i, timeLinear(i), timeBinary(i));
		}
	}

	private static int[] generateTable(int n) {
		int[] tabela = new int[n];
		for (int i = 0; i < n; i++) {
			tabela[i] = i;
		}
		return tabela;
	}

	private static void findLinear(int[] a, int v) {
		for (int st : a) {
			if (v == st) {
				return;
			}
		}
	}

	private static int findBinary(int[] a, int left, int right, int value) {
		if (a[left] == value) {
			return left;
		}
		if (a[right] == value) {
			return right;
		}
		int index = (right + left) / 2;
		if (a[index] == value) {
			return index;
		} else if (a[index] < value) {
			return findBinary(a, index, right, value);
		} else {
			return findBinary(a, left, index, value);
		}
	}

	private static long timeLinear(int n) {
		int[] tabela = generateTable(n);
		Random r = new Random();
		long startTime = 0;

		for (int i = 0; i < 2000; i++) {
			// konec ogrevanja
			if (i == 1000) {
				startTime = System.nanoTime();
			}
			findLinear(tabela, r.nextInt(n));
		}
		return (System.nanoTime() - startTime) / 1000;
	}

	private static long timeBinary(int n) {
		int[] tabela = generateTable(n);
		Random r = new Random();
		long startTime = 0;

		for (int i = 0; i < 2000; i++) {
			// konec ogrevanja
			if (i == 1000) {
				startTime = System.nanoTime();
			}
			findBinary(tabela, 0, tabela.length - 1, r.nextInt(n));
		}
		return (System.nanoTime() - startTime) / 1000;
	}
}
