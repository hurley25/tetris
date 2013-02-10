package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.PlayerConcrol;
import dto.GameDto;

public class JPanelGame extends JPanel{

	private static final long serialVersionUID = -4916424649169424601L;
	private List<Layer> layers = null;
	public GameDto dto = null;
	
	public JPanelGame(GameDto dto) {
		
		// 获得dto对象
		this.dto = dto;
		// 初始化组件
		initComponent();
		// 初始化层
		initLayer();
	}
	
	/*
	 * 安装玩家控制器
	 */
	public void setGameControl(PlayerConcrol control) {
		this.addKeyListener(control);
	}
	
	/*
	 * 初始化组件
	 */
	public void initComponent() {

	}
	
	/*
	 * 初始化层
	 */
	public void initLayer() {
		try {
			// 获得游戏配置
			GameConfig cfg = ConfigFactory.getGameConfig();
			// 获得层配置
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
			// 创建游戏层数组
			layers = new ArrayList<Layer>();
			// 创建所有层对象
			for (LayerConfig layerCfg : layersCfg) {
				// 获得类对象
				Class<?> cls = Class.forName(layerCfg.getClassName());
				// 获得构造函数
				Constructor<?> ctr = cls.getConstructor(int.class, int.class, int.class, int.class);
				// 调用构造函数创建对象
				Layer layer = (Layer)ctr.newInstance(
						layerCfg.getX(), layerCfg.getY(), layerCfg.getW(), layerCfg.getH()
						);
				// 设置游戏数据对象
				layer.setDto(this.dto);
				// 把构造的Layer对象加入列表
				layers.add(layer);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		// 调用基类方法
		super.paintComponent(g);
		for (Layer layer : layers) {
			layer.paint(g);
		}
		// 返回焦点
		this.requestFocus();
	}
}
