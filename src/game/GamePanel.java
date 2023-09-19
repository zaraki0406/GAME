package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	Color backgroundColor = Color.green;
	JLabel gameLabel;
	ManLabel manLabel;
	BombLabel bombLabel;
	BombLabel bombLabel2;
	ExplosionLabel explosionLabel;
	MyKeyListener myKeyListener;
	
	GamePanel(){
		this.setLayout(null);
		this.setBackground(backgroundColor);
		
	}
	public void prepareComponents(){
		manLabel = new ManLabel();
		this.add(manLabel);
		bombLabel = new BombLabel();
		vitalizeBomb(bombLabel);
		bombLabel2 = new BombLabel();
		vitalizeBomb(bombLabel2);
		myKeyListener = new MyKeyListener(this);
		explosionLabel = new ExplosionLabel();
		this.add(explosionLabel);
	}
	public void vitalizeBomb(BombLabel b) {
		BombActionListener bombListener = new BombActionListener(b);
		b.timer = new Timer(10,bombListener);
		this.add(b);
		b.timer.start();
	}
	private class MyKeyListener implements KeyListener{
		GamePanel panel;
		MyKeyListener(GamePanel p){
			super();
			panel = p;
			p.addKeyListener(this);
		}
	
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if(manLabel.getY() > 0) {
					manLabel.setLocation(manLabel.getX(),manLabel.getY()-20);
				}
				break;
			case KeyEvent.VK_DOWN:
				if(manLabel.getY() + manLabel.ManImage.getHeight(null) < panel.getHeight()) {
					manLabel.setLocation(manLabel.getX(),manLabel.getY()+20);
				}
				break;
			case KeyEvent.VK_LEFT:
				if(manLabel.getX() > 0) {
					manLabel.setLocation(manLabel.getX()-20,manLabel.getY());
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(manLabel.getX() + manLabel.ManImage.getWidth(null) < panel.getWidth()) {
					manLabel.setLocation(manLabel.getX()+20,manLabel.getY());
				}
				break;
			}
		}
		
	}
	private class BombActionListener implements ActionListener{
		private BombLabel bomb;
		
		public BombActionListener(BombLabel b) {
			bomb = b;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(bomb.x > Main.mainWindow.gamePanel.getWidth() - bomb.getWidth()||bomb.x<0) {
				bomb.xVelocity = bomb.xVelocity *(-1);
			}
			bomb.x = bomb.x + bomb.xVelocity;
			if(bomb.y > Main.mainWindow.gamePanel.getHeight() - bomb.getHeight()||bomb.y<0) {
				bomb.yVelocity = bomb.yVelocity *(-1);
			}
			bomb.y = bomb.y + bomb.yVelocity;
			bomb.setLocation(bomb.x,bomb.y);
			bomb.repaint();
			int x1 = manLabel.getX();
			int y1 = manLabel.getY();
			int w1 = manLabel.getWidth();
			int h1 = manLabel.getHeight();
			int x2 = bomb.getX();
			int y2 = bomb.getY();
			int w2 = bomb.getWidth();
			int h2 = bomb.getHeight();
			boolean overlap = isOverlap(x1, y1, w1, h1, x2, y2, w2, h2);
			if (overlap) {
				bomb.xVelocity = 0;
				bomb.yVelocity = 0;
				manLabel.setVisible(false);
				explosionLabel.setLocation(manLabel.getX(),manLabel.getY());
				explosionLabel.setVisible(true);
				JOptionPane.showOptionDialog(
						gameLabel,
						"ゲームを終了します", 
						"GAMEOVER",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, 
						null, 
						null, 
						null);
				System.exit(0);
	        }
	    }

	    private boolean isOverlap(int x1, int y1, int w1, int h1, int x2, int y2, int w2, int h2) {
	        return x1 < (x2 + w2)-40 && (x1 + w1)-40 > x2 && y1 < (y2 + h2)-40 && (y1 + h1)-40 > y2;			
		}		
	}
	
}
