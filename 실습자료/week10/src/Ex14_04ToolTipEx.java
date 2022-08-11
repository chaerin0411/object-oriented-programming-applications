import javax.swing.*;
import java.awt.*;

public class Ex14_04ToolTipEx extends JFrame {
	private Container contentPane;
	
	public Ex14_04ToolTipEx() {
		setTitle("툴팁 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		createToolBar(); //툴바 생성, 프레임에 삽입
		setSize(400, 200);
		setVisible(true);
	}
	
	private void createToolBar() {
		JToolBar bar = new JToolBar("Kitae Menu");
		bar.setBackground(Color.LIGHT_GRAY);
		JButton newBtn = new JButton("New");
		newBtn.setToolTipText("파일을 생성합니다.");
		bar.add(newBtn);
		
		JButton openBtn = new JButton(new ImageIcon("images/open.jpg"));
		openBtn.setToolTipText("파일을 엽니다.");
		bar.add(openBtn);
		bar.addSeparator();
		
		JButton saveBtn = new JButton(new ImageIcon("images/save.jpg"));
		saveBtn.setToolTipText("파일을 저장합니다.");
		bar.add(saveBtn);
		
		bar.add(new JLabel("search"));
		
		JTextField tf = new JTextField("text field");
		tf.setToolTipText("찾고자하는 문자열을 입력하세요");
		bar.add(tf);
		contentPane.add(bar, BorderLayout.NORTH);
	}
	
	public static void main(String [] args) {
		new Ex14_04ToolTipEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 14-4");
	}
}