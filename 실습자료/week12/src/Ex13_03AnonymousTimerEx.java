import java.awt.*;
import javax.swing.*;

public class Ex13_03AnonymousTimerEx extends JFrame {
	static JLabel timerLabel;
	public Ex13_03AnonymousTimerEx() {
		setTitle("Runnerble�� ������ Ÿ�̸� ������ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		timerLabel.setForeground(Color.RED); //������
		c.add(timerLabel);
		
		setSize(300, 170);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex13_03AnonymousTimerEx();
		Thread th = new Thread(new Runnable() { //th��ü ���� - Runnable ������
			@Override
			public void run() {
				int n=0;
				while(true) {
					timerLabel.setText(Integer.toString(n)); //Int -> String
					n++;
					try { Thread.sleep(1000); } //1�� �޽�
					catch(InterruptedException e) { return; } //���� ó��
				}
			}
		}); //th��ü ���� end
		th.start(); //������ ȣ��
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 12���� ���� 13-3");
	}
}
