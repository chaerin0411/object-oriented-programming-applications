import java.sql.*;

public class DBConn {
	public static Connection dbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB ���� �Ϸ�");
			return conn;
		} catch(Exception e) {	
			e.printStackTrace();
			System.out.println("DB ���� ����~~");
			return null;
		}
	}
}

