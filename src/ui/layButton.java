package ui;

import java.awt.Graphics;

public class layButton extends Lay {
	
	public layButton(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
	}
}
