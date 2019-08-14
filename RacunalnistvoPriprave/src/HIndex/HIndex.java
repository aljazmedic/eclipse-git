package HIndex;

public class HIndex {
	public static void main(String[] args) {
		int[] seznam = { 2, 5, 4, 3, 7, 2, 9, 10 };
		int maxNum;
		int currNumOf;
		int besure;
		maxNum = besure = 0;
		for (int i = 0; i < seznam.length; i++) {
			if (seznam[i] <= maxNum)
				continue;
			currNumOf = 1;
			for (int h = (besure < i ? besure : i); h < seznam.length; h++) {
				if (seznam[h] >= seznam[i])
					currNumOf++;
			}
			if (currNumOf > seznam[i])
				maxNum = seznam[i];
			else
				besure = i;
		}
		System.out.println(maxNum);
	}
}
