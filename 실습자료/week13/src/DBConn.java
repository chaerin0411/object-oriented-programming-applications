import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection dbConnection() {
		Connection conn;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB ���� �Ϸ�");
			return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("sampleDB ���� ����");
			return null;
		}
	}
}
