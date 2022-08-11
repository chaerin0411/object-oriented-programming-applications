import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex10_04MouseListenerEx extends JFrame {
	private JLabel la = new JLabel("Hello");
	
	public Ex10_04MouseListenerEx() {
		setTitle("Mouse 이벤트예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		c.setLayout(null);
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);
		setSize(250, 250);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener {
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x, y);
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	public static void main(String [] args) {
		new Ex10_04MouseListenerEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 예제 10-4");
	}
}