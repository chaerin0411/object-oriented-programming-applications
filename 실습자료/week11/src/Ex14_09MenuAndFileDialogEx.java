import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.awt.*;

public class Ex14_09MenuAndFileDialogEx extends JFrame {
	private JLabel imageLabel = new JLabel();
	private JFileChooser chooser = new JFileChooser();
	
	public Ex14_09MenuAndFileDialogEx() {
		setTitle("Menu�� JFileChooser Ȱ�� ����");
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
							"������ �������� �ʾҽ��ϴ�", "���",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				String filePath = chooser.getSelectedFile().getPath();
				imageLabel.setIcon(new ImageIcon(filePath));
				pack(); //�̹����� ũ�⿡ ���߾� ������ ũ�� ����
			}
		});
		fileMenu.add(openItem);
		mb.add(fileMenu);
		setJMenuBar(mb);
	}
	
	public static void main(String[] args) {
		new Ex14_09MenuAndFileDialogEx();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 11���� ���� 14-9");
	}
}
