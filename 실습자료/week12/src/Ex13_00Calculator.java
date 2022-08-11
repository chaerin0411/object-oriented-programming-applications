import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex13_00Calculator extends JFrame {
	String[] btnName = {"더하기+", "빼기-", "곱하기*", "나누기/"};
	JButton[] btn    = new JButton[4];
	
	public Ex13_00Calculator() {
		setTitle("간단계산기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel lb = new JLabel("20202865 엄지희");
		
		// 숫자 입력 패널
		JPanel pnIn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField in1 = new JTextField(15);
		JPanel pnIn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField in2 = new JTextField(15);
		pnIn1.add(new JLabel("숫자1")); pnIn1.add(in1);
		pnIn2.add(new JLabel("숫자2")); pnIn2.add(in2);
		// 버튼 패널
		JPanel pnBtn = new JPanel(new GridLayout(0,1,5,5));
		// 결과레이블
		JLabel lbResult = new JLabel("결과값:  ");
		lbResult.setFont(new Font("Gothic", Font.BOLD, 20));
		// 버튼 생성 및 이벤트 처리
		for (int i=0; i<btnName.length; i++) {
			btn[i] = new JButton(btnName[i]);
			pnBtn.add(btn[i]);
			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int num1 = Integer.parseInt(in1.getText());
					int num2 = Integer.parseInt(in2.getText());
					JButton btn = (JButton)e.getSource();
					if (btn.getText().equals("더하기+")) {
						lbResult.setText("결과값: "+(num1+num2));
					} else if (btn.getText().equals("빼기-")) {
						lbResult.setText("결과값: "+(num1-num2));
					} else if (btn.getText().equals("곱하기*")) {
						lbResult.setText("결과값: "+(num1*num2));
					} else {
						lbResult.setText("결과값: "+(num1/num2));
					} lbResult.setForeground(Color.RED);
				}
			});
		}
		pnBtn.add(lbResult);
		
		c.add(lb);
		c.add(pnIn1); c.add(pnIn2);
		c.add(pnBtn);
		setSize(250, 400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex13_00Calculator();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 12주차 예제");
	}
}
