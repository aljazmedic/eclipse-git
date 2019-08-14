package Problems;

import java.util.ArrayList;

public class Euler4 {
	public static void main(String[] args) {
		ArrayList<Number> list = new ArrayList<Number>();
		for(int w = 999;w>99;w--) {
			for(int v = 999;v>99;v--) {
				list.add(new Number(w, v));
			}
		}
		Number currNum = new Number(1, 1);
		for(int i = 1;i<list.size();i++) {
			if(list.get(i).getPro() > currNum.getPro() && isPalindrome(list.get(i).getPro())){
				currNum = list.get(i);
			}
		}
		System.out.println(currNum.getPro());//906609
	}

	public static boolean isPalindrome(long z) {
		StringBuffer y = new StringBuffer(), x = new StringBuffer(Long.toString(z));
		for (int i = 0; i < x.length(); i++) y.append(x.charAt(x.length() - i - 1));
		for (int h = 0; h < x.length(); h++) if (x.charAt(h) != y.charAt(h)) return false;
		return true;
	}

	public static class Number {
		public int firstP, secondP, product;
		public Number(int firstP, int secondP) {
			this.firstP = firstP;
			this.secondP = secondP;
			product = firstP * secondP;
		}
		public int getPro() {return product;}
	}
}
