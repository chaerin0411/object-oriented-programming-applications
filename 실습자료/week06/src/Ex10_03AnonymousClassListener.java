import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// �͸� Ŭ������ Action �̺�Ʈ�� ������ �ۼ�
public class Ex10_03AnonymousClassListener extends JFrame{
	public Ex10_03AnonymousClassListener() {
		
		setTitle("Action �̺�Ʈ ������ �ۼ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn= new JButton("Action"); // Action ������ �ޱ�
		c.add(btn);
		
		// (Ŭ���� ���� + �ν��Ͻ� ����)�� �� ���� �ۼ�
		btn.addActionListener(new ActionListener() { // �͸� Ŭ���� �ۼ�
			public void actionPerformed(ActionEvent e) { // Action �̺�Ʈ �߻� �� ȣ���
				// ActionListener�� �ִ� actionPerformed��� �߻�޼ҵ� �ۼ�
				// ��ü ActionEvent, e�� �߻�

				JButton b = (JButton)e.getSource(); // ��ü e�� �̺�Ʈ�ҽ�, ��ư "Action"�� ����
				if(b.getText().equals("Action")) // (e.getSource()).getText() == "Action"
					b.setText("�׼�"); // ��ư "Action"�� ��ư "�׼�"���� ����
				else
					b.setText("Action"); // ��ư "�׼�"�� ��ư "Action"���� ����
				
				setTitle(b.getText()); // ������ Ÿ��Ʋ�� ��ư ���ڿ��� ����Ѵ�.
				// InnerClassListener.this.setTitle(b.getText()); - InnerClassListener�� ���
			}
		});
		
		setSize(350, 150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex10_03AnonymousClassListener();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 6���� ���� ���� 10-3");
	}
}