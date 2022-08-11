import javax.swing.*;
import java.awt.*;

public class Ex9_05GridLayoutEx extends JFrame{
	public Ex9_05GridLayoutEx() {
		
		setTitle("GridLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(4, 2);
		// 4X2 ������ �׸��� ���̾ƿ�, 4�� 2��, grid��� ��ü ����
		grid.setVgap(5); // vertical gap ����
		Container c = getContentPane();
		
		c.setLayout(grid);
		// �̹� ������� ��ü�� ���̾ƿ� ����
		c.add(new JLabel(" �̸�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �й�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" �а�"));
		c.add(new JTextField(""));
		c.add(new JLabel(" ����"));
		c.add(new JTextField(""));
		
		setSize(300, 200); // ���� 300, ���� 200 ũ���� â
		setVisible(true); // ���� ���̵��� ���
	}
	
	public static void main(String[] args) {
		new Ex9_05GridLayoutEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 6���� ���� ���� 9-5");
	}
}