import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class E_KinGsPath {
	private static String[] order;
	private static LinkedList<Character> myalphabet;

	public static void main(String[] args) throws IOException {
		BufferedReader scn = new BufferedReader(new FileReader("src/inputs/input5.txt"));// new InputStreamReader(System.in));//
		int n = Integer.parseInt(scn.readLine());
		order = new String[n];
		for (int i = 0; i < n; i++)
			order[i] = scn.readLine();
		scn.close();
		myalphabet = new LinkedList<Character>();
		for (int i = 0; i < myalphabet.size();)
			myalphabet.add((Character) (char) (i++));
		for (String s : order)
			System.out.println(s);
		for (int i = n - 1; i > 0; i--) {
			compare(order[i - 1], order[i]);
		}
		int curr = order[0].charAt(0) - 'a';
		System.out.println();

		for (int i = 0; i < myalphabet.size(); i++)
			System.out.print((char) (myalphabet.get(i) + 'a') + " ");
		System.out.println();
		// while (curr <=25) {
		// System.out.print((char) (curr + 'a') + "->");
		// curr = myalphabet[curr];
		// }
		// System.out.println();
	}

	private static void compare(String si, String sj) {
		for (int i = 0; i < Math.min(si.length(), sj.length()); i++) {
			char x = (char) (si.charAt(i) - 'a');
			char y = (char) (sj.charAt(i) - 'a');
			if (x < y) {
				//SWITCH
				char t = y;
				y = x;
				x = t;
			}
			if (x > y) {
				//OK
				ListIterator<Character> litx = myalphabet.listIterator(x);
				ListIterator<Character> lity = myalphabet.listIterator(y);
				if(!lity.hasPrevious()) {
					//litx.previous() = 
				}
			} 
				
		}
	}
}
