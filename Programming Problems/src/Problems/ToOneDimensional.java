package Problems;

import java.util.ArrayList;
import java.util.Collection;

public class ToOneDimensional {
	static ArrayList<Integer> ListJeTo = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		char oue = 'Z';
		Object hhh = oue;
		System.out.println((hhh.getClass()==Character.class));
		
		int[][][] coll = {{{1}, {2}}, {{3}}, {{4}, {5}}};
//		RecursicalMethod(coll, ListJeTo);
		System.out.println(ListJeTo);
	
	}
	
	
//	static void RecursicalMethod(Object h, ArrayList<Integer> i) {
//		if(h.getClass()!=int.class && h.getClass()==Iterable.class) {
//			Iterable<Object> tempVar = h; 
//			for(Object v: tempVar) {
//				RecursicalMethod(v, i);
//			}
//		}else {
//			System.out.println(h.getClass());
//			System.out.println(h);
//			i.add((int)h);
//		}
//	}
}
