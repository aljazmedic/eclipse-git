import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cyclicComponents {

	private static ArrayList<Integer>[] sosednosti;
	private static boolean[] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader scn = new BufferedReader(new FileReader("src/inputs/input2.txt"));//new InputStreamReader(System.in));//
		String[] parts = scn.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		sosednosti = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < sosednosti.length; i++)
			sosednosti[i] = new ArrayList<Integer>();
		for (int i = 0; i < m; i++) {
			String line = scn.readLine();
			parts = line.split(" ");
			int a = Integer.parseInt(parts[0]);
			int b = Integer.parseInt(parts[1]);
			sosednosti[a].add(b);
			sosednosti[b].add(a);
		}
		scn.close();
		// for (int i = 0; i < sosednosti.length; i++) {
		// for (int j = 0; j < sosednosti[i].size(); j++) {
		// System.out.print(sosednosti[i].get(j)+" ");
		// }
		// System.out.println();
		// }

		int number = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i])
				number += checkSegment(i);
		}
		System.out.println(number);
	}

	private static int checkSegment(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		int ok = 1;
		q.add(x);
		while (!q.isEmpty()) {
			x = q.remove();
			visited[x] = true;

			if (sosednosti[x].size() != 2) { // Ze ce eden ne ustreza lahko vse
				ok = 0;
			}
			for (int y : sosednosti[x]) {
				if (!visited[y]) {
					q.add(y);
				}
			}
		}
		return ok;
	}
}
