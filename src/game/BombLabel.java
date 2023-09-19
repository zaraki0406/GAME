package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class BombLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	
	Image bombImage;
	int x;
	int y;
	int xVelocity;
	int yVelocity;
	Timer timer = null;
	
	BombLabel(){
		bombImage = new ImageIcon(getClass().getClassLoader().getResource("bakudan (1).png")).getImage();
		
		this.setSize(bombImage.getWidth(null),bombImage.getHeight(null));
		
		x = new java.util.Random().nextInt(Main.mainWindow.gamePanel.getWidth() - this.getWidth());
		y = new java.util.Random().nextInt(Main.mainWindow.gamePanel.getHeight() - this.getHeight());
		xVelocity = -5 + new java.util.Random().nextInt(11);
		yVelocity = -5 + new java.util.Random().nextInt(11);
		this.setLocation(x,y);
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(bombImage, 0, 0, bombImage.getWidth(null),bombImage.getHeight(null),null);
	}
	
}
