import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyDialog extends JDialog {
	private JTextField tf = new JTextField(10);
	private JButton okButton = new JButton("Ok");
	
	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200, 100);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
public class Ex14_06DialogEx extends JFrame {
	private MyDialog dialog;
	public Ex14_06DialogEx() {
		super("DialogEx ���� ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Dialog");
		
		dialog = new MyDialog(this, "Test Dialog");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		getContentPane().add(btn);
		setSize(250, 200);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Ex14_06DialogEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 10���� ���� 14-6");
	}
}