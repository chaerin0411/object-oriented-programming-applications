import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_08TextFieldEx extends JFrame {

	public Ex11_08TextFieldEx() {
		setTitle("텍스트필드 만들기 예제");
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
				System.out.println("Ok 버튼이 눌러짐… "+inName+" "+inDept+" "+inAddr);
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
		
		setSize(300,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex11_08TextFieldEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 9주차 예제 11-8");
	}

}