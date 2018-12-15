

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WidthSearch {

	public static ArrayList<Integer>[] sosedi = new ArrayList[100];

	public static int[] p, d, cena;
	public static int n;

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(new File("src/graphs/input.txt"));
		Arrays.fill(sosedi, new ArrayList<Integer>());

		while (scn.hasNextLine()) {
			String temp = scn.nextLine();
			int a = Integer.parseInt(temp.split(" ")[0]);
			int b = Integer.parseInt(temp.split(" ")[1]);
			if (p == null) {
				n = a - 1;
				p = new int[a];
				d = new int[b];
				cena = new int[b];
				continue;
			}
			int c = Integer.parseInt(temp.split(" ")[2]);
			sosedi[a].add(new Integer(b));
			sosedi[b].add(new Integer(a));
		}
		scn.close();
		System.out.println("\rBFS");
		bfs(1);
		System.out.println("\rDFS");
		for (int i = 1; i < n; i++) {
			d[i] = -1;
			p[i] = -1;
		}
		dfs(1);
		System.out.println("Dijkstra\r");
	}

	private static void bfs(int x) {
		for (int i = 1; i < n; i++)
			d[i] = -1;
		d[x] = 0;
		p[x] = -1;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		while (!q.isEmpty()) {
			x = q.remove();
			for (int y : sosedi[x]) {
				if (d[y] == -1) {
					p[y] = x;
					d[y] = d[x] + 1;
					q.add(x);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(i + " " + d[i] + " " + p[i]);
		}
	}

	private static void dfs(int x) {
		System.out.println(x);
		for (int y : sosedi[x]) {
			System.out.print("Sosed od " + x + " : " + y);
			if (p[y] == -1) {
				System.out.println("-Izracun");
				p[y] = x;
				dfs(y);
			} else
				System.out.println();
		}
	}

	private static int[] d2;

	private static void dijkstra_n2(int x) {
		d2 = new int[d.length];
		for (int y = 1; y <= n; y++)
			d2[y] = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++)
			d[i] = -1;
		d2[x] = 0;
		for (int i = 0; i < n; i++) {
			int md = -Integer.MAX_VALUE;
			x = -1;
			for (int y = 1; y <= n; y++) {
				if (d[y] > md) {
					md = d[y];
					x = y;
				}
			}
			// dodaj
			d[x]=d2[x];//crno v rdeco
//			for(int z : sosedi[y]){
//				int c=0;//TODO;
//				if(d[x]+c > d2[z]) {
//					d2[x];
//				}
//			}
		}
	}
}
