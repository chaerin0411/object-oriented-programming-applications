import javax.swing.*;
import java.awt.*;

public class Ex14_05ToolTipDelayEx extends JFrame {
	public Ex14_05ToolTipDelayEx() {
		setTitle("���� �����ð� ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel cherryLabel = new JLabel(new
				ImageIcon("images/cherry.jpg"));
		cherryLabel.setToolTipText("ü�� �̹��� ���");
		JLabel appleLabel = new JLabel(new
				ImageIcon("images/apple.jpg"));
		appleLabel.setToolTipText("��� �̹��� ���");
		c.add(cherryLabel);
		c.add(appleLabel);
		
		ToolTipManager m = ToolTipManager.sharedInstance();
		m.setInitialDelay(0);
		m.setDismissDelay(10000);
		
		setSize(400, 200);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Ex14_05ToolTipDelayEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 10���� ���� 14-5");
	}
}