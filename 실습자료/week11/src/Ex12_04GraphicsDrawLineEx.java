import javax.swing.*;
import java.awt.*;

public class Ex12_04GraphicsDrawLineEx extends JFrame {

	private MyPanel panel = new MyPanel();
	public Ex12_04GraphicsDrawLineEx() {
		setTitle("drawLine 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(200, 170);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.RED); //빨간색 선택 
			g.drawLine(20,20,100,100); //선그리기
		}
	}

	public static void main(String[] args) {
		new Ex12_04GraphicsDrawLineEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 11주차 예제 12-4");
	}
}