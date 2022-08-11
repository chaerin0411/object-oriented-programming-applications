import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class ShowGUI extends JFrame {
	/** SerialVersionUID **/
	private static final long serialVersionUID = 1L;

	JButton btnBack, btnSearch, btnDelete, btnInsert;
	JTable table;
	String title, day, time;
	String[][] contents;
	int selectedIndex;
	Connection conn; //DB
	Statement stmt; //SQL문
	ResultSet rs;
	
	public ShowGUI() {
		super("다이어리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		dbShow();
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(350,125));
		c.add(scrollpane);
		
		btnBack = new JButton("돌아가기");
		btnSearch = new JButton("검색");
		btnDelete = new JButton("전체삭제");
		btnInsert = new JButton("글쓰기");
		
		c.add(btnBack);
		c.add(btnSearch);
		c.add(btnDelete);
		c.add(btnInsert);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Diary(); setVisible(false);
			}
		}); //돌아가기 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchGUI(); setVisible(false);
			}
		}); //검색 버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, 
						"데이터를 모두 삭제하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					dbDelete(); new ShowGUI(); setVisible(false);
				} else if (result == JOptionPane.NO_OPTION) {;} else {;}
			}
		}); //전체삭제 버튼
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InputGUI(); setVisible(false);
			}
		}); //글쓰기 버튼
		
		setSize(400,500);
		setVisible(true);
	} /*end-showGUI()*/
	
	public void dbShow() { //데이터 조회
		try { //DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); //SQL문 입력
			
			int len = 0;
			rs = stmt.executeQuery("select count(*) from recordtable;");
			while (rs.next()) { //끝까지 읽어들이기
				len = Integer.parseInt(rs.getString("count(*)"));
			}
			
			rs = stmt.executeQuery("select * from recordtable");
			String[] header = {"글번호","날짜","시간","제목"};
			contents = new String[len][4];
			
			int cnt = 0;
			while (rs.next()) { //끝까지 읽어들이기
				day   = rs.getString("day");
				time  = rs.getString("time");
				title = rs.getString("title");
				
				contents[cnt][0] = Integer.toString(cnt+1);
				contents[cnt][1] = day;
				contents[cnt][2] = time;
				contents[cnt][3] = title;
				cnt++;
			}
			DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
			celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
			
			table = new JTable(contents, header);
			table.getColumn("글번호").setCellRenderer(celAlignCenter);
			table.getColumn("글번호").setPreferredWidth(30);
			table.getColumn("날짜").setCellRenderer(celAlignCenter);
			table.getColumn("날짜").setPreferredWidth(40);
			table.getColumn("시간").setCellRenderer(celAlignCenter);
			table.getColumn("시간").setPreferredWidth(40);
			table.getColumn("제목").setPreferredWidth(200);
			
			//DB, SQL종료
			stmt.close();
			conn.close();
			
		//예외처리
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Constraint 제약 조건 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("조회 에러");
		}

		table.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				JTable jt = (JTable)e.getSource();
				selectedIndex = jt.getSelectedRow();
				System.out.println(contents[selectedIndex][1]+" "+contents[selectedIndex][2]);
				new SelectGUI(contents[selectedIndex][1],contents[selectedIndex][2]);
				setVisible(false);
			}
			public void mousePressed(MouseEvent e) {;}
			public void mouseReleased(MouseEvent e) {;}
			public void mouseEntered(MouseEvent e) {;}
			public void mouseExited(MouseEvent e) {;}
		}); //일기조회
	} /*end-dbShow()*/
	
	public void dbDelete() { //전체삭제
		try { //DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DBConn.dbConnection();
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); //SQL문 입력
			
			//데이터 삭제 title-tfTt | day-tfDay
			stmt.executeUpdate("delete from recordtable;");
			System.out.println("데이터 전체삭제 완료");
			
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