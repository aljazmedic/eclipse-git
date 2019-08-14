package Problems;

import java.util.ArrayList;

public class Fibonnaci {
	static ArrayList<Long> fibNums = new ArrayList<Long>();
	
	
	public static void main(String args[]) {
		for(int i = 0;i<150;i++) {
			for(int j = 0;j<fibNums.size();j++) System.out.print(fibNums.get(j)+", ");
			System.out.println();
			System.out.print(Fibonnachi(i)+", ");
		}
		//System.out.println(Fibonnachi(500));
	}
	
	static long Fibonnachi(int n) {
		if(n == 0 || n == 1) {
			fibNums.add((long) 1);
			return 1;
		}
		else {
			try {   // preveri ce mnozica vsebuje n-1 element in ce ga ne, ga doda... tako zmanjsamo stevilo klicev rekurzike.
				return fibNums.get(n-1) + fibNums.get(n-2); //to 
			}catch(Exception ex) {
				fibNums.add(n-1, Fibonnachi(n-1));
			}
			return fibNums.get(n-1) + fibNums.get(n-2);
		}
	}
}
