import javax.swing.*;
import java.awt.*;

public class Ex12_02drawStringEx extends JFrame {

	private MyPanel panel = new MyPanel();
	public Ex12_02drawStringEx() {
		setTitle("drawString 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(250, 220);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawString("자바는 재밌다~~",30,30);
			g.drawString("얼마나? 하늘만큼 땅만큼 !!!",60,60);
		}
	}

	public static void main(String[] args) {
		new Ex12_02drawStringEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 11주차 예제 12-2");
	}
}
