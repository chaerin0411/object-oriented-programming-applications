import java.awt.*; // �̰��� �ʿ��� import���� �����϶�.
import javax.swing.*; // �̰��� �ʿ��� import���� �����϶�.

public class Pr9_08 extends JFrame {
	public Pr9_08() {
		Container c = getContentPane(); // ����Ʈ�� �˾Ƴ���
		c.setLayout(new FlowLayout()); // ����Ʈ�ҿ� FlowLayout ��ġ������ ����
		c.setBackground(Color.YELLOW); // ����Ʈ�� ������ ��������� ����
		c.add(new JButton("click")); // ����Ʈ�ҿ� "click" ��ư �ޱ�
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String [] args) {
		Pr9_08 frame = new Pr9_08();
	}
}