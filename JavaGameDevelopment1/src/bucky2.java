import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class bucky2{
	public static void main(String[] args) {
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		bucky2 bcky = new bucky2();
		bcky.run();	
	}
	
	private Animation a;
	private ScreenManager s;
	private Image bg;
	private static final DisplayMode modes1[] = {
		new DisplayMode(800,600,32,0),
		new DisplayMode(800,600,24,0),
		new DisplayMode(800,600,16,0),
		new DisplayMode(800,480,32,0),
		new DisplayMode(800,480,24,0),
		new DisplayMode(800,480,16,0),
	};
	
	//load images and add scenes
	public void loadImages() {
		bg = new ImageIcon("D:\\Aljaz\\Eclipse\\background.png").getImage();
		Image face1 = new ImageIcon("D:\\Aljaz\\Eclipse\\Animation1.png").getImage();
		Image face2 = new ImageIcon("D:\\Aljaz\\Eclipse\\Animation2.png").getImage();
		a = new Animation();
		a.addScene(face1, 250);
		a.addScene(face2, 250);
	}
	
	//main method from main
	public void run() {
		s= new ScreenManager();
		try {
			DisplayMode dm = s.findFirstCompatibleMode(modes1);
			//DisplayMode dm = s.vc.getDisplayMode();  ////ta line je naknadno spremenjen.... glej ScreenManager/vc private-->public
			s.setFullScreen(dm);
			loadImages();
			movieLoop();
		}finally {
			s.restoreScreen();
		}
	}

	//play movie
	private void movieLoop() {
		long startingTime = System.currentTimeMillis();
		long cumTime = startingTime;
		while(cumTime - startingTime<5000) {
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			a.update(timePassed);
			
			//draw and update the screen
			Graphics2D g = s.getGraphics();
			draw(g);
			g.dispose();
			s.update();
			
			try {
				Thread.sleep(20);
			}catch(Exception ex) {}
		}
		
	}

	//draws image
	public void draw(Graphics2D g) {
		g.drawImage(bg, 0, 0, null);		
		g.drawImage(a.getImage(), 0,0, null);
	}
}