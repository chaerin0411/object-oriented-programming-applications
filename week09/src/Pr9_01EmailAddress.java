import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr9_01EmailAddress extends JFrame {
	private JTextField tfID = new JTextField("hong@google.com",220);
	private JPasswordField tfPW = new JPasswordField("1234",20);
	
	public Pr9_01EmailAddress() {
		setTitle("LOGIN FORM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,2));
		
		c.add(new JLabel("�̸���"));
		c.add(tfID);
		c.add(new JLabel("��й�ȣ"));
		c.add(tfPW);
		
		JButton btnLogin = new JButton("�α���");
		c.add(btnLogin);
		JButton btnCancel =new JButton("���");
		c.add(btnCancel);
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�̸���: "+tfID.getText()+"\n��й�ȣ: "+tfPW.getText());
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfID.setText(""); tfPW.setText(""); 
			}
		});
		setSize(300,120);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Pr9_01EmailAddress();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 1��");
	}

}