import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr11_03JLabelEx extends JFrame {
	public Pr11_03JLabelEx() {
		setTitle("�̹��� ��ư ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon icon = new ImageIcon("images/beauty.jpg"); // beauty.jpg ������ �ε��Ѵ�.
		JLabel label = new JLabel(); // �� JLabel ������Ʈ�� �����Ѵ�.
		label.setIcon(icon); // �̹����� ���̺� �����Ѵ�.
		
		c.add(label);
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Pr11_03JLabelEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 7���� ���� �����̷й��� 11-3");
	}
}