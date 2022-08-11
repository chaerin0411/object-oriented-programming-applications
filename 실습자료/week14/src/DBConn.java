import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection dbConnection() {
		Connection conn;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diary?serverTimezone=UTC", "root", "jennywlgml08080*");
			return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("diary 연결 에러");
			return null;
		}
	}
}