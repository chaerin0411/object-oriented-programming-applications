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
	
	public Diary() { //생성자
		setTitle("다이어리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginGUI(); //login GUI 생성
		
		tfPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		}); //엔터 누르면 로그인
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfId.setText(""); tfPw.setText("");
			}
		}); //버튼 누르면 텍스트 필드 리셋
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		}); //버튼 누르면 로그인
		
		setSize(400,250);
		setVisible(true);
	} /*end-Diary()*/
	
	public void loginGUI() {
		Container c = getContentPane();
		gBag = new GridBagLayout();
		c.setLayout(gBag);
		
		//DIARY 제목 생성
		gbinsert(new JLabel("2021 DIARY",JLabel.CENTER),0,0,4,1);
		gbinsert(new JLabel(" "),0,1,4,1);
		
		gbinsert(new JLabel(" ID "),0,2,1,1); //ID 입력칸 생성
		tfId = new JTextField(20);
		gbinsert(tfId,1,2,3,1);
		
		gbinsert(new JLabel("PW  "),0,3,1,1); //PW 입력칸 생성
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
						"반갑습니다", "메세지",
						JOptionPane.INFORMATION_MESSAGE);
			new ShowGUI();
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, 
						"아이디와 비밀번호를 다시 확인해주세요", "로그인 오류",
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
		new Diary(); //생성자 실행
	}
}