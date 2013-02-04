package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGame extends JPanel{

	private static final long serialVersionUID = -4916424649169424601L;

	public PanelGame() {
		
	}
	
	public void paintComponent(Graphics g) {
		Image img = new ImageIcon("graphics/background/bg01.jpg").getImage();
		g.drawImage(img, 0, 0, 1162, 654, 0, 0, 640, 320, null);
	}
}
