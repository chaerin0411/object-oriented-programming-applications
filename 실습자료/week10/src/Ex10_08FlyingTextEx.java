import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex10_08FlyingTextEx extends JFrame {
	private final int FLYING_UNIT = 10;
	private JLabel la = new JLabel("HELLO");
	
	public Ex10_08FlyingTextEx() {
		setTitle("상,하,좌,우키를이용하여텍스트움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(null);
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				switch(keyCode) {
					case KeyEvent.VK_UP:
						la.setLocation(la.getX(), la.getY()-FLYING_UNIT);
						break;
					case KeyEvent.VK_DOWN:
						la.setLocation(la.getX(), la.getY()+FLYING_UNIT);
						break;
					case KeyEvent.VK_LEFT:
						la.setLocation(la.getX()-FLYING_UNIT, la.getY());
						break;
					case KeyEvent.VK_RIGHT:
						la.setLocation(la.getX()+FLYING_UNIT, la.getY());
						break;
					}
				}
		});
		
		la.setLocation(50,50);
		la.setSize(100,20);
		c.add(la);
		
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Component com = (Component)e.getSource();
				com.setFocusable(true);
					com.requestFocus();
			}
		});
	}
	
	public static void main(String [] args) {
		new Ex10_08FlyingTextEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 10-8");
	}
}