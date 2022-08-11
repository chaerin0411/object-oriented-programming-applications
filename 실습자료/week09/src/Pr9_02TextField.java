import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr9_02TextField extends JFrame {
	
	public Pr9_02TextField() {
		setTitle("�ؽ�Ʈ�ʵ� ����� �ǽ�");
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
				System.out.println("�̸�: "+inName+"\n�а�: "+inDept+"\n�ּ�: "+inAddr);
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
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 2��");
	}

}