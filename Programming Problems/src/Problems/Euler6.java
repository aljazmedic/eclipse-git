package Problems;

public class Euler6 {
	public static void main(String args[]) {
		int num = 100;
		int sum1 = 0, sum2 = 0;
		for (int i = 1; i <= num; i++) {
			sum1 += i*i;
			sum2 +=i;
		}
		sum2 *=sum2;
		System.out.println(sum2-sum1);//25164150

	}
}
