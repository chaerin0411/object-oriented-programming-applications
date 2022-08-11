import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex10_07KeyCodeEx extends JFrame {
	private JLabel la = new JLabel();
	
	public Ex10_07KeyCodeEx() {
		setTitle("Key Code 예제: F1키:초록색 %키:노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				la.setText(e.getKeyText(e.getKeyCode()));
				
				if(e.getKeyChar() == '%')
					c.setBackground(Color.YELLOW);
				else if(e.getKeyCode() == KeyEvent.VK_F1)
					c.setBackground(Color.GREEN);
			}
		});
		c.add(la);
		
		setSize(300, 150);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	
	public static void main(String [] args) {
		new Ex10_07KeyCodeEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 10-7");
	}
}