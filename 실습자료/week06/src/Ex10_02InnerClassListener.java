import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// 내부 클래스로 Action 이벤트의 리스너 작성
public class Ex10_02InnerClassListener extends JFrame{
	public Ex10_02InnerClassListener() {
		
		setTitle("Action 이벤트 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn= new JButton("Action");
		btn.addActionListener(new MyActionListener()); // Action 리스너 달기
		c.add(btn);
		setSize(350, 150);
		setVisible(true);
	}
	
	// private로 선언하여 외부에서 사용할 수 없게 함
	// 리스너에서 InnerClassListener의 멤버에 대한 접근 용이
	private class MyActionListener implements ActionListener { // 새 클래스 작성
		public void actionPerformed(ActionEvent e) { // Action 이벤트 발생 시 호출됨
			// ActionListener에 있던 actionPerformed라는 추상메소드 작성
			// 객체 ActionEvent, e가 발생
			
			JButton b = (JButton)e.getSource(); // 객체 e의 이벤트소스, 버튼 "Action"을 리턴
			if(b.getText().equals("Action")) // (e.getSource()).getText() == "Action"
				b.setText("액션"); // 버튼 "Action"을 버튼 "액션"으로 변경
			else
				b.setText("Action"); // 버튼 "액션"을 버튼 "Action"으로 변경
			
			//InnerClassListener의 멤버나 JFrame의 멤버를 호출할 수 있음
			Ex10_02InnerClassListener.this.setTitle(b.getText()); // 프레임 타이틀에 버튼 문자열을 출력한다.
		}
	}
	
	public static void main(String [] args) {
		new Ex10_02InnerClassListener();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 6주차 과제 예제 10-2");
	}
}