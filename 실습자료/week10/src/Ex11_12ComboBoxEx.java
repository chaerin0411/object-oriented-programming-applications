import javax.swing.*;
import java.awt.*;

public class Ex11_12ComboBoxEx extends JFrame {
	private String [] fruits = {"apple", "banana", "kiwi", "mango", 
			"pear", "peach", "berry", "strawberry", "blackberry"};
	private String [] names = {"kitae", "jaemoon", "hyosoo", "namyun"};
	
	public Ex11_12ComboBoxEx() {
		setTitle("콤보박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox<String> strCombo = new JComboBox<String>(fruits);
		c.add(strCombo);
		
		JComboBox<String> nameCombo = new JComboBox<String>();
		for(int i=0; i<names.length; i++) {
			nameCombo.addItem(names[i]);
			c.add(nameCombo);
		}
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_12ComboBoxEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 11-12");
	}
}
