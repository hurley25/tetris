package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class LayerGame extends Layer {
	
	private static final Image ACT = new ImageIcon("graphics/game/rect.png").getImage();
	// TODO 配置文件
	private static final int ACT_SIZE = 32;
	// 左位移偏量
	private static final int SIZE_ROL = 7;

	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void paint(Graphics g) {
		this.createWindow(g);
		// 获得方块类型编号(0-6)
		int typeColorCode = this.dto.getGameAct().getTypeCode() + 1;
		// 获得方块数组集合
		Point points[] = this.dto.getGameAct().getActPoints();
		
		// 打印方块
		for (int i = 0; i < points.length; i++) {
			g.drawImage(ACT, 
						this.x + points[i].x * ACT_SIZE + SIZE_ROL,
						this.y + points[i].y * ACT_SIZE + SIZE_ROL,
						this.x + points[i].x * ACT_SIZE + ACT_SIZE + SIZE_ROL,
						this.y + points[i].y * ACT_SIZE + ACT_SIZE + SIZE_ROL,
						typeColorCode * 32, 0, typeColorCode * 32 + ACT_SIZE, ACT_SIZE, null);
		}
		
		// 打印地图
		boolean[][] map = this.dto.getGameMap();
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y]) {
					g.drawImage(ACT, 
							this.x + x * ACT_SIZE + SIZE_ROL,
							this.y + y * ACT_SIZE + SIZE_ROL,
							this.x + x * ACT_SIZE + ACT_SIZE + SIZE_ROL,
							this.y + y * ACT_SIZE + ACT_SIZE + SIZE_ROL,
							0, 0, 32, 32, null);
				}
			}
		}
	}
}
