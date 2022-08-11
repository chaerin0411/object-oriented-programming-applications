import javax.swing.*;
import java.awt.*;

public class Ex9_06NullContainerEx extends JFrame{
	public Ex9_06NullContainerEx() {
		
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Container c = getContentPane();
		c.setLayout(null); // ��ġ������ ����
		
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50); // ���� 130px, ���� 50px ������ ���� ��ġ
		la.setSize(200, 20); // 200 X 20ũ��
		c.add(la);
		
		for(int i=1; i<=9; i++) {
			JButton b = new JButton(Integer.toString(i)); // ��ư����
			b.setLocation(i*15, i*15); // ���� 15ipx, ���� 15ipx ������ ���� ��ġ
			b.setSize(50, 20); // 50 X 20 ũ��
			c.add(b); // ��ư�� ����Ʈ�ҿ� ����
		}
		
		setSize(300, 200); // 300 X 200 ũ��
		setVisible(true); // ���� ���̰� ���
	}
	
	public static void main(String[] args) {
		new Ex9_06NullContainerEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 6���� ���� ���� 9-6");
	}
}