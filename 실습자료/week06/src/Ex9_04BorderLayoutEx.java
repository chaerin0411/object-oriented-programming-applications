import javax.swing.*;
import java.awt.*;

public class Ex9_04BorderLayoutEx extends JFrame{
	public Ex9_04BorderLayoutEx() {
		
		setTitle("BorderLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new BorderLayout(30, 20));
		// 컨테이너를 5구역으로 나눠 배치, 가로 간격 30, 세로 간격 20
		c.add(new JButton("Calculate"), BorderLayout.CENTER); // 중앙
		c.add(new JButton("add"), BorderLayout.NORTH); // 위
		c.add(new JButton("sub"), BorderLayout.SOUTH); // 아래
		c.add(new JButton("mul"), BorderLayout.EAST); // 왼쪽
		c.add(new JButton("div"), BorderLayout.WEST); // 오른쪽
			
		setSize(300, 200); // 가로 300, 세로 200 크기의 창
		setVisible(true); // 눈에 보이도록
	}
	
	public static void main(String[] args) {
		new Ex9_04BorderLayoutEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 6주차 과제 예제 9-4");
	}
}