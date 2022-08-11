import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr10_03AnonymousClass extends JFrame {
	public Pr10_03AnonymousClass() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Hello");
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Click");
			}
		});
		
		c.add(btn);
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Pr10_03AnonymousClass();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 과제 연습이론문제 10-3");
	}
}