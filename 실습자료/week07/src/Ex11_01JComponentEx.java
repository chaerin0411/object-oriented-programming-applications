import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_01JComponentEx extends JFrame {
	public Ex11_01JComponentEx() {
		super("JComponent의 공통 메소드 예제"); // 제목 설정
		Container c = getContentPane(); // 콘텐트팬 추가
		c.setLayout(new FlowLayout()); // FlowLayout으로 설정
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton("Disabled Button");
		JButton b3 = new JButton("getX(), getY()");
		
		b1.setBackground(Color.YELLOW); // 배경색 설정
		b1.setForeground(Color.MAGENTA); // 글자색 설정
		b1.setFont(new Font("Arial", Font.ITALIC, 20)); // Arial, 20픽셀 폰트 설정
		b2.setEnabled(false); // 버튼 비활성화
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				Ex11_01JComponentEx frame = (Ex11_01JComponentEx)b.getTopLevelAncestor();
				frame.setTitle(b.getX() + "," + b.getY()); // 타이틀에 버튼 좌표 출력
				System.out.println("버튼3을 클릭했어요. " + b.getText() + " 높이: " + b.getHeight() + ", 넓이: " + b.getWidth());
				b.setText("버튼3");
			}
		});
		c.add(b1); c.add(b2); c.add(b3);
		setSize(250, 200);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Ex11_01JComponentEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 7주차 과제 예제 11-1");
	}
}