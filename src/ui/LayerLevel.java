package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer {
	
	// 标题图片
	private static final Image IMG_LEVEL = new ImageIcon("graphics/string/level.png").getImage();
	
	private static final int IMG_LEVEL_W = IMG_LEVEL.getWidth(null);

	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		// 窗口标题
		int centerX = this.x + (this.w - IMG_LEVEL_W  >> 1);
 		g.drawImage(IMG_LEVEL, centerX, this.y + PADDING, null);
		// 显示等级
		this.drawNumber(45, 45, this.dto.getLevel(), g);
	}

}
