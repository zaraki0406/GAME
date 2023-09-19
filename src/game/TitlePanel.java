package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TitlePanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	JLabel title;
	JLabel start;
	JLabel exit;
	JLabel select;
	JLabel message;
	Menu checkMenu = Menu.START;
	Border border = BorderFactory.createLineBorder(Color.BLACK,2);
	MyKeyListener myKeyListener;
	
	public enum Menu{
		START,
		EXIT,
	}
	
	TitlePanel(){
		this.setLayout(null);
		this.setBackground(Color.cyan);
	}
	
	public void prepareComponents() {
		title = new JLabel();
		title.setFont(new Font("MV boil",Font.BOLD,60));
		title.setText("爆弾避けゲーム");
		title.setHorizontalTextPosition(JLabel.CENTER);
		title.setBounds(450,0,500,300);
		this.add(title);
		
		start = new JLabel();
		start.setText("START");
		start.setFont(new Font("MV boil",Font.BOLD,40));
		start.setHorizontalTextPosition(JLabel.CENTER);
		start.setVerticalTextPosition(JLabel.BOTTOM);
		start.setBounds(600,400,150,40);
		start.setBorder(border);
		
		exit = new JLabel();
		exit.setText("EXIT");
		exit.setFont(new Font("MV boil",Font.BOLD,40));
		exit.setHorizontalTextPosition(JLabel.CENTER);
		exit.setVerticalTextPosition(JLabel.BOTTOM);
		exit.setBounds(620,450,110,40);
		exit.setBorder(border);
		
		select = new JLabel();
		select.setBackground(Color.BLACK);
		select.setOpaque(true);
		select.setBounds(550,400,40,40);
		select.setBorder(border);
		
		message = new JLabel();
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setText("選択:↑,↓　　決定:SPACE");
		message.setHorizontalTextPosition(JLabel.CENTER);
		message.setVerticalTextPosition(JLabel.CENTER);
		message.setBounds(520,600,300,30);
		message.setBorder(border);
		
		this.setLayout(null);
		this.add(title);
		this.add(exit);
		this.add(start);
		this.add(select);
		this.add(message);
		
		myKeyListener = new MyKeyListener(this);
	}
	
	private class MyKeyListener implements KeyListener {
		TitlePanel panel;
		
		MyKeyListener(TitlePanel p){
			super();
			panel = p;
			panel.addKeyListener(this);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_DOWN :
				if(checkMenu == Menu.START) {
					select.setLocation(select.getX(),select.getY()+50);
					checkMenu = Menu.EXIT;
				}
				break;
			case KeyEvent.VK_UP :
				if(checkMenu == Menu.EXIT) {
					select.setLocation(select.getX(),select.getY()-50);
					checkMenu = Menu.START;
				}
				break;
			case KeyEvent.VK_SPACE :
				if(checkMenu == Menu.START) {
					Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
				}else if(checkMenu == Menu.EXIT) {
					System.exit(0);
				}
				break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	}
}
