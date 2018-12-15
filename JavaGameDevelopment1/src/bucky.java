import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class bucky{
	
	public static void main(String[] args) {
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		bucky b = new bucky();
		b.run(dm);	
	}
	
	private Screen screen;
	private Image bg;
	private Animation a;
	
	//loads pictures from comp to java
	public void loadPics() {
		bg = new ImageIcon("D:\\Aljaz\\Eclipse D\\background.png").getImage();
		Image face1 = new ImageIcon("D:\\Aljaz\\Eclipse D\\Animation1.png").getImage();
		Image face2 = new ImageIcon("D:\\Aljaz\\Eclipse D\\Animation2.png").getImage();
		a = new Animation();
		a.addScene(face1, 300);
		a.addScene(face2, 250);
	}
	
	//main engine to run
	public void run(DisplayMode dm) {
		screen = new Screen();
		try {
			screen.setFullScreen(dm, new JFrame());
			loadPics();
			movieLoop();
		}finally{
			screen.restoreScreen();
		}
	}
	
	//main movie loop
	public void movieLoop() {
		long startingTime = System.currentTimeMillis();
		long cumTime = startingTime;
		
		while(cumTime - startingTime <a.getAnimationLenght()) {
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			a.update(timePassed);
			
			Graphics g = screen.getFullScreenWindow().getGraphics();
			draw(g);
			g.dispose();
			
			try {
				Thread.sleep(20);
			}catch(Exception ex) {}
		}
	}
	
	//draw method
	public void draw(Graphics g) {
		if(g instanceof Graphics2D) {
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);	
		}
		g.drawImage(bg, 0, 0, null);
		g.drawImage(a.getImage(),200, 200, null);
		g.drawString(Integer.toString(a.getAnimationLenght()), 500, 500);
	}
}
