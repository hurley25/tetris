package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame {

	private static final long serialVersionUID = -6194695820531427582L;

	public JFrameGame() {
		this.setTitle("Java俄罗斯方块");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 获得游戏配置
		GameConfig cfg = ConfigFactory.getGameConfig();
		this.setSize(cfg.getWidth(), cfg.getHeight());
		this.setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		this.setLocation((screen.width - this.getWidth()) / 2, (screen.height - this.getHeight()) / 2 - 32);
		this.setContentPane(new JPanelGame());
	}
}
