package Problems;

import java.util.ArrayList;

public class Euler3 {
	
	public static void main(String[] args) {
		ArrayList<Integer> factList = new ArrayList<Integer>();
		long number = 600851475143l; //razdre število na prafaktorje
		int current = 2;
		while(true) {
			if(current==number) {
				System.out.println("Biggest: " + number); //6857
				factList.add(current);
				break;
			}
			
			if(number%current==0) {
				factList.add(current);
				number /= current;
			}
			else current++;
			
		}
		for(int i = 0;i<factList.size();i++) {
			System.out.println(factList.get(i));
		}
	}

}
