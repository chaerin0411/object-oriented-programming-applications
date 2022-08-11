import java.awt.*;
import javax.swing.*;

class TimerThread extends Thread {
	private JLabel timerLabel;
	public TimerThread(JLabel timerLabel) { //timerLabel 설정하는 메소드
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() { //스레드 실행
		super.run();
		System.out.println(" id "+Thread.currentThread().getId()+ //id 16
				   " name "+Thread.currentThread().getName()+ //name Thread-0
				   " prio "+Thread.currentThread().getPriority()); //prio 5
		int n=0; //n 초기화
		while(true) {
			timerLabel.setText(Integer.toString(n)); //Int->String 타입변환
			n++; //n 증가
			try { Thread.sleep(1000); } //1초 휴식
			catch(InterruptedException e) { return; } //예외처리
		}
	}
}

public class Ex13_01ThreadTimerEx extends JFrame {
	
	public Ex13_01ThreadTimerEx() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel); //timerLabel 설정
		setSize(300, 170);
		setVisible(true);
		
		th.start(); //스레드 시작
	}
	
	public static void main(String[] args) {
		new Ex13_01ThreadTimerEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 12주차 예제 13-1");
		System.out.println(" id "+Thread.currentThread().getId()+ //id 1
						   " name "+Thread.currentThread().getName()+ //name main
						   " prio "+Thread.currentThread().getPriority()); //prio 5
	}
}
