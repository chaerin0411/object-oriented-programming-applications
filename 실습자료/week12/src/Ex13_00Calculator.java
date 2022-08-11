import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex13_00Calculator extends JFrame {
	String[] btnName = {"���ϱ�+", "����-", "���ϱ�*", "������/"};
	JButton[] btn    = new JButton[4];
	
	public Ex13_00Calculator() {
		setTitle("���ܰ��� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel lb = new JLabel("20202865 ������");
		
		// ���� �Է� �г�
		JPanel pnIn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField in1 = new JTextField(15);
		JPanel pnIn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField in2 = new JTextField(15);
		pnIn1.add(new JLabel("����1")); pnIn1.add(in1);
		pnIn2.add(new JLabel("����2")); pnIn2.add(in2);
		// ��ư �г�
		JPanel pnBtn = new JPanel(new GridLayout(0,1,5,5));
		// ������̺�
		JLabel lbResult = new JLabel("�����:  ");
		lbResult.setFont(new Font("Gothic", Font.BOLD, 20));
		// ��ư ���� �� �̺�Ʈ ó��
		for (int i=0; i<btnName.length; i++) {
			btn[i] = new JButton(btnName[i]);
			pnBtn.add(btn[i]);
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int num1 = Integer.parseInt(in1.getText());
					int num2 = Integer.parseInt(in2.getText());
					JButton btn = (JButton)e.getSource();
					if (btn.getText().equals("���ϱ�+")) {
						lbResult.setText("�����: "+(num1+num2));
					} else if (btn.getText().equals("����-")) {
						lbResult.setText("�����: "+(num1-num2));
					} else if (btn.getText().equals("���ϱ�*")) {
						lbResult.setText("�����: "+(num1*num2));
					} else {
						lbResult.setText("�����: "+(num1/num2));
					} lbResult.setForeground(Color.RED);
				}
			});
		}
		pnBtn.add(lbResult);
		
		c.add(lb);
		c.add(pnIn1); c.add(pnIn2);
		c.add(pnBtn);
		setSize(250, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex13_00Calculator();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 12���� ����");
	}
}
