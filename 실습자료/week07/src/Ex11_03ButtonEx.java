import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_03ButtonEx extends JFrame {
	public Ex11_03ButtonEx() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");
		
		JButton btn = new JButton("call~~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		JLabel lbText = new JLabel("메시지 : ");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 클릭했어요...");
				lbText.setText("버튼을 클릭했어요...");
			}
		});
		c.add(btn);
		c.add(lbText);
		setSize(500, 350);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Ex11_03ButtonEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 과제 예제 11-3");
	}
}