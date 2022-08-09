/*
 * 객체지향프로그래밍응용 기말 프로젝트 컴퓨터소프트웨어공학과 2-YA 20202296 전채린
 * 영화 예매 프로젝트
 * 회원 정보를 입력하고 영화, 영업점, 시작시간, 좌석을 선택하면 당일 상영 영화를 예매할 수 있는 응용프로그램
 * 입력, 수정, 삭제, 조회, 검색 기능 포함
 * 회원 정보와 영화 예매 데이터를 입력하면 회원 정보와 예매 정보가 데이터베이스에 입력
 * 회원 아이디로 예매 정보 삭제
 * 회원 아이디로 회원 정보와 예매정보 수정
 * 회원, 영화, 예매 테이블 조회
 * 회원 아이디로 회원 정보 검색
 * 영화 제목으로 영화 정보 검색
 * 회원 아이디로 예매 정보 검색
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MovieReservation extends JFrame{
	private JPanel pnNorth, pnCenter, pnSouth, pnEast, pnWest; // 동쪽, 서쪽, 남쪽, 북쪽 패널
	private JButton btnInsert, btnDelete, btnUpdate, btnSelect, btnSearch; // 입력, 삭제, 수정, 조회, 검색 버튼
	private JTextField tfMemberId, tfPwd, tfName, tfPhone,tfAddr, tfSearch; // 회원 정보, 검색 텍스트 필드
	private JRadioButton rbId, rbMovie, rbReservation; // 아이디, 영화, 예매 라디오 버튼
	private JTextArea ta; // 텍스트영역
	
	private JButton[] btnMovies = new JButton[5];
	private JButton[] btnBussinesses = new JButton[13];
	private JButton[] btnStartTime = new JButton[13];
	private JButton[][] btnSits = new JButton[5][5];
	
	private String[][] sitArr = { {"A1", "A2", "A3", "A4", "A5"},
						  {"B1", "B2", "B3", "B4", "B5"},
						  {"C1", "C2", "C3", "C4", "C5"},
						  {"D1", "D2", "D3", "D4", "D5"},
						  {"E1", "E2", "E3", "E4", "E5"} }; // 좌석 배열
	private String[] movieArr = { "컨저링 3", "크루엘라", "캐시트럭", "분노의 질주", "파이프라인" }; // 영화 배열
	private String[] businessArr = { "강남", "미아", "강변", "구로", "목동", "용산아이파크몰", "불광", "대학로", "명동", "왕십리", "성신여대입구", "송파", "영등포" }; // 영업점 배열
	private String[] startTimeArr = { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00" }; // 시작시간 배열
	private String sit; // 선택 좌석
	
	private JComboBox<String> movieCombo = new JComboBox<String>(movieArr); // 영화 콤보박스 생성
	private JComboBox<String> businessCombo = new JComboBox<String>(businessArr); // 영업점 콤보박스 생성
	private JComboBox<String> startTimeCombo = new JComboBox<String>(startTimeArr); // 시작시간 콤보박스 생성
	
	private ImageIcon [] images = { // 영화 이미지 객체 배열
			new ImageIcon("images/movie01.jpg"),
			new ImageIcon("images/movie02.jpg"),
			new ImageIcon("images/movie03.jpg"),
			new ImageIcon("images/movie04.jpg"),
			new ImageIcon("images/movie05.jpg"),
			new ImageIcon("images/movie06.jpg"),
			new ImageIcon("images/movie07.jpg") };
	private JLabel imgLabel = new JLabel(images[0]); // 영화 이미지 레이블 컴포넌트
	
	Connection conn; // DB 연결
	Statement stmt; // SQL 문을 실행하기 위해서는 Statement 클래스를 이용
	ResultSet rs; // SQL 문 실행 결과를 얻어오기 위해서는 ResultSet 클래스를 이용

	public MovieReservation() { // 생성자
		setTitle("영화 예매 프로젝트 컴퓨터소프트웨어공학과 2-YA 20202296 전채린"); // 프레임 타이틀 달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정
		
		createGUI(); // GUI 생성 메소드
		
		btnInsert.addActionListener(new ActionListener() { // 입력 버튼 액션 이벤트 처리			
			@Override
			public void actionPerformed(ActionEvent e) { 
				dbInsert(); // 데이터 삽입 메소드
			}
		});
		btnDelete.addActionListener(new ActionListener() { // 삭제 버튼 액션 이벤트 처리				
			@Override
			public void actionPerformed(ActionEvent e) {
				dbDelete(); // 데이터 삭제 메소드
			}
		});
		btnUpdate.addActionListener(new ActionListener() { // 수정 버튼 액션 이벤트 처리			
			@Override
			public void actionPerformed(ActionEvent e) {
				dbUpdate(); // 데이터 수정 메소드				
			}
		});		
		btnSelect.addActionListener(new ActionListener() { // 조회 버튼 액션 이벤트 처리				
			@Override
			public void actionPerformed(ActionEvent e) {
				dbSelect();	// 데이터 조회 메소드			
			}
		});
		btnSearch.addActionListener(new ActionListener() { // 검색 버튼 액션 이벤트 처리			
			@Override
			public void actionPerformed(ActionEvent e) {
				dbSearch(); // 데이터 검색 메소드
			}
		});

		setSize(1000, 600); // 프레임 크기 1000x600 설정
		setVisible(true); // 화면에 프레임 출력
	}
	
	public void createGUI() { // GUI 생성 메소드
		Container c = getContentPane(); // 프레임의 컨텐트펜
		
		// West
		pnWest = new JPanel(); // 회원가입 패널 생성
		pnWest.setLayout(new GridLayout(0, 2)); // GridLayout 배치관리자 설정
		
		// 회원가입
		pnWest.add(new JLabel("회원 아이디")); // 회원 아이디 레이블을 패널에 부착
		tfMemberId = new JTextField(20); // 회원 아이디 텍스트 필드 생성
		pnWest.add(tfMemberId); // 회원 비밀번호 텍스트 필드를 패널에 부착
		
		pnWest.add(new JLabel("회원 비밀번호")); // 회원 비밀번호 레이블을 패널에 부착
		tfPwd = new JTextField(20); // 회원 비밀번호 텍스트 필드 생성
		pnWest.add(tfPwd); // 회원 비밀번호 텍스트 필드를 패널에 부착
		
		pnWest.add(new JLabel("회원 이름")); // 회원 이름 레이블을 패널에 부착
		tfName = new JTextField(20); // 회원 이름 텍스트 필드 생성
		pnWest.add(tfName); // 회원 이름 텍스트 필드를 패널에 부착
		
		pnWest.add(new JLabel("회원 전화번호")); // 회원 전화번호 레이블을 패널에 부착
		tfPhone = new JTextField(20); // 회원 전화번호 텍스트 필드 생성
		pnWest.add(tfPhone); // 회원 전화번호 텍스트 필드를 패널에 부착
		
		pnWest.add(new JLabel("회원 주소")); // 회원 주소 레이블을 패널에 부착
		tfAddr = new JTextField(20); // 회원 주소 텍스트 필드 생성
		pnWest.add(tfAddr); // 회원 주소 텍스트 필드를 패널에 부착
		
		c.add(pnWest, BorderLayout.WEST); // 컨텐트팬에 pnWest 패널 부착			
			
		// East
		pnEast = new JPanel(); // 좌석 패널 생성	
		pnEast.setLayout(new GridLayout(0, 5)); // GridLayout 배치관리자 설정
				
		// 좌석
		for(int i=0; i<btnSits.length; i++) {
			for(int j=0; j<btnSits[i].length; j++) {
				btnSits[i][j] = new JButton(sitArr[i][j]); // 좌석 버튼 생성
				pnEast.add(btnSits[i][j]); // 좌석 버튼을 패널에 부착
				btnSits[i][j].addActionListener(new ActionListener() { // 액션 이벤트 등록
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton)e.getSource();
						btn.setBackground(Color.GRAY);
						sit = btn.getText(); // 좌석 번호 가져오기
					}
				});
			}
		}
		
		c.add(pnEast, BorderLayout.EAST); // 컨텐트팬에 pnWest 패널 부착
		
		// North
		pnNorth  = new JPanel(); // 레이블 패널 생성
		pnNorth.setLayout(new GridLayout(0, 4)); // GridLayout 배치관리자 설정
		
		
		pnNorth.add(new JLabel("회원가입")); // 회원가입 레이블을 pnNorth 패널에 부착
		pnNorth.add(new JLabel("")); // 레이블을 pnNorth 패널에 부착
		pnNorth.add(new JLabel("예매")); // 예매 레이블을 pnNorth 패널에 부착
		pnNorth.add(new JLabel("좌석 (SCREEN)")); // 좌석 레이블을 pnNorth 패널에 부착
		
		c.add(pnNorth, BorderLayout.NORTH); // 컨텐트팬에 pnNorth 패널 부착

		// Center
		pnCenter = new JPanel(); // 영화 패널 생성
		pnCenter.setLayout(new GridLayout(0, 2)); // GridLayout 배치관리자 설정
				
		// 영화 	
		JPanel pn1 = new JPanel(); // 영화 패널 생성
		
		pn1.add(new JLabel("영화")); // 영화 레이블을 pn1 패널에 부착
		pn1.add(movieCombo); // movieCombo 콤보박스를 pn1 패널에 부착
		
		pnCenter.add(imgLabel); // 영화 이미지 레이블을 pnCenter 패널에 부착
		pnCenter.add(pn1); // pn1 패널을 pnCenter 패널에 부착
		
		movieCombo.addActionListener(new ActionListener() { // 액션 이벤트 등록
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource(); // Action 이벤트가 발생한 콤보박스 알아내기
				int index = cb.getSelectedIndex(); // 콤보박스의 선택된 아이템의 인덱스 번호 알아내기
				imgLabel.setIcon(images[index]); // 인덱스의 이미지를 이미지 레이블 컴포넌트에 출력
			}
		});
	
		// 영업점
		JPanel pn2 = new JPanel(); // 영업점 패널 생성
		
		pn2.add(new JLabel("영업점")); // 영업점 레이블을 pn2 패널에 부착		
		pn2.add(businessCombo); // businessCombo 콤보박스를 pn2 패널에 부착
		
		pnCenter.add(pn2); // pn2 패널을 pnCenter 패널에 부착
		
		// 시작시간
		JPanel pn3 = new JPanel(); // 시작시간 패널 생성
		
		pn3.add(new JLabel("시작시간")); // 시작시간 레이블을 pn3 패널에 부착
		pn3.add(startTimeCombo); // startTimeCombo 콤보박스를 pn3 패널에 부착
		
		pnCenter.add(pn3); // pn5 패널을 pnCenter 패널에 부착
						
		c.add(pnCenter, BorderLayout.CENTER); // 컨텐트팬에 pnCenter 부착
		
		// South
		pnSouth = new JPanel(); // 패널 생성
		pnSouth.setLayout(new BorderLayout(0, 0)); // BorderLayout 배치관리자 설정
						
		JPanel pnBtn = new JPanel(); // 버튼 패널 생성 
		btnInsert = new JButton("입력"); // 입력 버튼 생성
		btnDelete = new JButton("삭제"); // 삭제 버튼 생성
		btnUpdate = new JButton("수정"); // 수정 버튼 생성
		btnSelect = new JButton("조회"); // 조회 버튼 생성
		pnBtn.add(btnInsert); // 입력 버튼을 패널에 부착		
		pnBtn.add(btnDelete); // 삭제 버튼을 패널에 부착	
		pnBtn.add(btnUpdate); // 수정 버튼을 패널에 부착		
		pnBtn.add(btnSelect); // 조회 버튼을 패널에 부착
		
		pnSouth.add(pnBtn, BorderLayout.NORTH); // pnBtn 패널을 pnSouth 패널에 부착
		
		// 검색
		JPanel pnSearch = new JPanel(); // 검색 패널 생성
		pnSearch.setLayout(new BorderLayout(0, 0)); // BorderLayout 배치관리자 설정
		
		JPanel pn4 = new JPanel(); // 패널 생성
		
		tfSearch = new JTextField(20); // 검색 텍스트 필드 생성
		btnSearch = new JButton("검색"); // 검색 버튼 생성		
		pn4.add(tfSearch); // 검색 텍스트 필드를 pn4 패널에 부착
		pn4.add(btnSearch); // 검색 버튼을 pn4 패널에 부착
		
		JPanel pn5 = new JPanel(); // 3개의 라디오버튼을 부착할 패널 생성
		
		ButtonGroup group = new ButtonGroup(); // 버튼 그룹 객체 생성
		rbId = new JRadioButton("아이디", true); // 아이디 라디오 버튼 생성. 초기 선택
		rbMovie = new JRadioButton("영화"); // 영화 라디오 버튼 생성
		rbReservation = new JRadioButton("예매"); // 예매 라디오 버튼 생성		
		group.add(rbId); // 아이디 라디오 버튼을 버튼 그룹에 부착
		group.add(rbMovie); // 영화 라디오 버튼을 버튼 그룹에 부착
		group.add(rbReservation); // 예매 라디오 버튼을 버튼 그룹에 부착
		
		pn5.add(rbId); // 아이디 라디오 버튼을 pn5 패널에 부착
		pn5.add(rbMovie); // 영화 라디오 버튼을 pn5 패널에 부착
		pn5.add(rbReservation); // 예매 라디오 버튼을 pn5 패널에 부착
		
		pnSearch.add(pn4, BorderLayout.NORTH); // pn4 패널을 pnSearch 패널에 부착
		pnSearch.add(pn5, BorderLayout.CENTER); // pn5 패널을 pnSearch 패널에 부착
		
		pnSouth.add(pnSearch, BorderLayout.CENTER); // pnSearch 패널을 pnSouth 패널에 부착
		
		// 정보 출력
		ta = new JTextArea(10, 10); // 텍스트영역 생성
		
		pnSouth.add(ta, BorderLayout.SOUTH); // 텍스트영역을 pnSouth 패널에 부착
				
		c.add(pnSouth, BorderLayout.SOUTH); // 컨텐트팬에 pnSouth 패널 부착

	}
	
	public void dbInsert() { // 데이터 입력 메소드
		try { // 회원가입 정보 입력 및 예매 정보 입력
			conn = DBConn.dbConnection(); // DB 연결
			stmt = conn.createStatement();
			String id = tfMemberId.getText().toString(); // 회원 아이디 텍스트 필드에 입력된 데이터 가져오기
			String pwd = tfPwd.getText().toString(); // 영화 텍스트 필드에 입력된 데이터 가져오기
			String name = tfName.getText().toString(); // 회원 이름 텍스트 필드에 입력된 데이터 가져오기
			String phone = tfPhone.getText().toString(); // 회원 전화번호 텍스트 필드에 입력된 데이터 가져오기
			String addr = tfAddr.getText().toString(); // 회원 주소 텍스트 필드에 입력된 데이터 가져오기
			String title = movieCombo.getSelectedItem().toString(); // 영화 콤보박스에 선택된 데이터 가져오기
			String business = businessCombo.getSelectedItem().toString(); // 영업점 콤보박스에 선택된 데이터 가져오기			
			String startTime = startTimeCombo.getSelectedItem().toString(); // 시작시간 콤보박스에 선택된 데이터 가져오기
			
			stmt.executeUpdate("insert into 회원 values('" + id + "', '" + pwd + "', '" + name + "', '" + phone + "', '" + addr + "');"); // insert 문을 이용하여 데이터 삽입 명령
			stmt.executeUpdate("insert into 예매 values('" + id + "', '" + title + "', '" + business + "', '" + startTime + "', '" + sit + "');"); // insert 문을 이용하여 데이터 삽입 명령
			System.out.println(name + " 회원가입 완료"); // 콘솔에 결과 출력
			System.out.println(name + " 예매 완료"); // 콘솔에 결과 출력
			tfMemberId.setText(""); // 회원 아이디 텍스트 필드 공백으로 설정
			tfPwd.setText(""); // 회원 비밀번호 텍스트 필드 공백으로 설정
			tfName.setText(""); // 회원 이름 텍스트 필드 공백으로 설정
			tfPhone.setText(""); // 회원 전화번호 텍스트 필드 공백으로 설정
			tfAddr.setText(""); // 회원 주소 텍스트 필드 공백으로 설정
			stmt.close(); // stmt 닫기
			conn.close(); // conn 닫기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbDelete() { // 데이터 삭제 메소드
		try { // 회원 아이디로 데이터 삭제
			conn = DBConn.dbConnection(); // DB 연결
			stmt = conn.createStatement();
			String inputid = tfMemberId.getText().toString(); // 회원 아이디 텍스트 필드에 입력된 데이터 가져오기
			stmt.executeUpdate("delete from 예매 where memberid = '" + inputid + "'"); // delete 문을 이용하여 데이터 삭제 명령
			System.out.println(inputid +" 예매 취소"); // 콘솔에 결과 출력
			tfMemberId.setText(""); // 회원 아이디 텍스트 필드 공백으로 설정
			stmt.close(); // stmt 닫기
			conn.close(); // conn 닫기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dbSearch() { // 검색 메소드
		try {
			conn = DBConn.dbConnection(); // DB 연결
			stmt = conn.createStatement(); 
			String searchText = tfSearch.getText().toString(); // 검색 텍스트 필드에 입력된 데이터 가져오기
			String searchSql = "";
			String line = "";
			
			if(rbId.isSelected()) { // 아이디 라디오 버튼이 선택되었을 경우, 입력된 아이디의 회원 정보 출력
				searchSql = "select * from 회원 where memberId = '" + searchText + "';"; // select 문을 이용하여 데이터 조회 명령
				rs = stmt.executeQuery(searchSql); // Statement의 excuteQuery()는 SQL 문을 실행하여 실행 결과를 넘겨줌. 모든 행의 모든 열을 읽어 결과를 rs에 저장
				ta.setText("memberId  pwd  name  phone  addr\n");
				ta.append("--------------------------------------------------------------\n");
				while(rs.next()) { // 다음 행이 있으면 true
					String memberId = rs.getString("memberId");
					String pwd = rs.getString("pwd");
					String name = rs.getString("name");
					String phone = rs.getString("phone");
					String addr = rs.getString("addr");
					line = " | " + memberId + " | " + pwd + " | " + name + " | " + phone + " | " + addr + "\n";
					System.out.println("rs => " + line); // 콘솔에 결과 출력
					ta.append(line); // update 문을 이용하여 데이터 수정 명령
					tfSearch.setText(""); // 검색 텍스트 필드 공백으로 설정
				}
			}
			
			else if(rbMovie.isSelected()) { // 영화 라디오 버튼이 선택되었을 경우, 입력된 영화의 정보 출력
				searchSql = "select * from 영화 where title = '" + searchText + "';"; // select 문을 이용하여 데이터 조회 명령				
				rs = stmt.executeQuery(searchSql); // Statement의 excuteQuery()는 SQL 문을 실행하여 실행 결과를 넘겨줌. 모든 행의 모든 열을 읽어 결과를 rs에 저장
				ta.setText("title  director  actor  phone  addr\n");
				ta.append("--------------------------------------------------------------\n");
				while(rs.next()) { // 다음 행이 있으면 true
					String title = rs.getString("title");
					String director = rs.getString("director");
					String actor = rs.getString("actor");
					String genre = rs.getString("genre");
					String time = rs.getString("time");
					String nation = rs.getString("nation");
					String openDate = rs.getString("openDate");
					line = " | " + title + " | " + director + " | " + actor + " | " + genre + " | " + time + " | " + nation + " | " + openDate + "\n";
					System.out.println("rs => " + line); // 콘솔에 결과 출력
					ta.append(line); // update 문을 이용하여 데이터 수정 명령
					tfSearch.setText(""); // 검색 텍스트 필드 공백으로 설정
				}
			}
			
			else { // 예매 라디오 버튼이 선택되었을 경우, 입력된 아이디의 예매정보 출력
				searchSql = "select * from 예매 where memberId = '" + searchText + "';"; // select 문을 이용하여 데이터 조회 명령
				rs = stmt.executeQuery(searchSql); // Statement의 excuteQuery()는 SQL 문을 실행하여 실행 결과를 넘겨줌. 모든 행의 모든 열을 읽어 결과를 rs에 저장
				ta.setText("memberId  title  businessName  startTime  sit\n");
				ta.append("--------------------------------------------------------------\n");
				while(rs.next()) { // 다음 행이 있으면 true
					String memberId = rs.getString("memberId");
					String title = rs.getString("title");
					String businessName = rs.getString("businessName");
					String startTime = rs.getString("startTime");
					String sit = rs.getString("sit");
					line = " | " + memberId + " | " + title + " | " + businessName + " | " + startTime + " | " + sit + "\n";
					System.out.println("rs => " + line); // 콘솔에 결과 출력
					ta.append(line); // update 문을 이용하여 데이터 수정 명령
					tfSearch.setText(""); // 검색 텍스트 필드 공백으로 설정
				}
			}
		
			stmt.close(); // stmt 닫기
			conn.close(); // conn 닫기
		} catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void dbSelect() { // 데이터 조회 메소드		
		try {
			conn = DBConn.dbConnection(); // DB 연결
			stmt = conn.createStatement();
			
			// 회원 정보 조회
			rs = stmt.executeQuery("select * from 회원;"); // Statement의 excuteQuery()는 SQL 문을 실행하여 실행 결과를 넘겨줌. 모든 행의 모든 열을 읽어 결과를 rs에 저장. select 문을 이용하여 데이터 조회 명령
			String line = "";
			System.out.println("memberId  pwd  name  phone  addr\n");
			System.out.println("--------------------------------------------------------------\n");
			while(rs.next()) { // 다음 행이 있으면 True
				String memberId = rs.getString("memberId");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String addr = rs.getString("addr");
				line = " | " + memberId + " | " + pwd + " | " + name + " | " + phone + " | " + addr + "\n";
				System.out.println("rs => " + line); // 콘솔에 결과 출력
			}
			System.out.println("--------------------------------------------------------------\n");
			
			// 영화 정보 조회
			rs = stmt.executeQuery("select * from 영화;"); // Statement의 excuteQuery()는 SQL 문을 실행하여 실행 결과를 넘겨줌. 모든 행의 모든 열을 읽어 결과를 rs에 저장. select 문을 이용하여 데이터 조회 명령
			line = "";
			System.out.println("title  director  actor  phone  addr\n");
			System.out.println("--------------------------------------------------------------\n");
			while(rs.next()) { // 다음 행이 있으면 True
				String title = rs.getString("title");
				String director = rs.getString("director");
				String actor = rs.getString("actor");
				String genre = rs.getString("genre");
				String time = rs.getString("time");
				String nation = rs.getString("nation");
				String openDate = rs.getString("openDate");
				line = " | " + title + " | " + director + " | " + actor + " | " + genre + " | " + time + " | " + nation + " | " + openDate + "\n";
				System.out.println("rs => " + line); // 콘솔에 결과 출력
			}
			System.out.println("--------------------------------------------------------------\n");
			
			// 예매 정보 조회
			rs = stmt.executeQuery("select * from 예매;"); // Statement의 excuteQuery()는 SQL 문을 실행하여 실행 결과를 넘겨줌. 모든 행의 모든 열을 읽어 결과를 rs에 저장. select 문을 이용하여 데이터 조회 명령
			line = "";
			System.out.println("memberId  title  businessName  startTime  sit\n");
			System.out.println("--------------------------------------------------------------\n");
			while(rs.next()) { // 다음 행이 있으면 True
				String memberId = rs.getString("memberId");
				String title = rs.getString("title");
				String businessName = rs.getString("businessName");
				String startTime = rs.getString("startTime");
				String sit = rs.getString("sit");
				line = " | " + memberId + " | " + title + " | " + businessName + " | " + startTime + " | " + sit + "\n";
				System.out.println("rs => " + line); // 콘솔에 결과 출력
			}
			
			stmt.close(); // stmt 닫기
			conn.close(); // conn 닫기
		} catch(Exception e) {
			e.printStackTrace();
		}			
	}

	public void dbUpdate() { // 데이터 수정 메소드
		try { // 회원 아이디로 예매 정보 수정
			conn = DBConn.dbConnection(); // DB 연결
			stmt = conn.createStatement();
			String in_id = tfMemberId.getText().toString(); // 회원 아이디 텍스트 필드에 입력된 데이터 가져오기
			String in_title = movieCombo.getSelectedItem().toString(); // 영화 콤보박스에 선택된 데이터 가져오기
			String in_business = businessCombo.getSelectedItem().toString(); // 영업점  콤보박스에 선택된 데이터 가져오기			
			String in_startTime = startTimeCombo.getSelectedItem().toString(); // 시작시간  콤보박스에 선택된 데이터 가져오기
			
			stmt.executeUpdate("update 예매 set title = '" + in_title + "', businessName = '" + in_business + "', startTime = '" + in_startTime + "', sit = '" + sit + "' where memberId = '" + in_id + "';"); // update 문을 이용하여 데이터 수정 명령
			System.out.println(in_id + " 수정 완료"); // 콘솔에 결과 출력
			stmt.close(); // stmt 닫기
			conn.close(); // conn 닫기
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println("수정 에러");
		}	
	}

	public static void main(String[] args) {
		new MovieReservation(); // MovieReservation 객체 생성
	}
}
