import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_08TextFieldEx extends JFrame {

	public Ex11_08TextFieldEx() {
		setTitle("�ؽ�Ʈ�ʵ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("�̸�"));
		JTextField tfName = new JTextField(20);
		c.add(tfName);
		c.add(new JLabel("�а�"));
		JTextField tfDept = new JTextField("��ǻ�Ͱ��а�", 20);
		c.add(tfDept);
		c.add(new JLabel("�ּ�"));
		JTextField tfAddr = new JTextField("����� ��", 20);
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
				System.out.println("Ok ��ư�� �������� "+inName+" "+inDept+" "+inAddr);
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
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 11-8");
	}

}