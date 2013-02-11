package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {
	
	// 方块数组
	private Point[] actPoints;
	
	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	
	// 方块编号
	private int typeCode;
	
	private static List<Point[]> TYPE_CONFIG;
	
	static {
		// TODO 配置文件
		TYPE_CONFIG = new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[] {new Point(4,0), new Point(3,0), new Point(5,0), new Point(6,0)});
		TYPE_CONFIG.add(new Point[] {new Point(4,0), new Point(3,0), new Point(5,0), new Point(4,1)});
		TYPE_CONFIG.add(new Point[] {new Point(4,0), new Point(3,0), new Point(5,0), new Point(3,1)});
		TYPE_CONFIG.add(new Point[] {new Point(4,0), new Point(5,0), new Point(3,1), new Point(4,1)});
		TYPE_CONFIG.add(new Point[] {new Point(4,0), new Point(5,0), new Point(4,1), new Point(5,1)});
		TYPE_CONFIG.add(new Point[] {new Point(4,0), new Point(3,0), new Point(5,0), new Point(5,1)});
		TYPE_CONFIG.add(new Point[] {new Point(4,0), new Point(3,0), new Point(4,1), new Point(5,1)});
	}
	
	public GameAct() {
		// TODO
		actPoints = new Point[] { new Point(4,0), new Point(3,0), new Point(5,0), new Point(5,1) };
	}
	
	public void init(int typeCode) {
		this.typeCode = typeCode;
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			actPoints[i] = new Point(points[i].x, points[i].y);
		}
	}
	
	// 获得方块
	public int getTypeCode() {
		return typeCode;
	}

	public Point[] getActPoints() {
		return actPoints;
	}

	/*
	 * 方块移动方法 
	 */
	public boolean move(int moveX, int moveY, boolean[][] gameMap) {
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if (isOverZone(newX, newY, gameMap)) {
				return false;
			}
		}
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
		return true;
	}
	
	/*
	 * 方块旋转
	 * 
	 * 顺时针 ：
	 * A.x = 0.y + 0.x - B.y
	 * A.y = 0.y - 0.x + B.x
	 */
	public void round(boolean[][] gameMap) {
		if (this.typeCode == 4) {
			return;
		}
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			if (isOverZone(newX, newY, gameMap)) {
				return;
			}
		}
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].y + actPoints[0].x - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}
	}
	
	/*
	 * 判断是否超出边界或者被阻碍
	 */
	private boolean isOverZone(int x, int y, boolean[][] gameMap) {
		return (x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y || gameMap[x][y]);
	}
}
