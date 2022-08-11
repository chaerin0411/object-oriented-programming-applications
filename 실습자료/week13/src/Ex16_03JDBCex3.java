import java.io.*;
import java.sql.*;

public class Ex16_03JDBCex3 {
	public static void main(String[] args) {
		Connection conn;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB 연결 완료");
			
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into testtable (name, id, dept) values('아무개', '0893012', '컴퓨터공학');");
			printTable(stmt);
			System.out.println();
			
			stmt.executeUpdate( "update testtable set id='0189011' where name='아무개'");
			printTable(stmt);
			System.out.println();
			
			stmt.executeUpdate("delete from testtable where name='아무개'");
			printTable(stmt);
			System.out.println();
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("SQL 실행 에러");
		}
		
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 13주차 예제 16-3");
	}
	
	private static void printTable(Statement stmt) throws SQLException {
		ResultSet srs = stmt.executeQuery("select * from testtable");
		while (srs.next()) {
		System.out.print(srs.getString("name"));
		System.out.print("\t|\t" + srs.getString("id"));
		System.out.println("\t|\t" + srs.getString("dept"));
		}
	}
}
