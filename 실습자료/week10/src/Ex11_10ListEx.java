import javax.swing.*;
import java.awt.*;

public class Ex11_10ListEx extends JFrame {
	private String [] fruits = {"apple", "banana", "kiwi", "mango", 
			"pear", "peach", "berry", "strawberry", "blackberry"};
	private ImageIcon [] images = {
			new ImageIcon("images/icon1.png"),
			new ImageIcon("images/icon2.png"),
			new ImageIcon("images/icon3.png"),
			new ImageIcon("images/icon4.png")};
	public Ex11_10ListEx() {
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JList<String> strList = new JList<String>(fruits);
		c.add(strList);
		
		JList<ImageIcon> imageList = new JList<ImageIcon>();
		imageList.setListData(images);
		c.add(imageList);
		
		JList<String> scrollList = new JList<String>(fruits);
		c.add(new JScrollPane(scrollList));
		
		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Ex11_10ListEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 11-10");
	}
}