package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	
	private int windowUp;
	private int width;
	private int height;
	private int padding;
	private int windowSize;
	private String title;
	
	private List<LayerConfig> layersConfig;
	
	public static void main(String[] args) {
		ConfigFactory.getGameConfig();
	}
	
	/*
	 * 读取全部游戏配置
	 */
	public GameConfig() throws DocumentException {
		// 创建XML读取器
		SAXReader reader = new SAXReader();
		// 读取XML文件
		Document doc = reader.read("config/cfg.xml");
		// 获取XML文件的根节点
		Element game = doc.getRootElement();
		// 配置窗口参数
		this.setUiConfig(game.element("frame"));
		// 配置系统参数
		this.setSystemConfig(game.element("system"));
		// 配置数据访问参数
		this.setDataConfig(game.element("data"));
	}

	@SuppressWarnings("unchecked")
	private void setUiConfig(Element frame) {
		
		// 获取窗口标题
		this.title = frame.attributeValue("title");
		// 获取窗口拔高
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
		// 获取窗口宽度
		this.width = Integer.parseInt(frame.attributeValue("width"));
		// 获取窗口高度
		this.height = Integer.parseInt(frame.attributeValue("height"));
		// 获取边框内边距
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		// 获取窗口粗细
		this.windowSize = Integer.parseInt(frame.attributeValue("windowSize"));
		
		// 获取窗体属性
		List<Element> layers = frame.elements("layer");
		layersConfig = new ArrayList<LayerConfig>();
		for (Element layer : layers) {
			LayerConfig lc = new LayerConfig(
					layer.attributeValue("className"),	
					Integer.parseInt(layer.attributeValue("x")),
					Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")),
					Integer.parseInt(layer.attributeValue("h")) );
			layersConfig.add(lc);
		}
	}
	
	public int getWindowUp() {
		return windowUp;
	}
	
	public String getTitle() {
		return title;
	}

	private void setDataConfig(Element element) {
		// 自动生成的方法存根
		
	}

	private void setSystemConfig(Element element) {
		// 自动生成的方法存根
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getPadding() {
		return padding;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}
}
