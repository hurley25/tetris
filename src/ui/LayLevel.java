package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayLevel extends Lay {
	
	private static Image IMG_LEVEL = new ImageIcon("graphics/string/level.png").getImage();

	public LayLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_LEVEL, this.x + PADDING, this.y + PADDING, null);
	}
}
