import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ex11_14SliderEx extends JFrame {
	public Ex11_14SliderEx() {
		setTitle("�����̴� ����� ����");
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
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 10���� ���� 11-14");
	}
}
