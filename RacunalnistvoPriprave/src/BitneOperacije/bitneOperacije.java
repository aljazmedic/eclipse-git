package BitneOperacije;

class bitneOperacije {

	public static void main(String[] args) {
		System.out.println(Prva(5, 7) + " 5 7");
		int b = 13;
		System.out.println(Integer.toBinaryString(b) + " " + Integer.toBinaryString(b >> 1));
	}

	public static int Prva(int a, int b) {

		int c = 1;
		while (b > 0) {
			System.out.println(a + " " + b + " " + c);
			System.out.println(Integer.toBinaryString(a) + " " + Integer.toBinaryString(b) + " "
					+ Integer.toBinaryString(c) + "\r\n");

			if (b % 2 == 1)
				c *= a;
			a *= a;
			b >>= 1;
		}
		return c;
	}
}
