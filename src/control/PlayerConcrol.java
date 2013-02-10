package control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PlayerConcrol extends KeyAdapter{
	
	private GameControl gameControl;
	
	public PlayerConcrol(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	
	/*
	 * 键盘按下消息
	 * @see java.awt.event.KeyAdapter#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			this.gameControl.keyUp();
			break;
		case KeyEvent.VK_DOWN:
			this.gameControl.keyDown();
			break;
		case KeyEvent.VK_LEFT:
			this.gameControl.keyLeft();
			break;
		case KeyEvent.VK_RIGHT:
			this.gameControl.keyRight();
			break;
		default:
			break;
		}
	}
}
