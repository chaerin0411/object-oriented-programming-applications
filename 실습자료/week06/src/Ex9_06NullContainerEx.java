import javax.swing.*;
import java.awt.*;

public class Ex9_06NullContainerEx extends JFrame{
	public Ex9_06NullContainerEx() {
		
		setTitle("Null Container Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Container c = getContentPane();
		c.setLayout(null); // 배치관리자 제거
		
		JLabel la = new JLabel("Hello, Press Buttons!");
		la.setLocation(130, 50); // 가로 130px, 세로 50px 떨어진 곳에 위치
		la.setSize(200, 20); // 200 X 20크기
		c.add(la);
		
		for(int i=1; i<=9; i++) {
			JButton b = new JButton(Integer.toString(i)); // 버튼생성
			b.setLocation(i*15, i*15); // 가로 15ipx, 세로 15ipx 떨어진 곳에 위치
			b.setSize(50, 20); // 50 X 20 크기
			c.add(b); // 버튼을 컨텐트팬에 부착
		}
		
		setSize(300, 200); // 300 X 200 크기
		setVisible(true); // 눈에 보이게 출력
	}
	
	public static void main(String[] args) {
		new Ex9_06NullContainerEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 6주차 과제 예제 9-6");
	}
}