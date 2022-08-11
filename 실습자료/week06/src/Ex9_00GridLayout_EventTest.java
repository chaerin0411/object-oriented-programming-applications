import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex9_00GridLayout_EventTest extends JFrame{
	public Ex9_00GridLayout_EventTest() {
		
		setTitle("GridLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(6, 2);
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
		
		JButton btnOk = new JButton("�Է�");
		JButton btnCancel = new JButton("���");
		JLabel lblMessage = new JLabel("msg : ");
		c.add(btnOk);
		c.add(btnCancel);
		c.add(lblMessage);
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("�Է� ��ư ����...");
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("��� ��ư ����...");
				System.out.println("��� ��ư�� ���������...");
			}
		});
		
		setSize(300, 200); // ���� 300, ���� 200 ũ���� â
		setVisible(true); // ���� ���̵��� ���
	}
	
	public static void main(String[] args) {
		new Ex9_00GridLayout_EventTest();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 6���� ���� ���� 9-5 ����");
	}
}