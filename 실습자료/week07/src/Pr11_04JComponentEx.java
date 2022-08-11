import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pr11_04JComponentEx extends JFrame {
	public Pr11_04JComponentEx() {
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Click");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 클릭하였습니다.");
				btn.setText("Clicked");
			}
		});
//		btn.setVisible(false); // 컴포넌트가 보이지 않도록 한다.
		btn.setFont(new Font("Gothic", Font.PLAIN, 20)); // 글자체를 20px의 고딕체로 한다.
		btn.setEnabled(false); // 컴포넌트가 마우스나 키보드로 입력해도 반응이 없게 한다.
		
		c.add(btn);
		setSize(400, 400);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Pr11_04JComponentEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 과제 연습이론문제 11-4");
	}
}