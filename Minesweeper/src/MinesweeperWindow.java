import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class MinesweeperWindow {
	JFrame frame;
	private JTable table;

	/**
	 * Create the application.
	 */
	public MinesweeperWindow(int rows) {
		initialize(rows);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int rows) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(275, 22, 99, 23);
		btnNewGame.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(btnNewGame);

		table = new JTable(Minesweeper.rows, Minesweeper.collumns);
		table.setBounds(10, 10, 240, 240);
		table.setRowHeight(Math.floorDiv(table.getHeight(),rows));

		frame.getContentPane().add(table);
		table.setEnabled(false);
	}

	public void tableDo(int x, int y, String ch) {
		//TODO table.setRow
	}
}
