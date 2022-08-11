import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr11_03JLabelEx extends JFrame {
	public Pr11_03JLabelEx() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon icon = new ImageIcon("images/beauty.jpg"); // beauty.jpg 파일을 로딩한다.
		JLabel label = new JLabel(); // 빈 JLabel 컴포넌트를 생성한다.
		label.setIcon(icon); // 이미지를 레이블에 부착한다.
		
		c.add(label);
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Pr11_03JLabelEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 과제 연습이론문제 11-3");
	}
}