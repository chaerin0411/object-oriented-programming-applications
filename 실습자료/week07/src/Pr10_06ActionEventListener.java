import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr10_06ActionEventListener extends JFrame {
	public Pr10_06ActionEventListener() {
		setTitle("�̹��� ��ư ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Hello");
		
		class MyActionListener implements ActionListener {
			private String msg;
			public MyActionListener(String msg) { this.msg = msg; }
			public void actionPerformed(ActionEvent e) { System.out.println(msg); }
		}
		
		btn.addActionListener(new MyActionListener("1"));
		btn.addActionListener(new MyActionListener("2"));
		btn.addActionListener(new MyActionListener("3"));
		
		c.add(btn);
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Pr10_06ActionEventListener();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 7���� ���� �����̷й��� 10-6");
	}
}