import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.awt.*;

public class Ex14_09MenuAndFileDialogEx extends JFrame {
	private JLabel imageLabel = new JLabel();
	private JFileChooser chooser = new JFileChooser();
	
	public Ex14_09MenuAndFileDialogEx() {
		setTitle("Menu와 JFileChooser 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(imageLabel);
		createMenu();
		setSize(350, 200);
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		
		openItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = 
						new FileNameExtensionFilter(
								"JPG & GIF Images", "jpg", "gif");
				chooser.setFileFilter(filter);
				
				int ret = chooser.showOpenDialog(null);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, 
							"파일을 선택하지 않았습니다", "경고",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				String filePath = chooser.getSelectedFile().getPath();
				imageLabel.setIcon(new ImageIcon(filePath));
				pack(); //이미지의 크기에 맞추어 프레임 크기 조절
			}
		});
		fileMenu.add(openItem);
		mb.add(fileMenu);
		setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		new Ex14_09MenuAndFileDialogEx();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 11주차 예제 14-9");
	}
}
