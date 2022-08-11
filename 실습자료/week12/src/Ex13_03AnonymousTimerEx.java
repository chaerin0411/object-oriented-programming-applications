import java.awt.*;
import javax.swing.*;

public class Ex13_03AnonymousTimerEx extends JFrame {
	static JLabel timerLabel;
	public Ex13_03AnonymousTimerEx() {
		setTitle("Runnerble을 구현한 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setForeground(Color.RED); //빨강색
		c.add(timerLabel);
		
		setSize(300, 170);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex13_03AnonymousTimerEx();
		Thread th = new Thread(new Runnable() { //th객체 생성 - Runnable 스레드
			@Override
			public void run() {
				int n=0;
				while(true) {
					timerLabel.setText(Integer.toString(n)); //Int -> String
					n++;
					try { Thread.sleep(1000); } //1초 휴식
					catch(InterruptedException e) { return; } //예외 처리
				}
			}
		}); //th객체 생성 end
		th.start(); //스레드 호출
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 12주차 예제 13-3");
	}
}
