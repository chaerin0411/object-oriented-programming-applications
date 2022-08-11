import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPanel extends JFrame {
	private static final long serialVersionUID = 1L;
	public MenuPanel() {
		setTitle("이미지 갤러리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		ImageIcon spring = new ImageIcon("images/spring.png");
		ImageIcon summer = new ImageIcon("images/summer.png");
		ImageIcon fall = new ImageIcon("images/fall.png");
		ImageIcon winter = new ImageIcon("images/winter.png");
		ImageIcon[] icon = {spring, summer, fall, winter};
		
		JLabel img = new JLabel(icon[0]);
		
		ImageIcon left_arrow = new ImageIcon("images/left_arrow.png");
		ImageIcon right_arrow = new ImageIcon("images/right_arrow.png");
		
		JButton larw = new JButton(left_arrow);
		JButton rarw = new JButton(right_arrow);
		larw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i;
				ImageIcon ic = (ImageIcon)img.getIcon();
				if (ic == spring) i=0;
				else if (ic == summer) i=1;
				else if (ic == fall) i=2;
				else i=3;
				i--;
				i%=4;
				if (i < 0) i+=4;
				img.setIcon(icon[i]);
			}
		});
		rarw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i;
				ImageIcon ic = (ImageIcon)img.getIcon();
				if (ic == spring) i=0;
				else if (ic == summer) i=1;
				else if (ic == fall) i=2;
				else i=3;
				i++;
				i%=4;
				if (i < 0) i+=4;
				img.setIcon(icon[i]);
			}
		});
		
		c.add(img, BorderLayout.CENTER);
		c.add(larw, BorderLayout.WEST);
		c.add(rarw, BorderLayout.EAST);
		setSize(480, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MenuPanel();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 과제 11장 OpenChallenge");
	}
}