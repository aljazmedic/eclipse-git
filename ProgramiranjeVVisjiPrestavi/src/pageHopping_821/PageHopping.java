package pageHopping_821;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PageHopping {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(scn.hasNextLine()){
			String tmp = scn.nextLine();
			if(tmp.equals(new String("0 0"))){
				break;
			}else{
				calculateAverage(tmp);
			}
		}
		scn.close();
		
	}

	private static void calculateAverage(String string) {
		Node.nodes = new TreeSet<Node>();
		String[] split = string.split("  ");
		for (int i = 0; i < split.length; i++) {
			int start = Integer.parseInt(split[i].split(" ")[0]);
			int end = Integer.parseInt(split[i].split(" ")[1]);
		}
		
	}
	
	public static class Node{
		public static Set<Node> nodes;
		public int value;
		private List<Integer> connections;
		
		public Node(int value){
			this.value = value;
			connections = new LinkedList<Integer>();
			nodes.add(this);
		}
		
		public int hashCode(){
			return value;
		}
		
		public void connect(int c){
			connections.add(c);
		}
	}
}