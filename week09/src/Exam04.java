import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exam04 extends JFrame {

	public Exam04() {
		setTitle("��ư �׼� �̺�Ʈ ó��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		JButton btnOk = new JButton("Ok");
		JButton btnCnl = new JButton("Cancel");
		
		JPanel p_button = new JPanel(new GridLayout(0,2));
		p_button.add(btnOk); p_button.add(btnCnl);
		c.add(p_button, BorderLayout.CENTER);
		
		JLabel msg = new JLabel("�޽��� �ȳ��Դϴ�.");
		c.add(msg, BorderLayout.SOUTH);
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msg.setText("Ok ��ư�� Ŭ���Ǿ����ϴ�.");
			}
		});

		btnCnl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msg.setText("Cancel ��ư�� Ŭ���Ǿ����ϴ�.");
			}
		});
		
		setVisible(true);
		setSize(300, 130);
	}

	public static void main(String[] args) {
		new Exam04();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 4��");
	}

}
