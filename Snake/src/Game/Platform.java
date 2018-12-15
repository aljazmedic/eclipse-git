package Game;

import java.awt.Color;
import java.util.Arrays;
import javax.swing.JFrame;

public class Platform {
	
	static int width = 400;
	static int height = 400;
	int w = 40;

	public static void main(String[] args) {

		JFrame Platform = new JFrame();
		Platform.setForeground(Color.BLUE);
		Platform.setTitle("Maze generator");
		Platform.setSize(width, height);
		Platform.setVisible(true);
		Platform.setResizable(false);
	}

}
