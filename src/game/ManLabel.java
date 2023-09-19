package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ManLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	Image ManImage;
	
	ManLabel(){
		ManImage = new ImageIcon(getClass().getClassLoader().getResource("figure_hashiru (1).png")).getImage();
		this.setBounds(600,300,ManImage.getWidth(null),ManImage.getHeight(null));
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(ManImage, 0, 0, ManImage.getWidth(null), ManImage.getHeight(null), null);
	}
}
