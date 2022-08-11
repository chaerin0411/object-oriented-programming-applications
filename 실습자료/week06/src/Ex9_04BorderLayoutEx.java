import javax.swing.*;
import java.awt.*;

public class Ex9_04BorderLayoutEx extends JFrame{
	public Ex9_04BorderLayoutEx() {
		
		setTitle("BorderLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(30, 20));
		// �����̳ʸ� 5�������� ���� ��ġ, ���� ���� 30, ���� ���� 20
		c.add(new JButton("Calculate"), BorderLayout.CENTER); // �߾�
		c.add(new JButton("add"), BorderLayout.NORTH); // ��
		c.add(new JButton("sub"), BorderLayout.SOUTH); // �Ʒ�
		c.add(new JButton("mul"), BorderLayout.EAST); // ����
		c.add(new JButton("div"), BorderLayout.WEST); // ������
			
		setSize(300, 200); // ���� 300, ���� 200 ũ���� â
		setVisible(true); // ���� ���̵���
	}
	
	public static void main(String[] args) {
		new Ex9_04BorderLayoutEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 6���� ���� ���� 9-4");
	}
}