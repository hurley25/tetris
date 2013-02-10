package control;

import service.GameService;
import ui.JPanelGame;

public class GameControl {
	/*
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	/*
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame, GameService gameService) {
		this.panelGame = panelGame;
		this.gameService = gameService;
	}
	
	/*
	 * 控制键按下（上）
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}
	
	/*
	 * 控制键按下（下）
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}

	/*
	 * 控制键按下（左）
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}

	/*
	 * 控制键按下（右）
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
}
