import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bearAndFriendship {

	private static ArrayList<Integer>[] sosednosti;
	private static boolean[] visited;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader scn = new BufferedReader(new InputStreamReader(System.in));// new
																					// FileReader("src/inputs/input2.txt"));
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
		boolean ok = true;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				// System.out.println("\rSegment od " + i);
				boolean segOk = checkSegment(i, 0, 0);
				// System.out.println("Segment ok: " + segOk);
				ok = ok && segOk;
			}
		}
		System.out.println(ok ? "YES" : "NO");
	}

	private static boolean checkSegment(int x, int povezave, long nodeCounter) {
		nodeCounter++;
		// System.out.println("Checking: " + x);
		visited[x] = true;
		povezave += sosednosti[x].size();
		// System.out.println("Povezave: " + povezave);
		// System.out.println("Prestetih nodov: " + nodes + "\r");
		for (int y : sosednosti[x]) {
			if (!visited[y]) {
				return checkSegment(y, povezave, nodeCounter);
			}
		}
		return povezave == nodeCounter * (nodeCounter - 1);
	}
}
