package Problems;

public class Euler10 {
	public static void main(String[] args) {
		int theNum = 2000000;
		long sum = 2;
		for (int h = 3; h < theNum; h+=2) if (isPrime(h)) sum += h;
		System.out.println(sum);
	}
	
	public static boolean isPrime(int num) {
		for(int i = 3; i <= Math.sqrt(num); i++) {
			if(num%i == 0)
				return false;
		}
		
		return true;
	}
}
