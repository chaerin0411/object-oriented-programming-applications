import java.awt.*;
import javax.swing.*;

class TimerRunnable implements Runnable { //Runnable 인터페이스 구현
	private JLabel timerLabel;
	
	public TimerRunnable(JLabel timerLabel) { //timerLabel 설정 메소드
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int n=0;
		while(true) { //무한루프
			timerLabel.setText(Integer.toString(n)); //Int -> String
			n++;
			try { Thread.sleep(1000); } //1초 휴식
			catch(InterruptedException e) { return; } //예외처리
		}
	}
}

public class Ex13_02RunnerbleTimerEx extends JFrame {
	
	public Ex13_02RunnerbleTimerEx() {
		setTitle("Runnerble을 구현한 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setForeground(Color.GREEN); //초록색
		c.add(timerLabel);
		
		TimerRunnable runnable = new TimerRunnable(timerLabel); //timerLabel 설정
		Thread th = new Thread(runnable); //Runnable 스레드
		setSize(300, 170);
		setVisible(true);
		
		th.start(); //스레드 호출
	}
	
	public static void main(String[] args) {
		new Ex13_02RunnerbleTimerEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 12주차 예제 13-2");
	}
}
