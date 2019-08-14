import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.JFrame;

import sun.awt.resources.awt;

public class Okno extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6567874503287392257L;

	Panel pnl;

	public Okno(Dimension d) {
		pnl = new Panel();
		pnl.setBackground(Color.WHITE);
		this.setSize(d);
		this.setVisible(true);
		this.add(pnl);
		this.setTitle("MyFitnesMedic");
	}

	public void Dodaj(Component a) {
		this.pnl.add(a);
	}
}
