import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exam01 extends JFrame {

	public Exam01() {
		setTitle("2020001ȫ�浿");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton btn1 = new JButton("���");
		JButton btn2 = new JButton("����");
		JButton btn3 = new JButton("�Ķ�");
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBackground(Color.YELLOW);
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBackground(Color.RED);
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBackground(Color.BLUE);
			}
		});
		
		JPanel p_button = new JPanel();
		p_button.add(btn1); p_button.add(btn2); p_button.add(btn3);
		c.add(p_button, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(350, 150);
	}

	public static void main(String[] args) {
		new Exam01();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 1��");
	}

}
