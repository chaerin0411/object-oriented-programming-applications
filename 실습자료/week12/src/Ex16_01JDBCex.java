import java.sql.*;

public class Ex16_01JDBCex {
	public static void main (String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC", "root", "admin");
			System.out.println("DB ���� �Ϸ�");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
		}
		new Ex16_01JDBCex();
		System.out.println("YA 20202865 ������");
		System.out.println("��ü�������α׷��� ���� 12���� ���� 16-1");
	}
}
