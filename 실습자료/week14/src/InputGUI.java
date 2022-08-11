import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class InputGUI extends JFrame {
	/** SerialVersionUID **/
	private static final long serialVersionUID = 1L;

	GridBagLayout gBag;
	JTextField tfTt, tfDay, tfTime, tfWth;
	JTextArea taCnt;
	JButton btnBack, btnDel, btnReg;
	Connection conn; //DB
	Statement stmt; //SQL문
	
	public InputGUI() {
		super("다이어리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		gBag = new GridBagLayout();
		c.setLayout(gBag);
		
		gbinsert(new JLabel("제목 "),0,0,1,1); //제목 입력칸 생성
		tfTt = new JTextField(20);
		gbinsert(tfTt,1,0,5,1);
		gbinsert(new JLabel(" "),0,1,4,1);
		
		gbinsert(new JLabel(" "),0,2,1,1);
		gbinsert(new JLabel(" "),1,2,1,1);
		gbinsert(new JLabel(" "),2,2,1,1);
		gbinsert(new JLabel("날짜(Ex.06/16) ",JLabel.RIGHT),4,2,1,1); //날짜 입력칸 생성
		tfDay = new JTextField(3);
		gbinsert(tfDay,5,2,1,1);

		gbinsert(new JLabel(" "),0,3,1,1);
		gbinsert(new JLabel(" "),1,3,1,1);
		gbinsert(new JLabel(" "),2,3,1,1);
		gbinsert(new JLabel("시간(Ex.18:30) ",JLabel.RIGHT),4,3,1,1); //시간 입력칸 생성
		tfTime = new JTextField(3);
		gbinsert(tfTime,5,3,1,1);

		gbinsert(new JLabel(" "),0,4,5,1);
		gbinsert(new JLabel("날씨 "),0,5,1,1); //날씨 입력칸 생성
		tfWth = new JTextField(20);
		gbinsert(tfWth,1,5,5,1);
		
		gbinsert(new JLabel("내용 "),0,6,1,1); //내용 입력칸 생성
		taCnt = new JTextArea(7,20);
		taCnt.setLineWrap(true);
		gbinsert(taCnt,1,6,5,4);

		gbinsert(new JLabel(" "),0,10,5,1);
		btnBack = new JButton("돌아가기");
		gbinsert(btnBack,0,11,3,1);
		btnDel = new JButton("전체삭제");
		gbinsert(btnDel,3,11,1,1);
		btnReg = new JButton("등록");
		gbinsert(btnReg,4,11,2,1);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowGUI(); setVisible(false);
			}
		}); //돌아가기 버튼
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTt.setText("");
				tfDay.setText("");
				tfTime.setText("");
				tfWth.setText("");
				taCnt.setText("");
			}
		}); //전체삭제 버튼
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbRegistry();
			}
		}); //등록 버튼
				
		setSize(400,500);
		setVisible(true);
	} /*end-InputGUI()*/
	
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
	
	public void dbRegistry() { //등록 버튼 눌렀을 때
		try { //DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); //SQL문 입력
			
			String title = tfTt.getText().toString();
			String day   = tfDay.getText().toString();
			String time  = tfTime.getText().toString();
			String weather = tfWth.getText().toString();
			String content = taCnt.getText().toString();
			
			//데이터 입력 title-tfTt | day-tfDay | time-tfTime | weather-tfWth | content-taCnt
			stmt.executeUpdate("insert into recordtable values('"+day+"', '"+time+"', '"+weather+"', '"+title+"', '"+content+"');");
			System.out.println(day+" "+time+" 입력 완료");
			
			//JTF 초기화
			tfTt.setText("");
			tfDay.setText("");
			tfTime.setText("");
			tfWth.setText("");
			taCnt.setText("");
			//DB, SQL종료
			stmt.close();
			conn.close();
		
		//예외처리
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint 제약 조건 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbRegistry()*/
}