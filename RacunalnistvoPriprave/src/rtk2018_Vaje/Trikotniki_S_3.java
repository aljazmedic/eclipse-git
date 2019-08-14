package rtk2018_Vaje;

public class Trikotniki_S_3 {
	public static void main(String[] args) {
		int x = 2;
		int y = 2;
		int v = 4;
		for (int i = x; i < x + v; i++) {
			for (int j = y; j < y + v - (i - x); j++) {
				System.out.println(i + " " + j);
			}
		}
	}

}
