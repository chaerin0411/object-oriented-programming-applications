import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ImageGallery extends JFrame {
	int i = 0;
	private JLabel img;
	private ImageIcon [] icon = new ImageIcon [4]; // ImageIcon �迭
	public ImageGallery() {
		setTitle("�̹��� ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane(); 
		c.setLayout(new BorderLayout()); // BorderLayout ����
		
		// ImageIcon �迭 icon �����
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
	
	// 2���� ��ư�� ���� JPanel Ŭ���� �ۼ�
	class MenuPanel extends JPanel {
		public MenuPanel() {
			setBackground(Color.WHITE); // ����� �Ͼ������
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
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 7���� ���� 11�� OpenChallenge");
	}
}