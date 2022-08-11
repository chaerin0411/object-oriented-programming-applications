import java.awt.*;
import javax.swing.*;

class TimerThread extends Thread {
	private JLabel timerLabel;
	public TimerThread(JLabel timerLabel) { //timerLabel �����ϴ� �޼ҵ�
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() { //������ ����
		super.run();
		System.out.println(" id "+Thread.currentThread().getId()+ //id 16
				   " name "+Thread.currentThread().getName()+ //name Thread-0
				   " prio "+Thread.currentThread().getPriority()); //prio 5
		int n=0; //n �ʱ�ȭ
		while(true) {
			timerLabel.setText(Integer.toString(n)); //Int->String Ÿ�Ժ�ȯ
			n++; //n ����
			try { Thread.sleep(1000); } //1�� �޽�
			catch(InterruptedException e) { return; } //����ó��
		}
	}
}

public class Ex13_01ThreadTimerEx extends JFrame {
	
	public Ex13_01ThreadTimerEx() {
		setTitle("Thread�� ��ӹ��� Ÿ�̸� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		c.add(timerLabel);
		
		TimerThread th = new TimerThread(timerLabel); //timerLabel ����
		setSize(300, 170);
		setVisible(true);
		
		th.start(); //������ ����
	}
	
	public static void main(String[] args) {
		new Ex13_01ThreadTimerEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 12���� ���� 13-1");
		System.out.println(" id "+Thread.currentThread().getId()+ //id 1
						   " name "+Thread.currentThread().getName()+ //name main
						   " prio "+Thread.currentThread().getPriority()); //prio 5
	}
}
