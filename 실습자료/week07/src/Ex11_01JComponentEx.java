import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_01JComponentEx extends JFrame {
	public Ex11_01JComponentEx() {
		super("JComponent�� ���� �޼ҵ� ����"); // ���� ����
		Container c = getContentPane(); // ����Ʈ�� �߰�
		c.setLayout(new FlowLayout()); // FlowLayout���� ����
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton("Disabled Button");
		JButton b3 = new JButton("getX(), getY()");
		
		b1.setBackground(Color.YELLOW); // ���� ����
		b1.setForeground(Color.MAGENTA); // ���ڻ� ����
		b1.setFont(new Font("Arial", Font.ITALIC, 20)); // Arial, 20�ȼ� ��Ʈ ����
		b2.setEnabled(false); // ��ư ��Ȱ��ȭ
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				Ex11_01JComponentEx frame = (Ex11_01JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX() + "," + b.getY()); // Ÿ��Ʋ�� ��ư ��ǥ ���
				System.out.println("��ư3�� Ŭ���߾��. " + b.getText() + " ����: " + b.getHeight() + ", ����: " + b.getWidth());
				b.setText("��ư3");
			}
		});
		c.add(b1); c.add(b2); c.add(b3);
		setSize(250, 200);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Ex11_01JComponentEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 7���� ���� ���� 11-1");
	}
}