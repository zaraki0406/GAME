package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExplosionLabel extends JLabel{
	private static final long serialVersionUID = 1L;
	Image ExplosionImage;
	
	ExplosionLabel(){
		ExplosionImage = new ImageIcon(getClass().getClassLoader().getResource("bakuhatsu (1) (1).png")).getImage();
		this.setBounds(100,100,ExplosionImage.getWidth(null),ExplosionImage.getHeight(null));
		setVisible(false);
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(ExplosionImage, 0, 0, ExplosionImage.getWidth(null), ExplosionImage.getHeight(null), null);
	}
}
