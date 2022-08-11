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
	Statement stmt; //SQL문
	ResultSet rs;
	
	public SearchGUI() {
		super("다이어리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		pn1 = new JPanel(new GridLayout(3,2));
		pn2 = new JPanel();
		
		pn1.add(new JLabel("날짜"));
		tfDay = new JTextField(15);
		pn1.add(tfDay);

		pn1.add(new JLabel("시간"));
		tfTime = new JTextField(15);
		pn1.add(tfTime);
		
		pn1.add(new JLabel("제목"));
		tfTt = new JTextField(15);
		pn1.add(tfTt);
		
		ButtonGroup group = new ButtonGroup();
		rbDay     = new JRadioButton("날짜");
		rbDaytime = new JRadioButton("날짜+시간", true); //기본으로 체크돼있음
		rbTitle   = new JRadioButton("제목");
		group.add(rbDay); group.add(rbDaytime); group.add(rbTitle);
		pn2.add(rbDay); pn2.add(rbDaytime);	pn2.add(rbTitle);
		
		pSearch = new JPanel(new BorderLayout(0,0)); //middle 판넬
		pSearch.add(BorderLayout.CENTER, pn1);
		pSearch.add(BorderLayout.SOUTH, pn2);
		
		TitledBorder tb = new TitledBorder("검색");
		pSearch.setBorder(tb);
		c.add(pSearch); //pSearch 판넬 추가
		
		btnBack = new JButton("돌아가기");
		btnReset = new JButton("리셋");
		btnSearch = new JButton("검색");
		
		c.add(btnBack);
		c.add(btnReset);
		c.add(btnSearch);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowGUI(); setVisible(false);
			}
		}); //돌아가기 버튼
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTt.setText(""); tfDay.setText(""); tfTime.setText("");
			}
		}); //리셋 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbSearch();
			}
		}); //검색 버튼
		
		setSize(400,500);
		setVisible(true);
	} /*end-SearchGUI()*/
	
	public void dbSearch() { //데이터 검색
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