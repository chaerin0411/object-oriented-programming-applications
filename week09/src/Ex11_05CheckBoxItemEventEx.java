import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_05CheckBoxItemEventEx extends JFrame {
	private JCheckBox [] fruits = new JCheckBox[3];
	private String [] names = {"사과", "배", "체리"};
	private int[] price = {100, 500, 20000};
	private JLabel sumLabel;
	int sum = 0;
	
	public Ex11_05CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
		
		JPanel pn = new JPanel();
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			pn.add(fruits[i]);
			fruits[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					Object source = e.getItem();
					//CheckBox의 아이템 이벤트를 처리한다. (가격계산)
					if(e.getStateChange() == ItemEvent.SELECTED) {
						if(source == fruits[0])
							sum += 100;
						else if(source == fruits[1])
							sum += 500;
						else
							sum += 20000;
					}
					else {
						if(source == fruits[0])
							sum -= 100;
						else if(source == fruits[1])
							sum -= 500;
						else
							sum -= 20000;
					}
					sumLabel.setText("현재"+sum+"원 입니다.");
				}
			});
		}
		c.add(pn);
		sumLabel = new JLabel("현재 0원 입니다.");
		c.add(sumLabel);
		setSize(250, 200);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_05CheckBoxItemEventEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 9주차 예제 11-5");
	}

}
