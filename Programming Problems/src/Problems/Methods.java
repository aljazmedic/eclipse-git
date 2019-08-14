package Problems;

import java.util.ArrayList;

public class Methods {
	
	public static boolean isPrime(long n) { // preveri, ce je stevilo prastevilo
		if(n==1 || n == 4)return false;
	    for(int i=2;i<n/2;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public static int numOfDevidors(int n) {
		int h = 0;
		for(int i = 1;i<=n;i++) {
			if(n%i==0) h++;
		}
		return h;
	}
}
