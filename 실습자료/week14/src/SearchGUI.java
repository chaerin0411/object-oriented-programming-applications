import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class SearchGUI extends JFrame {
	/** SerialVersionUID **/
	private static final long serialVersionUID = 1L;
	
	JPanel pSearch, pn1, pn2;
	JTextField tfTt, tfDay, tfTime;
	JButton btnBack, btnReset, btnSearch;
	JRadioButton rbTitle, rbDay, rbDaytime;
	String title, day, time;
	String[][] contents;
	Connection conn; //DB
	Statement stmt; //SQL��
	ResultSet rs;
	
	public SearchGUI() {
		super("���̾");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		pn1 = new JPanel(new GridLayout(3,2));
		pn2 = new JPanel();
		
		pn1.add(new JLabel("��¥"));
		tfDay = new JTextField(15);
		pn1.add(tfDay);

		pn1.add(new JLabel("�ð�"));
		tfTime = new JTextField(15);
		pn1.add(tfTime);
		
		pn1.add(new JLabel("����"));
		tfTt = new JTextField(15);
		pn1.add(tfTt);
		
		ButtonGroup group = new ButtonGroup();
		rbDay     = new JRadioButton("��¥");
		rbDaytime = new JRadioButton("��¥+�ð�", true); //�⺻���� üũ������
		rbTitle   = new JRadioButton("����");
		group.add(rbDay); group.add(rbDaytime); group.add(rbTitle);
		pn2.add(rbDay); pn2.add(rbDaytime);	pn2.add(rbTitle);
		
		pSearch = new JPanel(new BorderLayout(0,0)); //middle �ǳ�
		pSearch.add(BorderLayout.CENTER, pn1);
		pSearch.add(BorderLayout.SOUTH, pn2);
		
		TitledBorder tb = new TitledBorder("�˻�");
		pSearch.setBorder(tb);
		c.add(pSearch); //pSearch �ǳ� �߰�
		
		btnBack = new JButton("���ư���");
		btnReset = new JButton("����");
		btnSearch = new JButton("�˻�");
		
		c.add(btnBack);
		c.add(btnReset);
		c.add(btnSearch);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowGUI(); setVisible(false);
			}
		}); //���ư��� ��ư
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTt.setText(""); tfDay.setText(""); tfTime.setText("");
			}
		}); //���� ��ư
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbSearch();
			}
		}); //�˻� ��ư
		
		setSize(400,500);
		setVisible(true);
	} /*end-SearchGUI()*/
	
	public void dbSearch() { //������ �˻�
		if (rbDay.isSelected()) {
			new ShowDayGUI(tfDay.getText().toString());
			setVisible(false);
		} else if (rbDaytime.isSelected()) {
			new ShowDayTimeGUI(tfDay.getText().toString(),tfTime.getText().toString());
			setVisible(false);
		} else {
			new ShowTitleGUI(tfTt.getText().toString());
			setVisible(false);
		}
	} /*end-dbSearch()*/
}