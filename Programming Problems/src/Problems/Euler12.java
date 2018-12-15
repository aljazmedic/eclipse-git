package Problems;

public class Euler12 {
	public static void main(String[] args) {
		int i = 1;
		int add = 2;
		while(Methods.numOfDevidors(i)<500) {
			i+=add;
			add++;
			System.out.println(Methods.numOfDevidors(i));
		}
		System.out.println(i);
	}
}
