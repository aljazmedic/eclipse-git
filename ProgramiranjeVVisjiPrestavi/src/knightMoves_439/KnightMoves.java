package knightMoves_439;

import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;	

public class KnightMoves {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextLine()) {
			String tmp = scn.nextLine();
			if(tmp.equals("")) break;
			getKnightMoves(tmp);
		}
		scn.close();
	}

	private static boolean[][] checked;

	private static void getKnightMoves(String string) {
		char[] chars = string.toCharArray();
		int moves = 0, untilMoveEnd = 1;
		checked = new boolean[8][8];
		Point currPoint = new Point((int) chars[0] - 'a', (int) chars[1] - '1');
		Point finishP = new Point((int) chars[3] - 'a', (int) chars[4] - '1');

		Queue<Point> preveri = new LinkedList<Point>();
		preveri.add(currPoint);
		while (!preveri.isEmpty()) {
			currPoint = preveri.remove();
			if (currPoint.x == finishP.x && currPoint.y == finishP.y) {
				System.out.println("To get from " + string.substring(0, 2) + " to " + string.substring(3, 5) + " takes "
						+ moves + " knight moves.");
				return;
			}
			checked[currPoint.x][currPoint.y] = true;
			Stack<Point> neighbors = getNeighbors(currPoint);
			preveri.addAll(neighbors);
			untilMoveEnd--;
			if (untilMoveEnd < 1) {
				moves++;
				untilMoveEnd = preveri.size();
			}
		}

	}

	private static Stack<Point> getNeighbors(Point point) {
		Stack<Point> ret = new Stack<Point>();
		for (int i = 0; i < 4; i++) {
			Point pt = (Point) point.clone();
			pt.translate((i % 2 == 0 ? 1 : -1), (i > 1 ? 2 : -2));
			try {
				if (!checked[pt.x][pt.y]) {
					ret.add(pt);
				}
			} catch (Exception e) {
			}
			pt = (Point) point.clone();
			pt.translate((i % 2 == 0 ? 2 : -2), (i > 1 ? 1 : -1));
			try {
				if (!checked[pt.x][pt.y]) {
					ret.add(pt);
				}
			} catch (Exception e) {
			}
		}
		return ret;
	}
}