import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ex14_02MenuActionEventEx extends JFrame {
	private JLabel imgLabel = new JLabel();
	public Ex14_02MenuActionEventEx() {
		setTitle("Menu에 Action 리스너 만들기 예제");
		createMenu(); //메뉴 생성, 프레임에 삽입
		getContentPane(); add(imgLabel, BorderLayout.CENTER);
		setSize(200, 250);
		setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb = new JMenuBar(); //메뉴바
		JMenuItem [] menuItem = new JMenuItem [4];
		String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};
		JMenu screenMenu = new JMenu("Screen");
		
		//4개의 메뉴아이템을 Screen 메뉴에 삽입한다.
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					switch(cmd) { //메뉴 아이템의 종류 구분
						case "Load":
							if(imgLabel.getIcon() != null)
								return; //이미 로딩되었으면 리턴
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
			screenMenu.add(menuItem[i]); //메뉴바 > Screen메뉴 > 메뉴아이템[4]
		}
		mb.add(screenMenu); //메뉴바 > Screen메뉴ㄴ
		setJMenuBar(mb); //메뉴바 설정
	}
	
	public static void main(String [] args) {
		new Ex14_02MenuActionEventEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 14-2");
	}
}