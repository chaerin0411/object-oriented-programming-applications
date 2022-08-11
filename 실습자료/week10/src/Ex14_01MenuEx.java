import javax.swing.*;

public class Ex14_01MenuEx extends JFrame {
	public Ex14_01MenuEx() {
		setTitle("Menu 만들기 예제");
		createMenu(); //메뉴 생성, 프레임에 삽입
		setSize(250, 200);
		setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu screenMenu = new JMenu("Screen");
		
		screenMenu.add(new JMenuItem("Load"));
		screenMenu.add(new JMenuItem("Hide"));
		screenMenu.add(new JMenuItem("ReShow"));
		screenMenu.addSeparator(); //분리선 삽입
		screenMenu.add(new JMenuItem("Exit"));
		
		mb.add(screenMenu);
		mb.add(new JMenu("Edit"));
		mb.add(new JMenu("Source"));
		mb.add(new JMenu("Project"));
		mb.add(new JMenu("Run"));
		
		setJMenuBar(mb);
	}
	public static void main(String [] args) {
		new Ex14_01MenuEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 10주차 예제 14-1");
	}
}
