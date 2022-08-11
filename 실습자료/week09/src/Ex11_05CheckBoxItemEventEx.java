import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_05CheckBoxItemEventEx extends JFrame {
	private JCheckBox [] fruits = new JCheckBox[3];
	private String [] names = {"���", "��", "ü��"};
	private int[] price = {100, 500, 20000};
	private JLabel sumLabel;
	int sum = 0;
	
	public Ex11_05CheckBoxItemEventEx() {
		setTitle("üũ�ڽ��� ItemEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("��� 100��, �� 500��, ü�� 20000��"));
		
		JPanel pn = new JPanel();
		for(int i=0; i<fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			pn.add(fruits[i]);
			fruits[i].addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					Object source = e.getItem();
					//CheckBox�� ������ �̺�Ʈ�� ó���Ѵ�. (���ݰ��)
					if(e.getStateChange() == ItemEvent.SELECTED) {
						if(source == fruits[0])
							sum += 100;
						else if(source == fruits[1])
							sum += 500;
						else
							sum += 20000;
					}
					else {
						if(source == fruits[0])
							sum -= 100;
						else if(source == fruits[1])
							sum -= 500;
						else
							sum -= 20000;
					}
					sumLabel.setText("����"+sum+"�� �Դϴ�.");
				}
			});
		}
		c.add(pn);
		sumLabel = new JLabel("���� 0�� �Դϴ�.");
		c.add(sumLabel);
		setSize(250, 200);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_05CheckBoxItemEventEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 11-5");
	}

}
