import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageGallery extends JFrame {
	int i = 0;
	private JLabel img;
	private ImageIcon [] icon = new ImageIcon [4]; // ImageIcon 배열
	public ImageGallery() {
		setTitle("이미지 갤러리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane(); 
		c.setLayout(new BorderLayout()); // BorderLayout 적용
		
		// ImageIcon 배열 icon 만들기
		icon[0] = new ImageIcon("images/spring.png");
		icon[1] = new ImageIcon("images/summer.png");
		icon[2] = new ImageIcon("images/fall.png");
		icon[3] = new ImageIcon("images/winter.png");
		
		img = new JLabel(icon[i]);
		c.add(img, BorderLayout.CENTER);
		c.add(new MenuPanel(), BorderLayout.SOUTH);
		
		setSize(400, 400);
		setVisible(true);
	}
	
	// 2개의 버튼을 가진 JPanel 클래스 작성
	class MenuPanel extends JPanel {
		public MenuPanel() {
			setBackground(Color.WHITE); // 배경은 하얀색으로
			ImageIcon left_arrow = new ImageIcon("images/left_arrow.png");
			ImageIcon right_arrow = new ImageIcon("images/right_arrow.png");
			JButton larw = new JButton(left_arrow);
			JButton rarw = new JButton(right_arrow);
			
			larw.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					i--;
					i %= icon.length;
					if (i < 0) i += icon.length;
					img.setIcon(icon[i]);
					
				}
			});
			rarw.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					i++;
					i %= icon.length;
					if (i < 0) i += icon.length;
					img.setIcon(icon[i]);
				}
			});
			add(larw); add(rarw);
		}
	}
	
	public static void main(String [] args) {
		new ImageGallery();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 과제 11장 OpenChallenge");
	}
}