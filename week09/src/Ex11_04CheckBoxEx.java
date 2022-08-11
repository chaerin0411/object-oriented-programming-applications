import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_04CheckBoxEx extends JFrame {
	//수업 때는 그냥 후루룩 넘어감
	public Ex11_04CheckBoxEx() {
		setTitle("체크박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배", true);
		JCheckBox cherry = new JCheckBox("체리", cherryIcon);
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);
		
		c.add(apple); c.add(pear); c.add(cherry);
		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_04CheckBoxEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 9주차 예제 11-4");
	}

}