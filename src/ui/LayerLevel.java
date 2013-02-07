package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer {
	
	private static Image IMG_LEVEL = new ImageIcon("graphics/string/level.png").getImage();

	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		g.drawImage(IMG_LEVEL, this.x + PADDING, this.y + PADDING, null);
	}
}
