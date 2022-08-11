import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ex9_00GridLayout_EventTest extends JFrame{
	public Ex9_00GridLayout_EventTest() {
		
		setTitle("GridLayoutSample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(6, 2);
		// 4X2 분할의 그리드 레이아웃, 4행 2열, grid라는 객체 생성
		grid.setVgap(5); // vertical gap 설정
		Container c = getContentPane();
		
		c.setLayout(grid);
		// 이미 만들어진 객체로 레이아웃 생성
		c.add(new JLabel(" 이름"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학과"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 과목"));
		c.add(new JTextField(""));
		
		JButton btnOk = new JButton("입력");
		JButton btnCancel = new JButton("취소");
		JLabel lblMessage = new JLabel("msg : ");
		c.add(btnOk);
		c.add(btnCancel);
		c.add(lblMessage);
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("입력 버튼 누름...");
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblMessage.setText("취소 버튼 누름...");
				System.out.println("취소 버튼이 눌러졌어요...");
			}
		});
		
		setSize(300, 200); // 가로 300, 세로 200 크기의 창
		setVisible(true); // 눈에 보이도록 출력
	}
	
	public static void main(String[] args) {
		new Ex9_00GridLayout_EventTest();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 6주차 과제 예제 9-5 응용");
	}
}