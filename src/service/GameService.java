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
		// TODO 修改为旋转
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
		// TODO 判断是否可以消行 消行 计分 是否升级
		// 刷新一个新的方块
		this.dto.getGameAct().init(random.nextInt(MAX_TYPE));
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
}
