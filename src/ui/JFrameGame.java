package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame {

	private static final long serialVersionUID = -6194695820531427582L;

	public JFrameGame(JPanelGame panelGame) {
		
		// 获得游戏配置
		GameConfig cfg = ConfigFactory.getGameConfig();
		// 设置窗口标题
		this.setTitle(cfg.getTitle());
		// 设置默认关闭属性（程序结束）
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗口大小
		this.setSize(cfg.getWidth(), cfg.getHeight());
		// 不允许用户改变窗口大小
		this.setResizable(false);
		// 窗口居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = screen.width - this.getWidth() >> 1;
		int y = (screen.height - this.getHeight() >> 1) - cfg.getWindowUp();
		this.setLocation(x, y);
		// 设置默认Panel
		this.setContentPane(panelGame);
		// 设置该窗口默认显示
		this.setVisible(true);
	}
}
