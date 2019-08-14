import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D_twoButtons {
	
	public static void main(String[] args) throws IOException {
		BufferedReader scn = new BufferedReader(
				new FileReader("src/inputs/input4.txt"));//new InputStreamReader(System.in));//
		String[] parts = scn.readLine().split(" ");
		int start = Integer.parseInt(parts[0]);
		int target = Integer.parseInt(parts[1]);
		scn.close();
		int n = minMoves(start, target);
		System.out.println(n);
	}

	private static int minMoves(int start, int target) {
		if(start==target) return 0;
		if(target%2==0 && target>start) {
			return 1+minMoves(start, target/2);
		}else {
			return 1+minMoves(start, target+1);
		}
	}
}
