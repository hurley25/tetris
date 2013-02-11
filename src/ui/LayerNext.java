package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerNext extends Layer {
	
	private static final Image[] NEXT_ACT;
	
	static {
		NEXT_ACT = new Image[7];
		for (int i = 0; i < 7; i++) {
			NEXT_ACT[i] = new ImageIcon("graphics/game/" + i + ".png").getImage();
		}
	}
	
	public LayerNext(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		this.drawImageAtCenter(NEXT_ACT[this.dto.getNext()], g);
	}
	
	/*
	 * ´°¿ÚÕýÖÐ»æÍ¼
	 */
	private void drawImageAtCenter(Image img, Graphics g) {
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		g.drawImage(img, this.x + (this.w - imgW >> 1), this.y + (this.h - imgH >> 1), null);
	}
}
