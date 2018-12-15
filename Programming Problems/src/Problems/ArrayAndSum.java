package Problems;

import java.util.Scanner;

public class ArrayAndSum {

	public static Scanner scn = new Scanner(System.in);
	private static boolean found=false;
	private static int[] result = new int[2];

	public static void main(String[] args) {
		System.out.print("Type in the sum: ");
		int sum = scn.nextInt();
		System.out.print("Lenght of an array: ");
		int[] theArray = new int[scn.nextInt()];
		theArray=fillArrayInput(theArray);
		int[] diff = new int[theArray.length];
		printArray(theArray, true);
		printArray(diff, true);
		for(int i = 0; i < theArray.length; i++) {
		if(arrayIncludes(diff, theArray[i])) {
				found=true;
				result[0] = theArray[arrayIncludesAt(diff, theArray[i])];
				result[1] = theArray[i];
				continue;
			}else {
				diff[i] = (sum-theArray[i]);
			}
		}
		System.out.println(found);
		if(result!=null) printArray(result, false);
	}

	public static int[] fillArrayInput(int[] array) {
		int[] rtnArray = new int[array.length];
		for (int x = 0; x < array.length; x++) {
			System.out.print("Set " + (x + 1) + " to: ");
			rtnArray[x] = scn.nextInt();
		}
		return rtnArray;
	}

	public static void printArray(int[] array, boolean parentacies) {
		if (parentacies)
			System.out.print("[");
		for (int x = 0; x < array.length; x++) {
			if (!(array.length - 1 == x))
				System.out.print(array[x] + ", ");
			else if (parentacies)
				System.out.println(array[x] + "]");
			else
				System.out.println(array[x]);
		}
	}

	public static int arrayIncludesAt(int[] ar, int x) {
		for (int y = 0; y < ar.length; y++) {
			if (ar[y] == x)
				return y;
		}
		return -1;
	}
	
	public static boolean arrayIncludes(int[] ar, int x) {
		for (int y:ar) if (y == x) return true;
		return false;
	}
}