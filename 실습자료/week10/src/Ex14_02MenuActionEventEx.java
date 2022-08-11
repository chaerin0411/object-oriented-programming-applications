import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex14_02MenuActionEventEx extends JFrame {
	private JLabel imgLabel = new JLabel();
	public Ex14_02MenuActionEventEx() {
		setTitle("Menu�� Action ������ ����� ����");
		createMenu(); //�޴� ����, �����ӿ� ����
		getContentPane(); add(imgLabel, BorderLayout.CENTER);
		setSize(200, 250);
		setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb = new JMenuBar(); //�޴���
		JMenuItem [] menuItem = new JMenuItem [4];
		String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};
		JMenu screenMenu = new JMenu("Screen");
		
		//4���� �޴��������� Screen �޴��� �����Ѵ�.
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					switch(cmd) { //�޴� �������� ���� ����
						case "Load":
							if(imgLabel.getIcon() != null)
								return; //�̹� �ε��Ǿ����� ����
							imgLabel.setIcon(new ImageIcon("images/img.jpg"));
							break;
						case "Hide":
							imgLabel.setVisible(false);
							break;
						case "ReShow":
							imgLabel.setVisible(true);
							break;
						case "Exit":
							System.exit(0);
							break;
					}
				}
			});
			screenMenu.add(menuItem[i]); //�޴��� > Screen�޴� > �޴�������[4]
		}
		mb.add(screenMenu); //�޴��� > Screen�޴���
		setJMenuBar(mb); //�޴��� ����
	}
	
	public static void main(String [] args) {
		new Ex14_02MenuActionEventEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 10���� ���� 14-2");
	}
}