package Problems;

public class Euler5 {
	public static void main(String args[]) {
		int number = 1, divs = 0;
		boolean allOk = true;
		while(allOk) {
			divs=0;
			for(int i = 1; i <=20;i++) {
				if(number%i != 0) {
					number++;
					break;
				}else {
					divs++;
					if(divs == 20) allOk = false;
				}
			}
		}
		System.out.println(number);//232792560
	}
}
