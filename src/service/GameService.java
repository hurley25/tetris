package service;

import dto.GameDto;

public class GameService {
	
	private GameDto dto;

	public GameService(GameDto dto) {
		this.dto = dto;
	}

	public void gameTest() {
		int tmp = dto.getNowPoint();
		dto.setNowPoint(tmp+1);
	}
}
