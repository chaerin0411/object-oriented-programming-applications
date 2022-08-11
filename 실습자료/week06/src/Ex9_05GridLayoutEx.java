import javax.swing.*;
import java.awt.*;

public class Ex9_05GridLayoutEx extends JFrame{
	public Ex9_05GridLayoutEx() {
		
		setTitle("GridLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(4, 2);
		// 4X2 분할의 그리드 레이아웃, 4행 2열, grid라는 객체 생성
		grid.setVgap(5); // vertical gap 설정
		Container c = getContentPane();
		
		c.setLayout(grid);
		// 이미 만들어진 객체로 레이아웃 생성
		c.add(new JLabel(" 이름"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학과"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 과목"));
		c.add(new JTextField(""));
		
		setSize(300, 200); // 가로 300, 세로 200 크기의 창
		setVisible(true); // 눈에 보이도록 출력
	}
	
	public static void main(String[] args) {
		new Ex9_05GridLayoutEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 6주차 과제 예제 9-5");
	}
}