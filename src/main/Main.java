package main;

import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;
import control.GameControl;
import control.PlayerConcrol;
import dto.GameDto;

public class Main {
	
	public static void main(String[] args) {
		
		// 创建游戏数据源
		GameDto dto = new GameDto();
		// 创建游戏面板
		JPanelGame jPanel = new JPanelGame(dto);
		// 创建游戏逻辑块（安装游戏数据源）
		GameService service = new GameService(dto);
		// 创建游戏控制器（连接游戏面板与游戏逻辑块）
		GameControl gameControl = new GameControl(jPanel, service);
		// 创建玩家控制器（连接游戏控制器）
		PlayerConcrol control = new PlayerConcrol(gameControl);
		// 安装玩家控制器
		jPanel.setGameControl(control);
		// 创建游戏窗口（安装游戏面板）
		new JFrameGame(jPanel);
	}
}
