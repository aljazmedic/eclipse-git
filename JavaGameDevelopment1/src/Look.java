import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class Look extends Core implements MouseMotionListener, MouseListener, KeyListener, MouseWheelListener {
	public static void main(String[] args) {
		new Look().run();
	}
	
	private Image bg;
	private Robot robot;
	private Point mouse;
	private Point center;
	private Point image;
	private boolean centering;
	
	//init
	public void init() {
		super.init();
		mouse = new Point();
		center = new Point();
		image = new Point();
		centering = false;
		
		
		try {
			robot = new Robot();
			//recenterMouse();
			mouse.x = center.x;
			mouse.y = center.y;
		}catch(Exception ex) {
			System.out.println("Exception 1");
		}
		
		Window w = s.getFullScreenWindow();
		w.addMouseMotionListener(this);
		w.addKeyListener(this);
		bg = new ImageIcon("D:\\Aljaz\\Eclipse\\Animation2.png").getImage();
		
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
}
