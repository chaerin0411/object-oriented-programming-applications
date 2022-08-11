import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex11_04CheckBoxEx extends JFrame {
	//���� ���� �׳� �ķ�� �Ѿ
	public Ex11_04CheckBoxEx() {
		setTitle("üũ�ڽ� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon cherryIcon = new ImageIcon("images/cherry.jpg");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherry.jpg");
		
		JCheckBox apple = new JCheckBox("���");
		JCheckBox pear = new JCheckBox("��", true);
		JCheckBox cherry = new JCheckBox("ü��", cherryIcon);
		cherry.setBorderPainted(true);
		cherry.setSelectedIcon(selectedCherryIcon);
		
		c.add(apple); c.add(pear); c.add(cherry);
		setSize(250,150);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new Ex11_04CheckBoxEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 9���� ���� 11-4");
	}

}