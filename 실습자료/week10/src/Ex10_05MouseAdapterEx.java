import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex10_05MouseAdapterEx extends JFrame {
	private JLabel la = new JLabel("Hello");
	
	public Ex10_05MouseAdapterEx() {
		setTitle("Mouse �̺�Ʈ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				la.setLocation(x, y);
			}
		});
		c.setLayout(null);
		
		la.setSize(50, 20);
		la.setLocation(30, 30);
		c.add(la);
		
		setSize(250, 250);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex10_05MouseAdapterEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 10���� ���� 10-5");
	}
}