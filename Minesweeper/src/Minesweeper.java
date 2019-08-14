import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Minesweeper {

	public static int collumns = 10;
	public static int rows = 10;
	public static int numberOfBombs = 9;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MinesweeperWindow window = new MinesweeperWindow(rows);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		List<Brick> table = new LinkedList<Brick>();
		for (int i = 0; i < collumns; i++) {
			for (int j = 0; j < rows; j++) {
				table.add(new Brick(i, j));
			}
		}

		Brick.bombs = 0;
		Random rnd = new Random();
		while (Brick.bombs < numberOfBombs) {
			int i;
			do {
				i = rnd.nextInt(table.size());
			} while (table.get(i).isBomb);
			table.get(i).setBomb();
			Brick.bombs++;
		}

		for (int i = 0; i < collumns; i++) {
			for (int j = 0; j < rows; j++) {
				if (table.get(i * collumns + j).isBomb) {
					System.out.print("X");
					continue;
				}
				table.get(i * collumns + j).calculate(table);
				System.out.print(table.get(i * collumns + j).neighborBombs);
			}
			System.out.println();
		}

	}

	static class Brick {
		public static int bombs;
		private int x;
		private int y;
		private boolean isBomb;
		private boolean isRevealed;
		private Brick[] neighbs;
		private int neighborBombs;
		private boolean tagged;

		public Brick(int x, int y) {
			this.x = x;
			this.y = y;
			neighborBombs = 0;
			neighbs = new Brick[8];
			tagged = false;
			isBomb = false;
			isRevealed = false;
		}

		public void setBomb() {
			isBomb = true;
		}

		public void calculate(List<Brick> table) {
			if (this.isBomb)
				return;
			int t = 0;
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					int tx = x + j;
					int ty = y + i;
					if ((i == 0 && j == 0) || tx < 0 || tx >= collumns || ty < 0 || ty >= rows)
						continue;
					neighbs[t++] = table.get(tx * collumns + ty);
					if (table.get(tx * collumns + ty).isBomb)
						neighborBombs++;
				}
			}
			Display(x, y, '?');
		}

		public void click() {
			if (isBomb)
				endGame();
			if(tagged || isRevealed)
				return;
			if (neighborBombs == 0) {
				Display(x, y, ' ');
				reveal();
				for (Brick b : neighbs)
					b.click();
				return;
			}
			reveal();
			Display(x, y, (char) (neighborBombs - '0'));
			//TODO check();
		}

		public void rclick() {
			if (isRevealed)
				return;
			if (tagged) {
				Display(x, y, 'F');
				if (isBomb)
					Brick.bombs--;
			} else {
				Display(x, y, '?');
				if (isBomb)
					Brick.bombs++;
			}
		}

		public boolean isRevealed() {
			return isRevealed;
		}

		public void reveal() {
			isRevealed = true;
		}
	}

	public static void endGame() {
		throw new Error("Game Lost");
	}

	public static void Display(int x, int y, char data) {
		// display... i guess

	}
}
