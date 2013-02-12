package service;

import java.awt.Point;
import java.util.Random;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	
	private GameDto dto;
	
	// 随机数生成器
	private Random random = new Random();
	
	// 下一个方块
	private static final int MAX_TYPE = 6; 
	
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct();
		dto.setGameAct(act);		
	}
	
	/*
	 * 方块操作（上）
	 */
	public void keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
	}
	
	/*
	 * 方块操作（下）
	 */
	public void keyDown() {
		if (this.dto.getGameAct().move(0, 1, this.dto.getGameMap())) {
			return;
		}
		// 获得游戏地图对象
		boolean[][] map = this.dto.getGameMap();
		// 获得方块对象
		Point[] act = this.dto.getGameAct().getActPoints();
		// 方块添加到地图
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		// 判断消行
		int exp = this.plusExp();
		// 增加经验值
		this.levelUp(exp);
		// 随机生成下一个方块
		this.dto.getGameAct().init(this.dto.getNext());
		this.dto.setNext(random.nextInt(MAX_TYPE));
	}

	/*
	 * 方块操作（左）
	 */
	public void keyLeft() {
		this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
	}

	/*
	 * 方块操作（右）
	 */
	public void keyRight() {
		this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
	}
	
	// 增加分数
	private void levelUp(int exp) {
		int rmLine = this.dto.getNowRemoveLine();
		rmLine += exp;
		this.dto.setNowRemoveLine(rmLine);
	}
	
	/*
	 * 加分操作
	 */
	private int plusExp() {
		int exp = 0;
		boolean[][] map = this.dto.getGameMap();
		for (int y = 0; y < 18; y++ ) {
			if (isCanRemove(y, map)) {
				this.removeLine(y, map);
				exp++;
			}
		}
		return exp;
	}
	
	/*
	 * 消行操作
	 */
	private void removeLine(int rowNumber, boolean[][] map) {
		for (int x = 0; x < 10; x++ ) {
			for (int y = rowNumber; y > 0; y--) {
				map[x][y] = map[x][y-1];
			}
			map[x][0] = false;
		}
	}
	
	/*
	 * 判断一行能否消行
	 */
	private boolean isCanRemove(int y, boolean[][] map) {
		for (int x = 0; x < 10; x++ ) {
			if (!map[x][y]) {
				return false;
			}
		}
		return true;
	}
}
