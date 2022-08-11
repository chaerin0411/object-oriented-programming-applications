import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class Ex11_15SliderChangeEx extends JFrame {
	private JLabel colorLabel;
	private JSlider [] sl = new JSlider [3];
	
	public Ex11_15SliderChangeEx() {
		setTitle("슬라이더와 ChangeEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		colorLabel = new JLabel(" SLIDER EXAMPLE ");
		for(int i=0; i<sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int r = sl[0].getValue();
					int g = sl[1].getValue();
					int b = sl[2].getValue();
					colorLabel.setBackground(new Color(r,g,b));
				}
			});
			c.add(sl[i]);
		}
		sl[0].setForeground(Color.RED);
		sl[1].setForeground(Color.GREEN);
		sl[2].setForeground(Color.BLUE);
		
		int r = sl[0].getValue();
		int g = sl[1].getValue();
		int b = sl[2].getValue();
		
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(r,g,b));
		c.add(colorLabel);
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_15SliderChangeEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 11-15");
	}
}