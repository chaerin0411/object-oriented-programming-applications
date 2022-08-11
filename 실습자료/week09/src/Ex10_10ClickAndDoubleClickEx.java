import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex10_10ClickAndDoubleClickEx extends JFrame {
	public Ex10_10ClickAndDoubleClickEx() {
		setTitle("Click and DoubleClick 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		setSize(300,200);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2) {
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				Component c = (Component)e.getSource();
				c.setBackground(new Color(r,b,g));
			}
		}
	}
	public static void main(String [] args) {
		new Ex10_10ClickAndDoubleClickEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 예제 10-10");
	}
}