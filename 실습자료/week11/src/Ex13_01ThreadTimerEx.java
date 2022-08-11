import java.awt.*;
import javax.swing.*;

class TimerThread extends Thread {
	private JLabel timerLabel;
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int n=0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try { Thread.sleep(1000); }
			catch(InterruptedException e) { return; }
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
		
		TimerThread th = new TimerThread(timerLabel);
		setSize(300, 170);
		setVisible(true);
		
		th.start();
	}
	
	public static void main(String[] args) {
		new Ex13_01ThreadTimerEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 11주차 예제 13-1");
	}
}
