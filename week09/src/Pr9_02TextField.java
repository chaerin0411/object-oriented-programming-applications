import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr9_02TextField extends JFrame {
	
	public Pr9_02TextField() {
		setTitle("텍스트필드 만들기 실습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("이름"));
		JTextField tfName = new JTextField(20);
		c.add(tfName);
		c.add(new JLabel("학과"));
		JTextField tfDept = new JTextField("컴퓨터공학과", 20);
		c.add(tfDept);
		c.add(new JLabel("주소"));
		JTextField tfAddr = new JTextField("서울시 …", 20);
		c.add(tfAddr);
		
		JPanel pnBtn = new JPanel();
		JButton btnOk = new JButton("Ok");
		JButton btnCancel = new JButton("Cancel");
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inName = tfName.getText();
				String inDept = tfDept.getText();
				String inAddr = tfAddr.getText();
				System.out.println("이름: "+inName+"\n학과: "+inDept+"\n주소: "+inAddr);
			}
		});

		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfName.setText(""); tfDept.setText(""); tfAddr.setText(""); 
			}
		});
		
		pnBtn.add(btnOk);
		pnBtn.add(btnCancel);
		c.add(pnBtn);
		
		setSize(300,170);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Pr9_02TextField();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 9주차 과제 2번");
	}

}