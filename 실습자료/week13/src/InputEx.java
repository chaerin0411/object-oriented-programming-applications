import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class InputEx extends JFrame {
	JButton btnInsert, btnDelete; //J버튼 입력, 삭제
	JTextField tfId, tfName, tfDept; //입력란 id, name, dept
	Connection conn; //DB
	Statement stmt; //SQL문
	
	public InputEx() { //생성자
		this.setTitle("학생 입력 폼 만들기 예제");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createGUI(); //JButton, JTF 생성
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbInsert();
			}
		}); //입력버튼에 액션리스너 설정
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbDelete();
			}
		}); //삭제버튼에 액션리스너 설정
		this.setSize(300,150); //300 x 150 사이즈
		this.setVisible(true); //눈에 보이게
	} /*end-InputEx()*/
	
	public void createGUI() {
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout()); //FlowLayout - 흐르듯이 배치
		
		c.add(new JLabel("학번")); //학번 입력칸 생성
		tfId = new JTextField(20);
		c.add(tfId);
		
		c.add(new JLabel("이름")); //이름 입력칸 생성
		tfName = new JTextField(20);
		c.add(tfName);
		
		c.add(new JLabel("학과")); //학과 입력칸 생성
		tfDept = new JTextField(20);
		c.add(tfDept);
		
		btnInsert = new JButton("입력"); //입력버튼 생성
		c.add(btnInsert);
		btnDelete = new JButton("삭제"); //삭제버튼 생성
		c.add(btnDelete);
	} /*end-createGUI()*/
	
	public void dbInsert() { //입력버튼 눌렀을 떄
		try { //DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB 연결 완료");
			
			stmt = conn.createStatement(); //SQL문 입력
			String id   = tfId.getText().toString();
			String name = tfName.getText().toString();
			String dept = tfDept.getText().toString();
			
			//데이터 입력 name-tfName | dept-tfDept | id-tfId
			stmt.executeUpdate("insert into testtable values('"+name+"', '"+dept+"', '"+id+"');");
			System.out.println(name + "입력 완료");
			
			//JTF 초기화
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			//DB, SQL종료
			stmt.close();
			conn.close();
			
		} catch (Exception e) { e.printStackTrace(); }
	} /*end-dbInsert*/
	
	public void dbDelete() { //삭제버튼 눌렀을 때
		try { //DB연결
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB 연결 완료");
			stmt = conn.createStatement(); //SQL문 입력
			
			//데이터 삭제 id=inputid인 레코드 삭제
			String inputid = tfId.getText().toString();
			stmt.executeUpdate("delete from testtable where id = '"+inputid+"'");
			System.out.println(inputid+"삭제 완료");
			
			//JTF 초기화
			tfId.setText("");
			tfName.setText("");
			tfDept.setText("");
			//DB, SQL종료
			stmt.close();
			conn.close();
			
		} catch (Exception e) { /*예외처리*/; }
	} /*end-dbDelete*/
	
	public static void main(String[] args) {
		new InputEx(); //생성자 실행
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 12주차 학생관리프로그램 예제");
	}
}
