package rtk2016_Vaje;

public class Naloge1_2 {

	public static void main(String[] args) {
		Zoom("120", 0, 0, 10, 10);
	}

	public static void Zoom(String s, double x1, double y1, double x2, double y2) {
		System.out.println(x1 + " - " + x2 + "\r\n" + y1 + " - " + y2);
		for (char c : s.toCharArray()) {
			double w = (y2 - y1) / 2;
			double h = (x2 - x1) / 2;
			int horizontalChange = (c - '0') % 2; // LD
			int verticalChange = (c - '0' - horizontalChange) / 2;// GD
			x1 += w * (horizontalChange);
			x2 -= w * (1 - horizontalChange);
			y1 += h * (1 - verticalChange);
			y2 -= h * (verticalChange);
		}
		System.out.println("Into: \r\n" + x1 + " - " + x2 + "\r\n" + y1 + " - " + y2);
	}
}
