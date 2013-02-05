package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 绘制窗口类
 * 2013/2/5
 */

public class Lay {
	
	private static final int SIZE = 7;
	private static final Image WINDOW_IMG = new ImageIcon("graphics/window/window.png").getImage();
	private static final int WINDOW_IMGW = WINDOW_IMG.getWidth(null);
	private static final int WINDOW_IMGH = WINDOW_IMG.getHeight(null);
	
	private int x;	// 绘制左上角 x 坐标
	private int y;	// 绘制左上角 y 坐标
	private int w;	// 绘制宽度
	private int h;	// 绘制高度
	
	public Lay(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	/**
	 * 绘制窗口
	 */
	public void createWindow(Graphics g) {
		// 左上
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		// 中上
		g.drawImage(WINDOW_IMG, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WINDOW_IMGW-SIZE, SIZE, null);
		// 右上
		g.drawImage(WINDOW_IMG, x+w-SIZE, y, x+w, y+SIZE, WINDOW_IMGW-SIZE, 0, WINDOW_IMGW, SIZE, null);
		// 左中
		g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_IMGH-SIZE, null);
		// 中
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_IMGW-SIZE, WINDOW_IMGH-SIZE, null);
		// 右中
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_IMGW-SIZE, SIZE, WINDOW_IMGW, WINDOW_IMGH-SIZE, null);
		// 左下
		g.drawImage(WINDOW_IMG, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_IMGH-SIZE, SIZE, WINDOW_IMGH, null);
		// 中下
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_IMGH-SIZE, WINDOW_IMGW-SIZE, WINDOW_IMGH, null);
		// 右下
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_IMGW-SIZE, WINDOW_IMGH-SIZE, WINDOW_IMGW, WINDOW_IMGH, null);
	}
}
