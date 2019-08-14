package Problems;

public class Euler1 {
	public static void main(String[] args) {
		int sum=0, theNumber = 1000;
		for(int i = 0; i < theNumber; i++) {
			if(i%3 == 0) sum +=i;
			else if(i%5 == 0) sum +=i;
		}
		System.out.println(sum);//233168
	}
}
