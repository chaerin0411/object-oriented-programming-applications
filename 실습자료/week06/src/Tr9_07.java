import java.awt.*;
import javax.swing.*;

public class Tr9_07 extends JFrame {
	public Tr9_07() {
		
		setTitle("���� ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		north.setBackground(Color.LIGHT_GRAY);
		north.add(new JLabel("�����Է�"));
		north.add(new JTextField(30));
		
		Container center = new JPanel();
		center.setLayout(new GridLayout(4, 4, 3, 3));
		center.add(new JButton("0"));
		center.add(new JButton("1"));
		center.add(new JButton("2"));
		center.add(new JButton("3"));
		center.add(new JButton("4"));
		center.add(new JButton("5"));
		center.add(new JButton("6"));
		center.add(new JButton("7"));
		center.add(new JButton("8"));
		center.add(new JButton("9"));
		center.add(new JButton("CE"));
		center.add(new JButton("���"));
		JButton p = new JButton("+");
		JButton m = new JButton("-");
		JButton x = new JButton("*");
		JButton l = new JButton("/");
		center.add(p);
		center.add(m);
		center.add(x);
		center.add(l);
		p.setBackground(Color.CYAN);
		m.setBackground(Color.CYAN);
		x.setBackground(Color.CYAN);
		l.setBackground(Color.CYAN);
		
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		south.setBackground(Color.YELLOW);
		south.add(new JLabel("��� ���"));
		south.add(new JTextField(30));

		c.add(north, BorderLayout.NORTH);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);

		setSize(400, 300);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Tr9_07();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 6���� ���� �ǽ����� 9-7");
	}
}