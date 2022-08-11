import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// ���� Ŭ������ Action �̺�Ʈ�� ������ �ۼ�
public class Ex10_02InnerClassListener extends JFrame{
	public Ex10_02InnerClassListener() {
		
		setTitle("Action �̺�Ʈ ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn= new JButton("Action");
		btn.addActionListener(new MyActionListener()); // Action ������ �ޱ�
		c.add(btn);
		setSize(350, 150);
		setVisible(true);
	}
	
	// private�� �����Ͽ� �ܺο��� ����� �� ���� ��
	// �����ʿ��� InnerClassListener�� ����� ���� ���� ����
	private class MyActionListener implements ActionListener { // �� Ŭ���� �ۼ�
		public void actionPerformed(ActionEvent e) { // Action �̺�Ʈ �߻� �� ȣ���
			// ActionListener�� �ִ� actionPerformed��� �߻�޼ҵ� �ۼ�
			// ��ü ActionEvent, e�� �߻�
			
			JButton b = (JButton)e.getSource(); // ��ü e�� �̺�Ʈ�ҽ�, ��ư "Action"�� ����
			if(b.getText().equals("Action")) // (e.getSource()).getText() == "Action"
				b.setText("�׼�"); // ��ư "Action"�� ��ư "�׼�"���� ����
			else
				b.setText("Action"); // ��ư "�׼�"�� ��ư "Action"���� ����
			
			//InnerClassListener�� ����� JFrame�� ����� ȣ���� �� ����
			Ex10_02InnerClassListener.this.setTitle(b.getText()); // ������ Ÿ��Ʋ�� ��ư ���ڿ��� ����Ѵ�.
		}
	}
	
	public static void main(String [] args) {
		new Ex10_02InnerClassListener();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 6���� ���� ���� 10-2");
	}
}