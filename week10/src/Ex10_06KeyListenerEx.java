import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex10_06KeyListenerEx extends JFrame {
	private JLabel [] keyMessage;
	
	public Ex10_06KeyListenerEx() {
		setTitle("keyListener 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode= e.getKeyCode();
				char keyChar= e.getKeyChar();
				
				keyMessage[0].setText(Integer.toString(keyCode));
				keyMessage[1].setText(Character.toString(keyChar));
				keyMessage[2].setText(e.getKeyText(keyCode));
			}
		});
		
		keyMessage = new JLabel [3];
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyText() ");
		
		for(int i=0; i<keyMessage.length; i++) {
			c.add(keyMessage[i]);
			keyMessage[i].setOpaque(true); //컴포넌트 불투명하게
			keyMessage[i].setBackground(Color.YELLOW);
		}
		
		setSize(300,150);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	
	public static void main(String [] args) {
		new Ex10_06KeyListenerEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 10-6");
	}
}