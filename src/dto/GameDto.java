package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	
	// 数据库记录
	private List<Player> dbRecode;
	// 本地记录
	private List<Player> diskRecode;
	// 游戏地图
	private boolean[][] gameMap;
	// 下落方块
	private GameAct gameAct;
	// 显示的下一个方块
	private int next;
	// 等级
	private int level;
	// 当前成绩
	private int nowPoint;
	// 消行
	private int nowRemoveLine;
	
	/*
	 * 构造函数
	 */
	public GameDto() {
		dtoInit();
	}
	
	/*
	 * dto初始化
	 */
	public void dtoInit() {
		// TODO
		this.gameMap = new boolean[10][18];
		// 初始化所有游戏对象
	}

	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = dbRecode;
	}

	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = diskRecode;
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}
}
