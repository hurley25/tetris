package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGame extends JPanel{

	private static final long serialVersionUID = -4916424649169424601L;
	private Lay[] lays = null;

	public PanelGame() {
		
		 lays = new Lay[] {
				new Lay(40, 32, 334, 279),
				new Lay(40, 343, 334, 279),
				new Lay(414, 32, 334, 590),
				new Lay(788, 32, 334, 124),
				new Lay(788, 188, 176, 148),
				new Lay(964, 188, 158, 148),
				new Lay(788, 368, 334, 200)
		};
	}
	
	public void paintComponent(Graphics g) {
		Image imgBK = new ImageIcon("graphics/background/bg01.jpg").getImage();
		g.drawImage(imgBK, 0, 0, 1162, 654, 0, 0, 640, 320, null);
		
		for (int i = 0; i < lays.length; i++) {
			lays[i].createWindow(g);
		}
	}
}
