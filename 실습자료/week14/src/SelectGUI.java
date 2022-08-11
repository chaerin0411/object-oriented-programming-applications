import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SelectGUI extends JFrame {
	/** SerialVersionUID **/
	private static final long serialVersionUID = 1L;

	GridBagLayout gBag;
	JTextField tfTt, tfDay, tfTime, tfWth;
	JTextArea taCnt;
	JButton btnBack, btnDel, btnUpd;
	String title, day, time, weather, content;
	Connection conn; //DB
	Statement stmt; //SQL문
	ResultSet rs;
	
	public SelectGUI(String selectedDate, String selectedTime) {
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
		btnDel = new JButton("일기삭제");
		gbinsert(btnDel,3,11,1,1);
		btnUpd = new JButton("수정");
		gbinsert(btnUpd,4,11,2,1);
		
		dbShow(selectedDate, selectedTime);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ShowGUI(); setVisible(false);
			}
		}); //돌아가기 버튼
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbDelete(selectedDate, selectedTime);
			}
		}); //삭제 버튼
		btnUpd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbUpdate(selectedDate, selectedTime);
			}
		}); //수정 버튼
				
		setSize(400,500);
		setVisible(true);
	} /*end-SelectGUI()*/
	
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
	
	public void dbShow(String selectedDate, String selectedTime) { //데이터 보이기
		try { //DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); //SQL문 입력			
			rs = stmt.executeQuery("select * from recordtable where day='"+selectedDate+"' and time='"+selectedTime+"';");
			while (rs.next()) { //끝까지 읽어들이기
				title = rs.getString("title");
				day   = rs.getString("day");
				time  = rs.getString("time");
				weather = rs.getString("weather");
				content = rs.getString("content");
				//JTF setText
				tfTt.setText(title);
				tfDay.setText(day);
				tfTime.setText(time);
				tfWth.setText(weather);
				taCnt.setText(content);
			}
			//DB, SQL종료
			stmt.close();
			conn.close();
			
		//예외처리
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint 제약 조건 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbShow()*/
	
	public void dbUpdate(String selectedDate, String selectedTime) { //수정 버튼 눌렀을 때
		try { //DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); //SQL문 입력

			title = tfTt.getText().toString();
			day   = tfDay.getText().toString();
			time  = tfTime.getText().toString();
			weather = tfWth.getText().toString();
			content = taCnt.getText().toString();
			
			//데이터 수정 title-tfTt | day-tfDay | time-tfTime | weather-tfWth | content-taCnt
			stmt.executeUpdate("update recordtable set day='"+day+"', time='"+time+"', weather='"+weather+"', title='"+title+"', content='"+content+"' where day='"+selectedDate+"' and time='"+selectedTime+"';");
			System.out.println(day+" "+time+" 수정 완료");
			
			//DB, SQL종료
			stmt.close();
			conn.close();
		
		//예외처리
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint 제약 조건 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbUpdate()*/
	
	public void dbDelete(String selectedDate, String selectedTime) { //일기삭제 버튼 눌렀을 때
		try { //DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); //SQL문 입력
			
			//데이터 삭제 title-tfTt | day-tfDay
			stmt.executeUpdate("delete from recordtable where day='"+selectedDate+"' and time='"+selectedTime+"';");
			System.out.println(day+" "+time+" 수정 완료");
			
			//DB, SQL종료
			stmt.close();
			conn.close();
		
		//예외처리
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint 제약 조건 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbDelete()*/
}