import javax.swing.*;
import java.awt.*;
public class Ex9_02ContentPaneEx extends JFrame {
	public Ex9_02ContentPaneEx() {
		setTitle("ContentPane과 JFrame"); // (this.)가 생략됨
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// [x]를 눌렀을 때 전체 시스템 종료
		// EXIT_ON_CLOSE는 상수
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE); // ORANGE는 상수
		contentPane.setLayout(new FlowLayout());
		// 흐르는 대로 배치
		// css로 따지자면 display: inline(?)
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		JLabel la = new JLabel("동양미래대학교");
		contentPane.add(la);
		// contentPane.add(new JLabel("Hello World"));
		
		setSize(300, 150);
		setVisible(true);
		// 눈에 보이도록
	}
	public static void main(String[] args) {
		new Ex9_02ContentPaneEx();

		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 5주차 과제 예제 9-2");
	}
}