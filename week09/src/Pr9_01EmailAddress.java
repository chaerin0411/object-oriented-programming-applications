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
		
		c.add(new JLabel("이메일"));
		c.add(tfID);
		c.add(new JLabel("비밀번호"));
		c.add(tfPW);
		
		JButton btnLogin = new JButton("로그인");
		c.add(btnLogin);
		JButton btnCancel =new JButton("취소");
		c.add(btnCancel);
		
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("이메일: "+tfID.getText()+"\n비밀번호: "+tfPW.getText());
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
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 9주차 과제 1번");
	}

}