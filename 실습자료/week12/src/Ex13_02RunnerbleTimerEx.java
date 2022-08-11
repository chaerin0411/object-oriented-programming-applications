import java.awt.*;
import javax.swing.*;

class TimerRunnable implements Runnable { //Runnable �������̽� ����
	private JLabel timerLabel;
	
	public TimerRunnable(JLabel timerLabel) { //timerLabel ���� �޼ҵ�
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int n=0;
		while(true) { //���ѷ���
			timerLabel.setText(Integer.toString(n)); //Int -> String
			n++;
			try { Thread.sleep(1000); } //1�� �޽�
			catch(InterruptedException e) { return; } //����ó��
		}
	}
}

public class Ex13_02RunnerbleTimerEx extends JFrame {
	
	public Ex13_02RunnerbleTimerEx() {
		setTitle("Runnerble�� ������ Ÿ�̸� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setForeground(Color.GREEN); //�ʷϻ�
		c.add(timerLabel);
		
		TimerRunnable runnable = new TimerRunnable(timerLabel); //timerLabel ����
		Thread th = new Thread(runnable); //Runnable ������
		setSize(300, 170);
		setVisible(true);
		
		th.start(); //������ ȣ��
	}
	
	public static void main(String[] args) {
		new Ex13_02RunnerbleTimerEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 12���� ���� 13-2");
	}
}
