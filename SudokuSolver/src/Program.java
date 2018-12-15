import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		loadFromFile("Sudoku1.txt");
		Cell.logSudoku();
		while (Cell.left != 0) {
			Cell.tick();
		}
	}

	public static void loadFromFile(String name) {
		Scanner scn;
		try {
			scn = new Scanner(new File("src/" + name));
		} catch (IOException ex) {
			scn = null;
			System.out.println("File not found");
			ex.printStackTrace();
		}
		String lin1 = scn.nextLine();
		Point base = new Point(Integer.parseInt(lin1.split(" ")[0]), Integer.parseInt(lin1.split(" ")[1]));
		Cell.setSudokuBase(base);
		int baseNum = base.x * base.y;
		int row = 0, collumn = 0;
		while (scn.hasNextLine()) {
			String line = scn.nextLine();
			for (char c : line.toCharArray()) {
				if (c == '*' || c == '0' || c == ' ') {
					new Cell(row, collumn++);
				} else {
					int ins = (int) (c - '0');
					if (ins > Cell.base.x * Cell.base.y)
						throw new Error("Wrong data! Entering:" + ins + " (Max: "+(base.x*base.y)+") @Coords:" + row + ":" + collumn);
					new Cell(ins, row, collumn++);
				}
			}
			if(collumn != baseNum) throw new Error("Error reading file! " + (collumn+1) + "collumn/s.");
			row++;
			collumn = 0;
		}
		if(row != baseNum) throw new Error("Error reading file! Only " + (row+1) +" row/s.");
	}

	public static class Cell {
		public static Cell[][] sudoku;
		public static int left;
		private static Point base;
		private static int lastLeft;
		
		private int value;
		private Point location;
		private boolean[] notPossibleAnswers;

		public Cell(int i, int x, int y) {
			value = i;
			left--;
			sudoku[x][y] = this;
		}

		public Cell(int x, int y) {
			value = 0;
			location = new Point(x, y);
			notPossibleAnswers = new boolean[base.x * base.y];
			sudoku[x][y] = this;
		}

		public static void tick() {
			for (Cell[] ca : sudoku) {
				for (Cell c : ca) {
					c.tickCell();
				}
			}
			Cell.lastLeft = left;
		}

		private void tickCell() {
			if (value != 0)
				return;
			checkSquare();
			checkLines();

			int nPAnum = 0;
			for (boolean b : notPossibleAnswers) {
				if (b)
					nPAnum++;
			}
			
			if (nPAnum == sudoku.length - 1) {
				assign();
			}
			if(lastLeft == left && left != 0) {
				logSudoku();
				throw new Error("No possible guesses left.");
			}
			
		}

		private void checkLines() {
			int y = location.y;
			int x = location.x;
			for (int i = 0; i < sudoku.length; i++) {
				if (sudoku[i][y].value != 0) {
					notPossibleAnswers[sudoku[i][y].value - 1] = true;
				}
				if (sudoku[x][i].value != 0) {
					notPossibleAnswers[sudoku[x][i].value - 1] = true;
				}
			}
		}

		private void checkSquare() {
			int startX = location.x - (location.x % base.x);
			int startY = location.y - (location.y % base.y);
			for (int i = startX; i < startX + base.x; i++) {
				for (int j = startY; j < startY + base.y; j++) {
					if (sudoku[i][j].value != 0) {
						notPossibleAnswers[sudoku[i][j].value - 1] = true;
					}
				}
			}
		}

		private void assign() {
			for (int i = 0; i < notPossibleAnswers.length; i++) {
				if (!notPossibleAnswers[i]) {
					this.value = i + 1;
				}
			}
			System.out.println("Value " + this.value + " assigned to cell "+(location.x+1)+":"+(location.y+1)+" Cells left: " + --left);
			Cell.tick();
			if (left == 0)
				logSudoku();
		}

		public static void setSudokuBase(Point base) {
			Cell.base = base;
			int baseNumber = base.y * base.x;
			sudoku = new Cell[baseNumber][baseNumber];
			left = baseNumber*baseNumber;
		}

		public static void logSudoku() {
			System.out.println("-------------------");
			for (int i = 0; i < sudoku.length; i++) {
				System.out.print("|");
				for (int j = 0; j < sudoku[0].length; j++) {
					System.out.print(sudoku[i][j].value);
					if ((j + 1) % Cell.base.y == 0)
						System.out.print("|");
					else
						System.out.print(" ");
				}
				System.out.println();
				if ((i + 1) % Cell.base.x == 0)
					System.out.println("-------------------");
			}
		}
	}
}
