import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseInput extends Core implements KeyListener, MouseMotionListener, MouseListener,MouseWheelListener {
	public static void main(String[] args) {
		new MouseInput().run();
	}
	
	
	private String mess="";
	
	//init calls super init
	public void init() {
		super.init();
		Window w = s.getFullScreenWindow();
		w.addMouseListener(this);
		w.addMouseListener(this);
		w.addMouseWheelListener(this);
		w.addKeyListener(this);
	}

	public synchronized void draw(Graphics2D g) {
		Window w = s.getFullScreenWindow();
		g.setColor(w.getBackground());
		g.fillRect(0, 0, s.getWidth(), s.getHeight());
		g.setColor(w.getForeground());
		g.drawString(mess, 300, 300);
	}
	
	public void mousePressed(MouseEvent e) {
		mess = "You pressed down the mouse";
	}

	public void mouseReleased(MouseEvent e) {
		mess = "You released the mouse";
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {
		mess = "you dragged the mouse";
	}
	
	public void mouseMoved(MouseEvent e) {
		mess = "you moved the mouse";
	}
	
	public void mouseWheelMoved(MouseWheelEvent e) {
		mess = "moving mouse wheel";
		
	}

	//key pressed
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_ESCAPE) {
			stop();
		}else {
			mess = "Pressed : "+ KeyEvent.getKeyText(keyCode);
			e.consume();
		}
	}

	//key released
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		mess = "Released : "+ KeyEvent.getKeyText(keyCode);
		e.consume();
	}

	public void keyTyped(KeyEvent e) {	
		e.consume();
	}


	
}
