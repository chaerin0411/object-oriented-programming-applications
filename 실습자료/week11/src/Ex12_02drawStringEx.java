import javax.swing.*;
import java.awt.*;

public class Ex12_02drawStringEx extends JFrame {

	private MyPanel panel = new MyPanel();
	public Ex12_02drawStringEx() {
		setTitle("drawString ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(250, 220);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("�ڹٴ� ��մ�~~",30,30);
			g.drawString("�󸶳�? �ϴø�ŭ ����ŭ !!!",60,60);
		}
	}

	public static void main(String[] args) {
		new Ex12_02drawStringEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 11���� ���� 12-2");
	}
}
