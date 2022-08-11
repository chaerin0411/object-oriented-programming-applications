import javax.swing.*;
import java.awt.*;

public class Ex14_04ToolTipEx extends JFrame {
	private Container contentPane;
	
	public Ex14_04ToolTipEx() {
		setTitle("���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar(); //���� ����, �����ӿ� ����
		setSize(400, 200);
		setVisible(true);
	}
	
	private void createToolBar() {
		JToolBar bar = new JToolBar("Kitae Menu");
		bar.setBackground(Color.LIGHT_GRAY);
		JButton newBtn = new JButton("New");
		newBtn.setToolTipText("������ �����մϴ�.");
		bar.add(newBtn);
		
		JButton openBtn = new JButton(new ImageIcon("images/open.jpg"));
		openBtn.setToolTipText("������ ���ϴ�.");
		bar.add(openBtn);
		bar.addSeparator();
		
		JButton saveBtn = new JButton(new ImageIcon("images/save.jpg"));
		saveBtn.setToolTipText("������ �����մϴ�.");
		bar.add(saveBtn);
		
		bar.add(new JLabel("search"));
		
		JTextField tf = new JTextField("text field");
		tf.setToolTipText("ã�����ϴ� ���ڿ��� �Է��ϼ���");
		bar.add(tf);
		contentPane.add(bar, BorderLayout.NORTH);
	}
	
	public static void main(String [] args) {
		new Ex14_04ToolTipEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 10���� ���� 14-4");
	}
}