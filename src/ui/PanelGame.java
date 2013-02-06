package ui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelGame extends JPanel{

	private static final long serialVersionUID = -4916424649169424601L;
	private Lay[] lays = null;

	public PanelGame() {
		
		 lays = new Lay[] {
				new LayBackgroung(0, 0, 0, 0),
				new LayDataBase(40, 32, 334, 279),
				new LayDisk(40, 343, 334, 279),
				new LayGame(414, 32, 334, 590),
				new layButton(788, 32, 334, 124),
				new LayNext(788, 188, 176, 148),
				new LayLevel(964, 188, 158, 148),
				new LayPoint(788, 368, 334, 200)
		};
	}
	
	public void paintComponent(Graphics g) {
		
		for (int i = 0; i < lays.length; i++) {
			lays[i].paint(g);
		}
	}
}
