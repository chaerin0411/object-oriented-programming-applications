import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr11_04JComponentEx extends JFrame {
	public Pr11_04JComponentEx() {
		setTitle("�̹��� ��ư ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Click");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư�� Ŭ���Ͽ����ϴ�.");
				btn.setText("Clicked");
			}
		});
//		btn.setVisible(false); // ������Ʈ�� ������ �ʵ��� �Ѵ�.
		btn.setFont(new Font("Gothic", Font.PLAIN, 20)); // ����ü�� 20px�� ���ü�� �Ѵ�.
		btn.setEnabled(false); // ������Ʈ�� ���콺�� Ű����� �Է��ص� ������ ���� �Ѵ�.
		
		c.add(btn);
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Pr11_04JComponentEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 7���� ���� �����̷й��� 11-4");
	}
}