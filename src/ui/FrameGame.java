package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameGame extends JFrame {

	private static final long serialVersionUID = -6194695820531427582L;

	public FrameGame() {
		this.setTitle("Java¶íÂÞË¹·½¿é");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1162, 680);
		this.setResizable(false);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		this.setLocation((screen.width - this.getWidth()) / 2, (screen.height - this.getHeight()) / 2 - 32);
		this.setContentPane(new PanelGame());
	}
}
