package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayBackgroung extends Lay {
	
	private static Image IMG_BK = new ImageIcon("graphics/background/bg01.jpg").getImage();
	
	public LayBackgroung(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void paint(Graphics g) {
		// TODO
		g.drawImage(IMG_BK, 0, 0, 1162, 654, null);
	}
}
