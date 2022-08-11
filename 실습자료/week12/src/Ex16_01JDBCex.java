import java.sql.*;

public class Ex16_01JDBCex {
	public static void main (String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB 연결 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버 로드 에러");
		} catch (SQLException e) {
			System.out.println("DB 연결 오류");
		}
		new Ex16_01JDBCex();
		System.out.println("YA 20202865 엄지희");
		System.out.println("객체지향프로그래밍 응용 12주차 예제 16-1");
	}
}
