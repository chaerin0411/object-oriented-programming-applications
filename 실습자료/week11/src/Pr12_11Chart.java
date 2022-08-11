import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pr12_11Chart extends JFrame {
	private int [] data = {0,0,0,0};
	private int [] arcAngle = new int [4];
	private Color [] color = { Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE };
	private String [] itemName = {"apple", "banana", "cherry", "mango"};
	private JTextField [] tfIn = new JTextField [4];
	private ChartPanel chartPanel = new ChartPanel();
	private JPanel inputPanel = new JPanel(); //과일갯수입력창

	public Pr12_11Chart() {
		setTitle("20202865 엄지희, 파이차트 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		createGUI();
		c.add(inputPanel, BorderLayout.NORTH);
		c.add(chartPanel, BorderLayout.CENTER);
		setSize(500, 350);
		setVisible(true);
		drawChart();
	}
	
	//과일 갯수 입력 만들기 & 리스너 설정
	private void createGUI() {
		inputPanel.setBackground(Color.LIGHT_GRAY);
		for(int i=0; i<tfIn.length; i++) {
			tfIn[i] = new JTextField("0", 5);
			tfIn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JTextField t = (JTextField)e.getSource();
					int n;
					try { n = Integer.parseInt(t.getText()); }
					catch(NumberFormatException ex) {
						t.setText("");
						return;
					}
					drawChart();
				}
			});
			inputPanel.add(new JLabel(itemName[i]));
			inputPanel.add(tfIn[i]);
		}
	};
	
	private void drawChart() {
		int sum=0;
		for(int i=0; i<data.length; i++) {
			data[i] = Integer.parseInt(tfIn[i].getText());
			sum+=data[i];
		}
		if(sum==0) return;
		
		for(int i=0; i<data.length; i++)
			arcAngle[i] = (int)Math.round(  (double)data[i] / (double)sum*360  );
		chartPanel.repaint();
	}
	
	private class ChartPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int startAngle = 0;
			for(int i=0; i<data.length; i++) {
				g.setColor(color[i]);
				g.drawString(itemName[i]+" "+Math.round(arcAngle[i] * 100./360.)+"%", 50+i*100, 20);
			}
			for(int i=0; i<data.length; i++) {
				g.setColor(color[i]);
				g.fillArc(150, 50, 200, 200, startAngle, arcAngle[i]);
				startAngle = startAngle + arcAngle[i];
			}
		}
	}

	public static void main(String[] args) {
		new Pr12_11Chart();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 11주차 연습문제 12-11");
	}
}
