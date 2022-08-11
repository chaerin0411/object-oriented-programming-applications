import javax.swing.*;
import java.awt.*;

public class Ex9_03FlowLayoutEx extends JFrame {
	public Ex9_03FlowLayoutEx() {
		
		setTitle("FlowLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// [x]를 누르면 종료
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		// 흐르는 듯이 배치, 가로 간격 30, 세로 간격 40
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		
		setSize(300, 200); // 가로 300, 세로 200 크기의 창
		setVisible(true); // 눈에 보이도록
	}
	
	public static void main(String[] args) {
		new Ex9_03FlowLayoutEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 6주차 과제 예제 9-3");
	}
}