import java.awt.*; // 이곳에 필요한 import문을 삽입하라.
import javax.swing.*; // 이곳에 필요한 import문을 삽입하라.

public class Pr9_08 extends JFrame {
	public Pr9_08() {
		Container c = getContentPane(); // 컨텐트팬 알아내기
		c.setLayout(new FlowLayout()); // 컨텐트팬에 FlowLayout 배치관리자 설정
		c.setBackground(Color.YELLOW); // 컨텐트팬 배경색을 노란색으로 설정
		c.add(new JButton("click")); // 컨텐트팬에 "click" 버튼 달기
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String [] args) {
		Pr9_08 frame = new Pr9_08();
	}
}