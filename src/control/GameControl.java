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
}
