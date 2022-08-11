import javax.swing.*;
import java.awt.*;

public class Ex12_01paintJPanelEx extends JFrame {

	private MyPanel panel = new MyPanel();
	public Ex12_01paintJPanelEx() {
		setTitle("JPanel�� paintComponent() ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(250, 220);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10, 10, 50, 50);
			g.drawRect(50, 50, 50, 50);
			g.setColor(Color.MAGENTA);
			g.drawRect(90, 90, 50, 50);
		}
	}

	public static void main(String[] args) {
		new Ex12_01paintJPanelEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 11���� ���� 12-1");
	}
}
