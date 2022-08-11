import javax.swing.*;
import java.awt.*;

public class Ex9_03FlowLayoutEx extends JFrame {
	public Ex9_03FlowLayoutEx() {
		
		setTitle("FlowLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// [x]�� ������ ����
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		// �帣�� ���� ��ġ, ���� ���� 30, ���� ���� 40
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setSize(300, 200); // ���� 300, ���� 200 ũ���� â
		setVisible(true); // ���� ���̵���
	}
	
	public static void main(String[] args) {
		new Ex9_03FlowLayoutEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 6���� ���� ���� 9-3");
	}
}