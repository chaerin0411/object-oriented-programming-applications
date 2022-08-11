import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_03ButtonEx extends JFrame {
	public Ex11_03ButtonEx() {
		setTitle("�̹��� ��ư ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		
		JButton btn = new JButton("call~~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		JLabel lbText = new JLabel("�޽��� : ");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư�� Ŭ���߾��...");
				lbText.setText("��ư�� Ŭ���߾��...");
			}
		});
		c.add(btn);
		c.add(lbText);
		setSize(500, 350);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Ex11_03ButtonEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 7���� ���� ���� 11-3");
	}
}