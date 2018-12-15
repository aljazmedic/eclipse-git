package Problem;

import java.util.Random;

public class testi {
public static void main(String[] args) {
	Random rnd = new Random();
	for(int i = 0; i < 100; i++) {
		System.out.println(rnd.nextInt(3));
	}
}
}
