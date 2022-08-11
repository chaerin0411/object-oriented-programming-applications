import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Exam04 extends JFrame {

	public Exam04() {
		setTitle("버튼 액션 이벤트 처리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		JButton btnOk = new JButton("Ok");
		JButton btnCnl = new JButton("Cancel");
		
		JPanel p_button = new JPanel(new GridLayout(0,2));
		p_button.add(btnOk); p_button.add(btnCnl);
		c.add(p_button, BorderLayout.CENTER);
		
		JLabel msg = new JLabel("메시지 안내입니다.");
		c.add(msg, BorderLayout.SOUTH);
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msg.setText("Ok 버튼이 클릭되었습니다.");
			}
		});

		btnCnl.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msg.setText("Cancel 버튼이 클릭되었습니다.");
			}
		});
		
		setVisible(true);
		setSize(300, 130);
	}

	public static void main(String[] args) {
		new Exam04();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 9주차 예제 4번");
	}

}
