import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_07RadioButtonItemEventEx extends JFrame {

	private JRadioButton [] radio = new JRadioButton[3];
	private String [] text = {"사과", "배", "바나나"};
	private ImageIcon [] image = {
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/banana.jpg")};
	private JLabel imageLabel = new JLabel();
	
	public Ex11_07RadioButtonItemEventEx() {
		setTitle("라디오버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.GRAY);
		ButtonGroup g = new ButtonGroup();
		
		for(int i=0; i<radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.DESELECTED)
						return;
					if(radio[0].isSelected())
						imageLabel.setIcon(image[0]);
					else if(radio[1].isSelected())
						imageLabel.setIcon(image[1]);
					else
						imageLabel.setIcon(image[2]);
				}
			});
		}
		radio[2].setSelected(true);
		c.add(radioPanel, BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setSize(250,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Ex11_07RadioButtonItemEventEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 9주차 예제 11-7");
	}
	
}