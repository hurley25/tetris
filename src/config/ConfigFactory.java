package config;

import org.dom4j.DocumentException;

public class ConfigFactory {
	
	private static GameConfig GAME_CONFIG = null;
	
	static {
		try {
			GAME_CONFIG = new GameConfig();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static GameConfig getGameConfig() {
		return GAME_CONFIG;
	}
}
