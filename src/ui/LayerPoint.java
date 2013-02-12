package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	
	// 分数图片
	private static final Image IMG_POINT = new ImageIcon("graphics/string/point.png").getImage();
	
	private static final int POINT_Y = PADDING;
	
	// 消行图片
	private static final Image IMG_RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	
	private static final int RMLINE_Y = IMG_RMLINE.getHeight(null) + (PADDING << 1);
	
	// 值槽的宽度
	private final int expW;
	
	private static final int LEVEL_UP = 20;
	
	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		this.expW = this.w - (PADDING << 1);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		// 分数图片
		g.drawImage(IMG_POINT, this.x + PADDING, this.y + POINT_Y, null);
		this.drawNumber(150, -5, this.dto.getNowPoint(), g);
		// 消行图片
		g.drawImage(IMG_RMLINE, this.x + PADDING, this.y + RMLINE_Y, null);
		this.drawNumber(150, 40, this.dto.getNowRemoveLine(), g);
		// 绘制值槽
		int h = 32;
		g.setColor(Color.BLACK);
		g.fillRect(this.x + PADDING, this.y + PADDING * 7, this.expW, h);
		g.setColor(Color.WHITE);
		g.fillRect(this.x + PADDING + 1, this.y + PADDING * 7 + 1, this.expW - 2, h - 2);
		g.setColor(Color.BLACK);
		g.fillRect(this.x + PADDING + 2, this.y + PADDING * 7 + 2, this.expW - 4, h - 4);
		g.setColor(Color.GREEN);
		int rmline = this.dto.getNowRemoveLine();
		int w = (int)(((double)(rmline % LEVEL_UP) / (double)LEVEL_UP) * (this.expW - 4));
		g.fillRect(this.x + PADDING + 2, this.y + PADDING * 7 + 2, w, h - 4);
	}
}
