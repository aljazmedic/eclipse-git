package Problems;

public class Euler2 {
	public static void main(String[] args) {
		int sum=0;
		int lasti=1;
		for(int i = 1;i<4000000;lasti=i-lasti) { //ta zanka sešteva soda števila Fibonaèijevega zaporedja do števila
			i += lasti;
			if(i%2 == 0) sum+=i;
		}
		System.out.println(sum);//4613732

	}
}
