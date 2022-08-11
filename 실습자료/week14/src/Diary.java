import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Diary extends JFrame {
	/** SerialVersionUID **/
	private static final long serialVersionUID = 1L;
	
	GridBagLayout gBag;
	JTextField tfId;
	JPasswordField tfPw;
	JButton btnReset, btnLogin;
	
	public Diary() { //������
		setTitle("���̾");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginGUI(); //login GUI ����
		
		tfPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		}); //���� ������ �α���
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfId.setText(""); tfPw.setText("");
			}
		}); //��ư ������ �ؽ�Ʈ �ʵ� ����
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		}); //��ư ������ �α���
		
		setSize(400,250);
		setVisible(true);
	} /*end-Diary()*/
	
	public void loginGUI() {
		Container c = getContentPane();
		gBag = new GridBagLayout();
		c.setLayout(gBag);
		
		//DIARY ���� ����
		gbinsert(new JLabel("2021 DIARY",JLabel.CENTER),0,0,4,1);
		gbinsert(new JLabel(" "),0,1,4,1);
		
		gbinsert(new JLabel(" ID "),0,2,1,1); //ID �Է�ĭ ����
		tfId = new JTextField(20);
		gbinsert(tfId,1,2,3,1);
		
		gbinsert(new JLabel("PW  "),0,3,1,1); //PW �Է�ĭ ����
		tfPw = new JPasswordField(20);
		gbinsert(tfPw,1,3,3,1);
		gbinsert(new JLabel(" "),0,4,4,1);
		
		btnReset = new JButton("RESET");
		gbinsert(btnReset,0,5,2,1);
		
		btnLogin = new JButton("LOGIN");
		gbinsert(btnLogin,2,5,2,1);
	} /*end-loginGUI()*/
	
	public void login() {
		if(tfId.getText().toString().equals("jihee") &&
		   tfPw.getText().toString().equals("diary")) {
			JOptionPane.showMessageDialog(null,
						"�ݰ����ϴ�", "�޼���",
						JOptionPane.INFORMATION_MESSAGE);
			new ShowGUI();
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, 
						"���̵�� ��й�ȣ�� �ٽ� Ȯ�����ּ���", "�α��� ����",
						JOptionPane.ERROR_MESSAGE);
		}
	} /*end-login()*/
	
	public void gbinsert(Component c, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gBag.setConstraints(c,gbc);
		this.add(c);
	} /*end-gbinsert()*/
	
	public static void main(String[] args) {
		new Diary(); //������ ����
	}
}