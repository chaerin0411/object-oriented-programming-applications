import java.awt.*;
import javax.swing.*;

public class Ex11_02LabelEx extends JFrame {
	public Ex11_02LabelEx() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("사랑합니다."); // 단순 텍스트 레이블
		
		ImageIcon beauty = new ImageIcon("images/beauty.jpg");
		JLabel imageLabel = new JLabel(beauty); // 이미지를 가진 레이블
		
		ImageIcon caution = new ImageIcon("images/caution.gif");
		JLabel label = new JLabel("보고싶으면 전화하세요", caution, SwingConstants.CENTER);
		// 텍스트와 이미지를 모두 가진 레이블 생성
		
		c.add(textLabel); c.add(imageLabel); c.add(label);
		
		setSize(400, 600);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_02LabelEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 과제 예제 11-2");
	}
}