import java.awt.*;
import javax.swing.*;

public class Ex11_02LabelEx extends JFrame {
	public Ex11_02LabelEx() {
		setTitle("���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("����մϴ�."); // �ܼ� �ؽ�Ʈ ���̺�
		
		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty); // �̹����� ���� ���̺�
		
		ImageIcon caution = new ImageIcon("images/caution.gif");
		JLabel label = new JLabel("��������� ��ȭ�ϼ���", caution, SwingConstants.CENTER);
		// �ؽ�Ʈ�� �̹����� ��� ���� ���̺� ����
		
		c.add(textLabel); c.add(imageLabel); c.add(label);
		
		setSize(400, 600);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_02LabelEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 7���� ���� ���� 11-2");
	}
}