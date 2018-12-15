package Game;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Snake implements ActionListener, KeyListener {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public JFrame jframe;

	public RenderPanel renderPanel;

	public static Snake snake;

	public Timer timer = new Timer(20, this);

	public ArrayList<Point> snakeParts = new ArrayList<Point>();

	public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;

	public int ticks = 0, direction = DOWN, score, tailLenght = 10;

	public Point head, cherry;

	public Random random;

	public Dimension dim;

	private boolean over = false;

	public Snake() {
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Snake");
		jframe.setVisible(true);
		jframe.setSize(WIDTH, HEIGHT);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(renderPanel = new RenderPanel());
		jframe.addKeyListener(this);
		head = new Point(0, -1);
		cherry = new Point(dim.width / SCALE, dim.height / SCALE);
		random = new Random();
		for (int i = 0; i < tailLenght; i++) {
			snakeParts.add(new Point(head.x, head.y));
		}
		startGame();
		
	}

	public void startGame() {
		
		over = false;
		score = 0;
		tailLenght = 0;
		direction = DOWN;
		head = new Point(0, -1);
		cherry = new Point(dim.width / SCALE, dim.height / SCALE);
		random = new Random();
		snakeParts.clear();
		for (int i = 0; i < tailLenght; i++) {
			snakeParts.add(new Point(head.x, head.y));
		}
		timer.start();
		head = new Point(0, 0);
		cherry = new Point(dim.width / SCALE, dim.height / SCALE);
		random = new Random();
		for (int i = 0; i < tailLenght; i++) {
			snakeParts.add(new Point(head.x, head.y));
		}
		timer.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		renderPanel.repaint();
		ticks++;

		if (ticks % 5 == 0 && head != null && over != true) {
			if (direction == UP)
				if (head.y - 1 >= 0)
					head = new Point(head.x, head.y - 1);
				else
					over = true;
			if (direction == DOWN)
				if (head.y + 1 < dim.height / SCALE)
					head = new Point(head.x, head.y + 1);
				else
					over = true;
			if (direction == LEFT)
				if (head.x - 1 >= 0)
					head = new Point(head.x - 1, head.y);
				else
					over = true;
			if (direction == RIGHT)
				if (head.x + 1 < dim.width / SCALE)
					head = new Point(head.x + 1, head.y);
				else
					over = true;

			snakeParts.add(new Point(head.x, head.y));
			// for (int i = 0; i < tailLenght; i++) {
			// snakeParts.remove(i);
			// }

			// head = snakeParts.get(snakeParts.size()-1);
			if (cherry != null) {
				if (head.equals(cherry)) {
					score += 10;
					tailLenght++;
					cherry.setLocation(dim.width / SCALE, dim.height / SCALE);
				}
			}
		}
	}

	public static void main(String[] args) {
		snake = new Snake();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int i = e.getKeyCode();
		if (i == KeyEvent.VK_A && direction != RIGHT)
			direction = LEFT;
		if (i == KeyEvent.VK_D && direction != LEFT)
			direction = RIGHT;
		if (i == KeyEvent.VK_W && direction != DOWN)
			direction = UP;
		if (i == KeyEvent.VK_S && direction != UP)
			direction = DOWN;
		if (i== KeyEvent.VK_SPACE && over) startGame();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
