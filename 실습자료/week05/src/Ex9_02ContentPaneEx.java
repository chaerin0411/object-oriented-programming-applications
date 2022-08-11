import javax.swing.*;
import java.awt.*;
public class Ex9_02ContentPaneEx extends JFrame {
	public Ex9_02ContentPaneEx() {
		setTitle("ContentPane�� JFrame"); // (this.)�� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// [x]�� ������ �� ��ü �ý��� ����
		// EXIT_ON_CLOSE�� ���
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE); // ORANGE�� ���
		contentPane.setLayout(new FlowLayout());
		// �帣�� ��� ��ġ
		// css�� �����ڸ� display: inline(?)
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		JLabel la = new JLabel("����̷����б�");
		contentPane.add(la);
		// contentPane.add(new JLabel("Hello World"));
		
		setSize(300, 150);
		setVisible(true);
		// ���� ���̵���
	}
	public static void main(String[] args) {
		new Ex9_02ContentPaneEx();

		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 5���� ���� ���� 9-2");
	}
}