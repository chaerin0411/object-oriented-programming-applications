import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exam01 extends JFrame {

	public Exam01() {
		setTitle("2020001È«±æµ¿");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JButton btn1 = new JButton("³ë¶û");
		JButton btn2 = new JButton("»¡°­");
		JButton btn3 = new JButton("ÆÄ¶û");
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBackground(Color.YELLOW);
			}
		});
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBackground(Color.RED);
			}
		});
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setBackground(Color.BLUE);
			}
		});
		
		JPanel p_button = new JPanel();
		p_button.add(btn1); p_button.add(btn2); p_button.add(btn3);
		c.add(p_button, BorderLayout.SOUTH);
		
		setVisible(true);
		setSize(350, 150);
	}

	public static void main(String[] args) {
		new Exam01();
		System.out.println("YA 20202865 ¾öÁöÈñ");
		System.out.println("°´Ã¼ÁöÇâÇÁ·Î±×·¡¹Ö ÀÀ¿ë 9ÁÖÂ÷ ¿¹Á¦ 1¹ø");
	}

}
