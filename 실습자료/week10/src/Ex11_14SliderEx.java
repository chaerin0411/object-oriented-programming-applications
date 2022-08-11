import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex11_14SliderEx extends JFrame {
	public Ex11_14SliderEx() {
		setTitle("슬라이더 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 200, 100);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(10);
		
		c.add(slider);
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_14SliderEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 11-14");
	}
}
