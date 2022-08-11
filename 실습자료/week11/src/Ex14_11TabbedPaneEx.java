import javax.swing.*;
import java.awt.*;

public class Ex14_11TabbedPaneEx extends JFrame {

	public Ex14_11TabbedPaneEx() {
		setTitle("탭팬 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT);
		pane.addTab("tab1", new JLabel(new ImageIcon("images/img1.jpg")));
		pane.addTab("tab2", new JLabel(new ImageIcon("images/img2.jpg")));
		pane.addTab("망고", new JLabel(new ImageIcon("images/img3.jpg")));
		
		c.add(pane, BorderLayout.CENTER);
		setSize(250, 250);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex14_11TabbedPaneEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 11주차 예제 14-11");
	}
}