package Problems;

import java.util.ArrayList;

public class Euler7 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 2;
		while (list.size() < 10001) {  //na ArrayList dodaja Praštevila, dokler ni ArrayList dolg x
			if(isPrime(i)) {
				list.add(i);
			}
			i++;
		}
		System.out.println(list.get(10000)); //104743
	}
	public static boolean isPrime(int x) { // preveri, ce je stevilo prastevilo
		if(x==1)return false;
		if(x==2)return true;
		int counter = 0;
		for(int h = 2;h<x-1;h++) {
			if(x%h!=0) counter++;
		}
		if(counter==x-3) return true;
		else return false;
	}
}
