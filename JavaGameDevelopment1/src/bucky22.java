import java.awt.*;
import javax.swing.*;


public class bucky22{
	public static void main(String[] args) {
		DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
		bucky22 bcky2 = new bucky22();
		bcky2.run();	
	}
	
	private Sprite sprite;
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
		
		sprite = new Sprite(a);
		sprite.setVelocityX(0.3f);
		sprite.setVelocityY(0.3f);
		
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
		while(cumTime - startingTime<a.getAnimationLenght()) {
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			update(timePassed);
			
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
		g.drawImage(sprite.getImage(), Math.round(sprite.getX()), Math.round(sprite.getY()), null);
	}
	
	public void update(long timePassed) {
		if(sprite.getX() < 0) {
			sprite.setVelocityX(Math.abs(sprite.getVelocityX()));
		}else if(sprite.getX() + sprite.getWidth() >= s.getWidth()) {
			sprite.setVelocityX(-Math.abs(sprite.getVelocityX()));
		}
		
		if(sprite.getY() < 0) {
			sprite.setVelocityY(Math.abs(sprite.getVelocityY()));
		}else if(sprite.getY() + sprite.getHeight() >= s.getHeight()) {
			sprite.setVelocityY(-Math.abs(sprite.getVelocityY()));
		}
		
		sprite.update(timePassed);
	}
	
}