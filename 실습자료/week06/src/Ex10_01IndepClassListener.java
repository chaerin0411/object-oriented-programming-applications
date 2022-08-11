import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// 독립 클래스로 Action 이벤트의 리스너 작성
public class Ex10_01IndepClassListener extends JFrame {
	public Ex10_01IndepClassListener() {
		
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn= new JButton("Action");
		btn.addActionListener(new MyActionListener()); // Action 리스너달기
		c.add(btn);
		setSize(350, 150);
		setVisible(true);
	}

	public static void main(String [] args) {
		new Ex10_01IndepClassListener();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 6주차 과제 예제 10-1");
	}
}

// MyActionListener.java 파일로 작성하여도 됨
class MyActionListener implements ActionListener { // 새 클래스 작성
	public void actionPerformed(ActionEvent e) { // Action 이벤트 발생 시 호출됨
		// ActionListener에 있던 actionPerformed라는 추상메소드 작성
		// 객체 ActionEvent, e가 발생
		
		JButton b = (JButton)e.getSource(); // 객체 e의 이벤트소스, 버튼 "Action"을 리턴
		if(b.getText().equals("Action")) // (e.getSource()).getText() == "Action"
			b.setText("액션"); // 버튼 "Action"을 버튼 "액션"으로 변경
		else
			b.setText("Action"); // 버튼 "액션"을 버튼 "Action"으로 변경
	}
}